(ns clj-studies.alura-intro.-03-anonymous-fn-lambdas)

; Alt + Shift + L => loads a file when running REPL in IntelliJ

(println "Hello")

; Alt + Shift + P evaluate current expression in REPL
(println "World")

;alt + shift + K turns
; (println) (+ 1 3) into
; (println (+ 1 3))

; alt+ shift + J turns
; (println (+ 1 3)) into
; (println) (+ 1 3)

;Predicate
(defn price-higher-than-100?
  [price]
  (> price 100))

(defn discounted-value
  "Applies 10% discount to the price if it's higher than 100"
  [apply-discount? price]
  (if (apply-discount? price)
    (let [discount-tax 0.1]
      (* price (- 1 discount-tax)))
    price))

;High Order Fn -> Receive or return function
(println (discounted-value price-higher-than-100? 1000))
(println (discounted-value price-higher-than-100? 100))

;Anonymous Fn
(println (discounted-value (fn [price] (> price 100)) 1000))
(println (discounted-value #(> % 100) 1000))
