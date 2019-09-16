(ns clj-studies.book-fn-prog-intro-clojure.-02-fizz-buzz)

;Prints fizz if is divisible by 3
;Prints buzz if is divisible by 5
;Prints fizzbuzz if divisible by both 3 and 5
;Otherwise prints the number itself

;The book solution is simpler than that.
;Try your own solution too!

(defn divisible-by? [divisor dividend]
  (zero? (mod dividend divisor)))

(def divisible-by-three? (partial divisible-by? 3))
(def divisible-by-five? (partial divisible-by? 5))

(def divisible-by-three-and-five?
  (every-pred divisible-by-three? divisible-by-five?))

(defn fizz-buzz [num]
  (cond (divisible-by-three-and-five? num) "fizzbuzz"
        (divisible-by-three? num) "fizz"
        (divisible-by-fivew num) "buzz"
        :else num))