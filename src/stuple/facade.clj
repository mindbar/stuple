(ns stuple.facade
  (:require [stuple.db :as db])
  (:require [stuple.validator :as v])
  (:require [stuple.utils :as u]))

;; Just Remote Control for other services
(def stuple-properties (u/load-properties "resources/properties/stuple.edn"))

(defn get-factorial [id]
  (let [rows (db/select-factorial id)]
    (if (= 1 (count rows)) (first rows) {})))

(defn max-factorial []
  (let [rows (db/max-factorial)]
    (if (= 1 (count rows)) (first rows) {})))
  
;; Admin Methods
(defn next-factorial []
  (let [i (:max (max-factorial)) ;; FIXME bigdec here
        next-value (*' (inc' i) (v/parse-bigint (:value (get-factorial i))))]
    (db/insert-factorial (inc' i) next-value) 
    (u/redirect "/admin")))


;; imbored
(defn get-imbored []
  (let [rows (db/imbored-random)]
    (if (= 1 (count rows)) (first rows) {})))

(defn add-imbored [title image]
  (db/imbored-insert title image))

(defn imbored-count []
  (db/imbored-count))
