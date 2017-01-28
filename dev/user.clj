(ns user
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.pprint :refer (pprint)]
            [clojure.repl :refer :all]
            [clojure.test :as test]
            [clojure.tools.namespace.repl :refer (refresh refresh-all)]
            [mount.core :as mount]
            [datomic-test.core])) ; for side-effects from require

(defn go
  "Initializes the current development system and starts it running."
  []
  (mount/start))

(defn reset []
  (mount/stop)
  (refresh :after 'user/go))
