(ns stuple.handler
  (:use [compojure.core])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [stuple.templates :as temple]))

(defroutes app-routes
  (GET "/" [] (temple/main-page ))
  (GET "/factorial" [] (temple/factorial-page "0")) ;; empty body here
  (POST "/factorial" [n] (temple/factorial-page n))
  (GET "/" [] (temple/stat-page))
  (route/resources "/")
  (route/not-found "Something wrong...")) ;; provide 404

(def app
  (handler/site app-routes))
