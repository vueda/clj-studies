(ns clj-studies.alura-collections.store-db)

(def purchase-one { :user 15
               :items {:backpack {:id :backpack :quantity 2 :unit-price 80.0}
                       :tshirt {:id :tshirt :quantity 3 :unit-price 40.0}
                       :shoes {:id :shoes :quantity 1}}})

(def purchase-two { :user 16
               :items {:backpack {:id :backpack :quantity 1 :unit-price 80.0}
                       :tshirt {:id :tshirt :quantity 1 :unit-price 40.0}}})


(def purchase-three { :user 16
                   :items {:backpack {:id :backpack :quantity 1 :unit-price 80.0}}})

(defn all-purchases [] [purchase-one purchase-two purchase-three])