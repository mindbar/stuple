(ns writool.wordnet.api
  (:require [clj-http.client :as http]))

(def WORDNET_ENDPOINT "http://wordnetweb.princeton.edu/perl/webwn?s=")

;; Sample output if not found
(def NOT_FOUND {:found false :result nil})

(defn- get-query-url [word]
  (str WORDNET_ENDPOINT word))

;; TODO replace by some good parser
(defn- parse-words [body]
  (first (re-seq #"<ul>(?s).*</ul>" body)))

(defn search [word]
  (let [r (http/get (get-query-url word))]
    (if (= (:status r) 200)
      {:found true :result (parse-words (:body r))}
      NOT_FOUND)))