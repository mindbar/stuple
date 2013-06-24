(ns stuple.templates
  (:use [net.cgrand.enlive-html])
  (:require [stuple.facade :as f]))
 
(deftemplate main-page "temple/main.html" []
  [:div#opts] (content (str 6))
  )

;; Static currently
(deftemplate factorial-page "temple/factorial.html" [n]
  [:div#content] (content (str (:value (f/get-factorial (read-string n)))))
  )

(deftemplate stat-page "temple/stat.html" []
  )

;; Temp
(defn parse-int [n]
  (read-string n))
