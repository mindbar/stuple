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
   [:h1 "Writool"]
   [:ul
    [:li [:a {:href "/synonym"} "Synonyms"]]
    [:li [:a {:href "/translator"} "Translator"]]
    ]))

;; TODO refactor methos
;; TODO pos rendering
(defn synonym-list [word]
  (view-layout
   [:h1 "WordNet synonyms"]
   [:form {:method "post" :action "/synonym"}
    [:input {:type "text" :name "word"}]
    [:input {:type "submit" :value "->"}]]
   (when word
     [:p
      (let [t (s/synonyms word)]
        (if (not (:found t)) "Not found."
            (for [ul (:synonyms t)]
              (list
               [:h4 "Part-of-speech"]
               [:ul
                (for [li ul]
                  [:li (apply str (interpose ", " (:words li)))]
                  )
                ]))))])))