(ns stuple.templates
  (:use [net.cgrand.enlive-html])
  (:require [stuple.facade :as f]))

(deftemplate main-page "temple/main.html" []
  [:span#info] (content (str (:stuple-version f/stuple-properties)))
  )

(deftemplate factorial-page "temple/factorial.html" 
  ([value status]
     [:div#content] (content (str value))
       [:div#error] (content
                     (cond (= status :nan) "Enter valid number"
                           (= status :miss) "We don't have this number yet"
                           :else "")))
  ([]))
  
(deftemplate stat-page "temple/stat.html" []
  [:span#fact-stat] (content (str (:max (f/max-factorial)))))
