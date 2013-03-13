(ns writool.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [writool.view :as view]))

(defroutes app-routes
  (GET "/" [] (view/writool-main))
  (GET "/synonym" [] (view/synonym-main))
  (POST "/synonym" [word] (view/synonym-list word))
  (GET "/translator" [] "TBD...")
  (route/resources "/")
  (route/not-found "Something wrong...")) ;; provide 404

(def app
  (handler/site app-routes))