(ns clj-studies.hacker-rank.second-contest.love-letter-mystery)

;The Love-Letter Mystery
;https://www.hackerrank.com/contests/fenixoyota/challenges/the-love-letter-mystery

(defn theLoveLetterMystery [s]
  (loop [start 0
         end (dec (count s))
         acc 0]
    (let [char-ini (get s start)
          char-fim (get s end)
          diff (Math/abs (- (int char-ini) (int char-fim)))]
      (if (>= start end)
        acc
        (recur (inc start) (dec end) (+ acc diff))))))

(println (theLoveLetterMystery "abcd"))
