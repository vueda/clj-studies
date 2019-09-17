(ns clj-studies.alura-collections.-04-ordering
  (:require [clj-studies.alura-collections.store-db :as db]
            [clj-studies.alura-collections.store-logic :as logic]))

(def purchases-preview (logic/preview (db/all-purchases)))
(println (sort-by :amount purchases-preview))
(println (reverse (sort-by :amount purchases-preview)))

(println (first purchases-preview))
(println (second purchases-preview))
(println (rest purchases-preview))
(println (count purchases-preview))
(println (class purchases-preview))
(println (nth purchases-preview 1))
(println (get purchases-preview 1))                         ;nil
(println (get [3 6] 1))                                     ;6
(println (take 2 purchases-preview))

(println (some #(> (:amount %) 200) purchases-preview))