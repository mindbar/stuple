(ns writool.wordnet.api
  (:require [net.cgrand.enlive-html :as html]))

(def WORDNET_ENDPOINT "http://wordnetweb.princeton.edu/perl/webwn?s=")

;; Move to common utils?
(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

;; Sample output if not found
(def NOT_FOUND {:found false})

(defn- get-query-url [word]
  (str WORDNET_ENDPOINT word))

(defn select-pos-tags [page]
  (map (comp first :content) (html/select page [:h3])))

(defn select-uls [page]
  (map :content (html/select page [:ul])))

(defn gather-words [ul] ;; ul actually is li
  (rest (rest ;; hack to drop S: and pos
         (map (comp first :content) (html/select ul [:a])))))

;; TODO escape word
;; TODO get meaning
;; TODO word itself handling
(defn search [word]
  (let [page (fetch-url (get-query-url word))
        uls (rest (select-uls page))] ;; rest here drops "\n" element think better approach
    (cond (empty? uls) NOT_FOUND
          :else
          {:found true
           :synonyms
           (for [ul uls] ;; just for list items ;; extract method
             (for [li ul :when (= (:tag li) :li)]
               {:words (gather-words li)
                :meaning ""}))
           :postags (select-pos-tags page)})))
