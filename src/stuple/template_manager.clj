(ns stuple.template-manager
  (:require [stuple.facade :as f]
            [stuple.templates :as t]
            [stuple.validator :as v]
            [stuple.utils :as u]))

(defn factorial [n]
  (let [num-parsed (v/parse-int n)]
    (if num-parsed
      (let [value (:value (f/get-factorial num-parsed))]
        (if value
          (t/factorial-page value :ok)
          (t/factorial-page nil :miss)))
      (t/factorial-page nil :nan))))

(defn imbored-add [file title]
  (cond
   (not= "image" (subs (:content-type file) 0 5))
   (t/admin-page "Only image files are allowed")
   
   (empty? (clojure.string/trim title))
   (t/admin-page "Title must be a non-empty")
   
   :else
   (do
     ;; escape title    
     (let [fname (:filename file)]
       (u/write-file (format "resources/public/%s" fname) file)
       (f/add-imbored title fname))
     (t/admin-page nil))))
