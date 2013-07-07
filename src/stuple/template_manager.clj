(ns stuple.template-manager
  (:require [stuple.facade :as f])
  (:require [stuple.templates :as t])
  (:require [stuple.validator :as v]))

(defn factorial [n]
  (let [num-parsed (v/parse-int n)]
    (if num-parsed
      (let [value (:value (f/get-factorial num-parsed))]
        (if value
          (t/factorial-page value :ok)
          (t/factorial-page nil :miss)))
      (t/factorial-page nil :nan))))
