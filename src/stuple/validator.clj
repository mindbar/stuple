(ns stuple.validator)

;; TODO find validation library

(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch NumberFormatException e nil)))

(defn parse-bigint [s]
  (try
    (bigint s)
    (catch NumberFormatException e nil)))
