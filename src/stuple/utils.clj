(ns stuple.utils
  (:require [clojure.java.io :as io])
  (:import [java.io PushbackReader]))

(defn load-properties [filename]
  (with-open [r (io/reader filename)]
    (read (PushbackReader. r))))
