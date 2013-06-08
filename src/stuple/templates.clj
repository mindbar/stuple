(ns stuple.templates
  (:use [net.cgrand.enlive-html]))
 
(deftemplate main-page "temple/main.html" [n]
  [:title] (content "Hello from enlive!")
  [:div#opts] (content (str n))
  )

;; Static currently
(deftemplate factorial-page "temple/factorial.html" []
  )
