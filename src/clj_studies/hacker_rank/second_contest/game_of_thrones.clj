(ns clj-studies.hacker-rank.second-contest.game-of-thrones)

;https://www.hackerrank.com/contests/fenixoyota/challenges/game-of-thrones
;Game of Thrones - I

(defn odd-num-chars [s]
  (->> (frequencies s)
       (filter (fn [[_ v]] (odd? v)))
       count))

(defn gameOfThrones [s]
  (if (> (odd-num-chars s) 1) "NO" "YES"))

(println (gameOfThrones "cdcdcdcdeeeef"))
(println (gameOfThrones "cdefghmnopqrstuvw"))

;;vvvvv