(ns stuple.api
  (:require [stuple.facade :as f]))

;; TODO wrap errors
(defn factorial [n]
  (:value (f/get-factorial n)))
