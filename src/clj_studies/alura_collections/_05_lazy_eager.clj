(ns clj-studies.alura-collections._05-lazy-eager
  (:require [clj-studies.alura-collections.store-db :as db]
            [clj-studies.alura-collections.store-logic :as logic]))

(def purchases-preview (logic/preview (db/all-purchases)))

(defn spent-a-lot?
  [prev]
  (if (> (:amount prev) 200) (assoc prev :spent true)))

(println (keep spent-a-lot? purchases-preview))

;Range creates a lazy seq
(println (take 2 (range 100000000)))


(defn print-and-return
  [letter el]
  (println letter el)
  el)

;map works on chunks
(->> (range 1000)
     (map (partial print-and-return "A"))
     (map (partial print-and-return "B")))

;mapv returns a vector
;will execute the entire first map
;and after the second
(->> (range 1000)
     (mapv (partial print-and-return "A"))
     (mapv (partial print-and-return "B")))
