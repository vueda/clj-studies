(ns clj-studies.hacker-rank.second-contest.repeated-string)

;Repeated String
;https://www.hackerrank.com/contests/fenixoyota/challenges/repeated-string

(defn count-a [s]
  (get (frequencies s) \a 0))

(defn repeatedString [s n]
  (let [str-size (count s)
        rest-size (mod n str-size)
        num-a (* (count-a s) (quot n str-size))
        rest-num-a (count-a (subs s 0 rest-size))]
    (+ num-a rest-num-a)))

(println (repeatedString "a" 1000000000000))