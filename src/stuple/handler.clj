(ns stuple.handler
  (:use [compojure.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [stuple.templates :as temple]
            [stuple.template-manager :as tema]
            [ring.adapter.jetty :as jetty])
  (:gen-class))

(defroutes app-routes
  (GET "/" [] (temple/main-page))
  (GET "/factorial" [] (temple/factorial-page)) ;; empty body here
  (POST "/factorial" [n] (tema/factorial n))
  (GET "/stats" [] (temple/stat-page))
  (route/resources "/")
  (route/not-found "Something wrong...")) ;; provide 404

(def app
  (-> app-routes
      handler/site))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))
