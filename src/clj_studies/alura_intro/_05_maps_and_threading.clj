(ns clj-studies.alura-intro.-05-maps-and-threading)

(def stock { :backpack 5 :tshirt 10})

(println stock)
(println (count stock))
(println (keys stock))
(println (vals stock))
(println (assoc stock :chair 11))
(println (update stock :backpack inc))
(println (dissoc stock :backpack))
(println (:backpack stock))

(def purchase { :backpack {:qtd 10 :amount 70.00}
                :tshirt {:qtd 2 :amount 55.0}})

(println (update-in purchase [:backpack :qtd] inc))
(println (get-in purchase [:tshirt :amount]))

;threading (first)
(println (-> purchase
             :backpack
             :amount))