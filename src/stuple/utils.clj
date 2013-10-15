(ns stuple.utils
  (:require [clojure.java.io :as io])
  (:require [ring.util.response :as ring])
  (:import [java.io PushbackReader]))

(defn load-properties [filename]
  (with-open [r (-> filename io/resource io/reader)]
    (read (PushbackReader. r))))

(defn write-file [fname file]
  (with-open [w (io/output-stream fname)]
    (io/copy (io/file (:tempfile file)) w)))

(defn redirect [addr]
  (ring/redirect addr))
