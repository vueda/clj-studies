(ns clj-studies.alura-collections.-03-other-fn-with-maps
  (:require [clj-studies.alura-collections.store-db :as s.db]
            [clj-studies.alura-collections.store-logic :as s.logic]))

(println (s.logic/preview (s.db/all-purchases)))