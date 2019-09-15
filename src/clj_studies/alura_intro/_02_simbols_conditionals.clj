(ns clj-studies.alura-intro.-02-simbols-conditionals)

;Let declares a symbol with a value visible only inside
;the "let block"
(defn discounted-value
  "Applies 10% discount to the price if it's higher than 100"
  [price]
  (if (> price 100)
    (let [discount-tax 0.1]
      (* price (- 1 discount-tax)))
    price))

(class 10N)                                                 ;BigInt
(class 10M)                                                 ;BigDecimal
