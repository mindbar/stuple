(ns writool.service
  (:require [writool.wordnet.api :as wordnet]))

(defn synonyms [word]
  (wordnet/search word))