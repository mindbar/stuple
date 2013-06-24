(ns stuple.facade)
;  (:require [stuple.db :as db]))

;; Just Remote Control for other services

;; (defn get-factorial [id]
;;   (let [rows (db/select-factorial id)]
;;     (if (= 1 (count rows)) (first rows) {})))
  

(defn get-factorial [id] {:value (+ id 100)})
