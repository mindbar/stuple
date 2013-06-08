(defproject stuple "0.1"
  :description "A tuple of stupid services"
  :url "TBD"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.1.6"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler stuple.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
