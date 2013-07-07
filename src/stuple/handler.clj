(ns stuple.handler
  (:use [compojure.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [stuple.templates :as temple]
            [stuple.template-manager :as tema]))

(defroutes app-routes
  (GET "/" [] (temple/main-page))
  (GET "/factorial" [] (temple/factorial-page)) ;; empty body here
  (POST "/factorial" [n] (tema/factorial n))
  (GET "/stats" [] (temple/stat-page))
  (route/resources "/")
  (route/not-found "Something wrong...")) ;; provide 404

(def app
  (handler/site app-routes))
