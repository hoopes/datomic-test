(defproject datomic-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [com.datomic/clj-client "0.8.606"]
                 [mount "0.1.11"]]

  :profiles {:dev {:source-paths ["dev"] }
             :uberjar {:main datomic-test.core
                       :aot :all}})
