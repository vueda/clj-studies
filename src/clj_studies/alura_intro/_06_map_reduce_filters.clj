(ns clj-studies.alura-intro.-06-map-reduce-filters)


(def purchase { :backpack {:qtd 10 :amount 70.00}
               :tshirt {:qtd 2 :amount 55.0}
               :keychain {:qtd 1}})

(defn product-total [product]
  (* (:qtd product) (:amount product 0)))

(->> purchase
     vals
     (map product-total)
     (reduce +)
     println)

(defn free? [product]
  (zero? (:amount product 0)))

(def paid? (comp not free?))

(println (filter free? (vals purchase)))
(println (filter paid? (vals purchase)))