(ns clj-studies.alura-intro.-01-first-functions)

;Define a symbol with some value
(def total-items 15)

; Comma "," are optional. They are considered spaces
(def stock ["Backpack", "T-Shirt"])

;Get the element with index 1
(stock 1)

;conj joins the contents of stock with the param
;The result is a new vector with all the elements
;The list referenced in stock does not change
(println (conj stock "Shoes"))                              ; ["Backpack" "T-Shirt" "Shoes"]
(println stock)                                             ; ["Backpack" "T-Shirt"]
(count stock)                                               ;=> 2

;Define our own functions
(defn welcome-to-estoque
  []
  (println "-----")
  (println "Welcome to the stock"))

;A pure function has no side effects
;Given an input the output is always the same
;It depends only of its parameters
;It doesn't realize actions like access to a database, or external calls
(defn discounted-value
  "Applies 10% discount to the price"
  [price]
  (* price (- 1 0.1)))

(discounted-value 100)                                      ;=> 90
