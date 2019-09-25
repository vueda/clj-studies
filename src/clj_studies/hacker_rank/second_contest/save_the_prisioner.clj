(ns clj-studies.hacker-rank.second-contest.save-the-prisioner)

;Save the Prisioner!
;https://www.hackerrank.com/contests/fenixoyota/challenges/save-the-prisoner

(defn saveThePrisoner [n m s]
  (let [rem-candies (rem m n)
        from-end (dec (+ s rem-candies))]
    (cond (zero? from-end) n
          (> from-end n) (- from-end n)
          :else from-end)))


(println (saveThePrisoner 5 2 1))
(println (saveThePrisoner 5 2 2))
(println (saveThePrisoner 7 19 2))
(println (saveThePrisoner 3 7 3))
(println (saveThePrisoner 100 99 3))
(println (saveThePrisoner 13 2 13))
