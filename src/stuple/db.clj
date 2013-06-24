;; (ns stuple.db
;;   (:require [clojure.java.jdbc :as sql]))

;; (def db {:subprotocol "postgresql"
;;          :subname "//localhost:5432/scorey"
;;          :user "mishadoff"
;;          :password "kasat1k"})

;; (defn select-factorial [id]
;;   (sql/with-connection db
;;     (sql/with-query-results rows
;;       [(str "select * from stuple.factorial where id = " id)]
;;       (into [] rows))))

;; (defn insert-factorial [id value]
;;   (sql/with-connection db
;;     (sql/insert-records :stuple.factorial
;;                         {:id id
;;                          :value value})))
