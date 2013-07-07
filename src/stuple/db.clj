(ns stuple.db
  (:require [clojure.java.jdbc :as sql])
  (:require [clojure.java.io :as io])
  (:import [java.io PushbackReader]))

(def db (with-open [r (io/reader "resources/properties/db.edn")]
          (read (PushbackReader. r))))

(defn select-factorial [id]
  (sql/with-connection db
    (sql/with-query-results rows
      [(str "select * from stuple.factorial where id = " id)]
      (into [] rows))))

(defn max-factorial []
  (sql/with-connection db
    (sql/with-query-results rows
      [(str "select max(id) from stuple.factorial")]
      (into [] rows))))
