(ns stuple.utils
  (:require [clojure.java.io :as io])
  (:import [java.io PushbackReader]))

(defn load-properties [filename]
  (with-open [r (-> filename io/resource io/reader)]
    (read (PushbackReader. r))))
