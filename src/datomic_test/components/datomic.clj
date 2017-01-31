(ns datomic-test.components.datomic
  (:require [mount.core :refer [defstate]]
            [datomic-test.components.datomic.conn :as c]
            [clojure.core.async :refer [<!!]]
            [datomic.client :as client]))

(defstate conn :start (c/connect!))

(defn transact [tx-data]
  "Create a transaction in datomic. This is the 'PUT' of the system

  FIXME: What am i returning?"
  (client/transact conn {:tx-data tx-data}))

(defn query [query]
  "Use core.async to take the value off of the channel returned
    by client/q. This function should return the actual value(s)
    queried for.

  Requires a datalog query (a list of them?) as its argument.

  This is basically the 'GET' of the system.

  FIXME: More documentation"
  (let [db (client/db conn)]
    (<!! (client/q conn {:query query :args [db]}))))
