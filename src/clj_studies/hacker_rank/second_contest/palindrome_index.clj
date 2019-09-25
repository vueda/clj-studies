(ns clj-studies.hacker-rank.second-contest.palindrome-index)

;https://www.hackerrank.com/contests/fenixoyota/challenges/palindrome-index
;Palindrome Index

(defn palindrome? [s]
  (= s (clojure.string/reverse s)))

(defn to-string-with-rem-idx [s idx]
  (apply str (concat (subvec (vec s) 0 idx) (subvec (vec s) (inc idx)))))

(defn palindromeIndex [s]
  (if (palindrome? s) -1
    (loop [start 0
           end (dec (count s))]
      (let [start-char (get s start)
            end-char (get s end)]
        (cond (= start-char end-char) (recur (inc start) (dec end))
              (>= start end) -1
              (palindrome? (to-string-with-rem-idx s start)) start
              (palindrome? (to-string-with-rem-idx s end)) end
              :else -1)))))

;(println (to-string-with-replace-idx "abcd" 1 \x))

(println (palindromeIndex "aaab"))
(println (palindromeIndex "baa"))
(println (palindromeIndex "aaa"))
