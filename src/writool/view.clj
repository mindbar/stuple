(ns writool.view
  (:use hiccup.core)
  (:use hiccup.page)
  (:require [writool.service :as s]))

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

(defn synonym-main []
  (view-layout
   [:form {:method "post" :action "/synonym"}
    [:input {:type "text" :name "word"}]
    [:input {:type "submit" :value "->"}]]))

(defn synonym-list [word]
  (view-layout
   [:h1 "WordNet synonyms"]
   [:p
    [:ul
     (for [syn (s/synonyms word)]
       [:li syn])
    ]]))