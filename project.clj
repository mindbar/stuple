(defproject stuple "0.0.1"
  :description "A tuple of stupid services"
  :url "http://stuple.mind-bar.com"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring "1.1.6"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [ring/ring-jetty-adapter "1.1.0"]]
  :plugins [[lein-ring "0.8.3"]]
  :ring {:handler stuple.handler/app}
  :profiles
  {:dev 
   {:dependencies [[ring-mock "0.1.3"]]}}
  :main stuple.handler)
