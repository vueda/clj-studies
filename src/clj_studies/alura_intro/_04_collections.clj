(ns clj-studies.alura-intro.-04-collections)

;vectors

(def prices [30 1000 150])

(println (prices 1))                                        ;=> 1000
(println (get prices 0))                                    ;=> 30

;(prices 5)                                                 ;ArrayIndexOutOfBoundsEx
(println (get prices 10))                                   ;=> nil
(println (get prices 10 0))                                 ;=> 0

;conj adds to the end of a vector
(println (conj prices 5))                                   ;=> [30 1000 150 5]

(println (update prices 0 inc))

(def a-range (range 10))

;Map, filter and reduce
(println (map inc a-range))
(println (filter odd? a-range))
(println (reduce + a-range))
(println (reduce + 1 a-range))