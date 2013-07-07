(ns stuple.db
  (:require [clojure.java.jdbc :as sql])
  (:require [stuple.utils :as u]))

(def db (u/load-properties "resources/properties/db.edn"))

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
