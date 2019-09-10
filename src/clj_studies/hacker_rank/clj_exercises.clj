(ns clj-studies.hacker_rank.clj-exercises)

; Complete the simpleArraySum function below.
(defn simpleArraySum [ar]
  (reduce + ar))

;---------------------------------------------------------------------------------------

; Complete the compareTriplets function below.

(defn- sum-final-score [scores]
  (prn scores)
  (reduce + scores))

(defn- compute-score [my-scores rival-scores]
  (map-indexed (fn [idx score] (if (> score (get rival-scores idx)) 1 0)) my-scores))

(defn compareTriplets [alice bob]
  (let [alice-score (sum-final-score (compute-score alice bob))
        bob-score (sum-final-score (compute-score bob alice))]
    [alice-score bob-score]))

;---------------------------------------------------------------------------------------

; Complete the aVeryBigSum function below.
(defn aVeryBigSum [ar]
  (reduce + ar))

;---------------------------------------------------------------------------------------

;Hello World N Times
(defn hello_word_n_times[n] (dotimes [x n] (print "Hello World")))

;---------------------------------------------------------------------------------------

;List Replication
(defn print-n-times [num lst]
  (let [nums-to-print (flatten (map #(take num (repeat %1)) lst))]
    (doseq [n nums-to-print] (println n))))

;---------------------------------------------------------------------------------------

;Filter Array

(defn filter-less-than [delim lst]
  (filter #(< %1 delim) lst))

;---------------------------------------------------------------------------------------

(defn filter-odd-indexes[lst]
  "Filter Positions in a List"
  (take-nth 2 (rest lst)))

;---------------------------------------------------------------------------------------

(defn list-of-size[n]
  "Array Of N Elements"
  (take n (repeat 1)))

;---------------------------------------------------------------------------------------

(defn reverse-coll [list]
  "Reverse a List - No reverse allowed"
  (reduce conj '() list))

;---------------------------------------------------------------------------------------

(defn sum-of-odds [list]
  "Sum of Odd Elements"
  (reduce + (filter odd? list)))

;---------------------------------------------------------------------------------------

(defn list-length[lst]
  "List Length - No count/equivalent allowed"
  (reduce (fn [acc n] (inc acc)) 0 lst))

;---------------------------------------------------------------------------------------

;https://www.hackerrank.com/challenges/fp-update-list/problem
(defn absolute-number [lst]
  "Update List"
  (map #(Math/abs %) lst))

;---------------------------------------------------------------------------------------

;https://www.hackerrank.com/challenges/eval-ex/problem

(defn fact
  ([n] (fact n 1))
  ([n f]
   (if (<= n 1)
     f
     (recur (dec n) (* f n)))))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [n-itr (range n)]
  (def x (Double/parseDouble (clojure.string/trim (read-line))))
  (println (reduce + (+ 1 x) (map #(/ (Math/pow x %) (fact %)) (range 2 10)))))

;---------------------------------------------------------------------------------------

; https://www.hackerrank.com/challenges/string-mingling/problem

(defn mingle [a b]
  (apply str (mapcat list a b)))

(println (mingle (read-line) (read-line)))

;---------------------------------------------------------------------------------------

; https://www.hackerrank.com/challenges/string-o-permute/problem

(defn permute [txt]
  (let [fst (take-nth 2 txt)
        scd (take-nth 2 (rest txt))]
    (apply str (mapcat vector scd fst))))

(let [n (Integer/parseInt (read-line))]
  (dotimes [x n]
    (println (permute (read-line)))))
