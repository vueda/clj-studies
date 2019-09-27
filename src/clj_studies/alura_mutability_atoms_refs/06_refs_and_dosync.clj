(ns clj-studies.alura-mutability-atoms-refs.06-refs-and-dosync
  (:use [clojure.pprint])
  (:import (clojure.lang PersistentQueue)))

(defn can-attend? [line]
  (< (count line) 5))

(defn arrive-on-wait-line [line patient]
  (if (can-attend? line)
    (conj line patient)
    (throw (ex-info "Line is full" {:line line
                                    :patient patient}))))

;(ref-set line (arrive-on-wait-line @line patient))
(defn new-arrival! [hospital patient]
  (let [line (get hospital :line)]
    (alter line arrive-on-wait-line patient)))

(defn a-day []
  (let [hospital {:line (ref PersistentQueue/EMPTY)
                  :lab1 (ref PersistentQueue/EMPTY)
                  :lab2 (ref PersistentQueue/EMPTY)}]
    (dosync
      (pprint hospital)
      (new-arrival! hospital 1)
      (new-arrival! hospital 2)
      (new-arrival! hospital 3)
      (new-arrival! hospital 4)
      (new-arrival! hospital 5)
      (pprint hospital)
      (new-arrival! hospital 6)
      (pprint hospital))))

;(a-day)

;Uses future. It is something that will be done asynchronously
(defn new-arrival-async! [hospital patient]
  (future
    (Thread/sleep (rand 5000))
    (dosync
      (println "Trying patient" patient)
      (new-arrival! hospital patient))))


(defn an-async-day []
  (let [hospital {:line (ref PersistentQueue/EMPTY)
                  :lab1 (ref PersistentQueue/EMPTY)
                  :lab2 (ref PersistentQueue/EMPTY)}]
    (dotimes [patient 5]
      (new-arrival-async! hospital patient))))

(an-async-day)