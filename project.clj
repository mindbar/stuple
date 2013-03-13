(defproject writool "0.0.1"
  :description "Writool: Tools for Writers"
  :url "TBD"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.2"]
                 [clj-http "0.6.5"]
                 [enlive "1.1.1"] ;; TODO check if we can remove hiccup and replace with enlive templates
                 ]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler writool.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
