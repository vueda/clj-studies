(ns clj-studies.hacker-rank.second-contest.gemstones)

;Gem Stones
;https://www.hackerrank.com/contests/fenixoyota/challenges/gem-stones

(defn gemstones [arr]
  (->> arr
       (map set)
       (map #(apply str %))
       (apply str)
       frequencies
       (filter (fn [[_ v]] (= v (count arr))))
       count))

(println (gemstones ["abcdde" "baccd" "eeabg"]))
