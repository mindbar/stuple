(ns stuple.facade
  (:require [stuple.db :as db])
  (:require [stuple.utils :as u]))

;; Just Remote Control for other services
(def stuple-properties (u/load-properties "properties/stuple.edn"))

(defn get-factorial [id]
  (let [rows (db/select-factorial id)]
    (if (= 1 (count rows)) (first rows) {})))

(defn max-factorial []
  (let [rows (db/max-factorial)]
    (if (= 1 (count rows)) (first rows) {})))
  
