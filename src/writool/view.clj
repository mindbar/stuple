(ns writool.view
  (:use hiccup.core)
  (:use hiccup.page))

(defn view-layout [& content]
  "Common behaviour for HTML page"
  (html
   [:head
    [:meta {:http-equiv "Content-type"
            :content "text/html; charset=utf-8"}]
    [:title "writool"]
    ;; CSS and JS go there
    ]
   [:body content]))

(defn writool-main []
  (view-layout
   [:h1 "Writool"]))