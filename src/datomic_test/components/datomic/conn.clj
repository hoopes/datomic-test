(ns datomic-test.components.datomic.conn
  (:require [clojure.core.async :refer [<!!]]
            [datomic.client :as client]))

(def db-params
  {:db-name    "datomic-test"
   :account-id client/PRO_ACCOUNT
   :access-key "hoopes-key"    ; what the peer server was started with
   :secret     "hoopes-secret" ; what the peer server was started with
   :endpoint   "localhost:8998"
   :region     "none" ; ???
   :service    "peer-server"})

(defn connect! []
  (println "Connnnnnnnnnnnecting.........")
  (let [conn (<!! (client/connect db-params))]
    (println "Datomic connected")
    conn))
