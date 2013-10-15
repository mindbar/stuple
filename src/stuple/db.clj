(ns stuple.db
  (:require [clojure.java.jdbc :as sql])
  (:require [stuple.utils :as u]))

;; TODO bindings or some clojure sql client

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

(defn insert-factorial [id value]
  (sql/with-connection db
    (sql/insert-values "stuple.factorial" ["id" "value"]
                       [id value])))

(defn imbored-insert [title image]
  (sql/with-connection db
    (sql/insert-values "stuple.imbored" ["title" "image"]
                       [title image])))

(defn imbored-random []
  (sql/with-connection db
    (sql/with-query-results rows
      [(str "SELECT title, image FROM stuple.imbored ORDER BY RANDOM() LIMIT 1")]
      (into [] rows))))

(defn imbored-count []
  (-> (sql/with-connection db
        (sql/with-query-results rows
          [(str "SELECT count(*) as cnt FROM stuple.imbored")]
          (into [] rows)))
      first
      :cnt))
