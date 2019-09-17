(ns clj-studies.alura-collections.store-logic)

(defn item-total
  [detail]
  (let [ {qty :quantity
          price :unit-price
          :or {price 0}
          } detail ]
    (* qty price)))

(defn items-total
  [items]
  (->> items
       vals
       (map item-total)
       (reduce +)))

(defn purchase-total
  [items]
  (->> items
       (map :items)
       (map items-total)
       (reduce +)))

(defn purchase-preview
  [[user items]]
  {:user user
   :items (count items)
   :amount (purchase-total items)})

(defn preview
  [purchases]
  (->> purchases
       (group-by :user)
       (map purchase-preview)))
