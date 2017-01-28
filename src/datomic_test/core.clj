(ns datomic-test.core
  (:require [mount.core :as mount]
            [datomic-test.components.datomic :as d]))

(defn -main [& args]
  (mount/start))
