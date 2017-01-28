(ns datomic-test.components.datomic
  (:require [mount.core :refer [defstate]]
            [datomic-test.components.datomic.conn :as c]
            [clojure.core.async :refer [<!!]]
            [datomic.client :as client]))

(defstate conn :start (c/connect!))

(defn transact [tx-data]
  (client/transact conn {:tx-data tx-data}))

(defn query [query]
  (let [db (client/db conn)]
    (<!! (client/q conn {:query query :args [db]}))))
