(ns clj-studies.alura-mutability-atoms-refs.01-vector-list-set-queue
  (:require [clj-studies.alura-mutability-atoms-refs.hospital-model :as hm]
            [clj-studies.alura-mutability-atoms-refs.hospital-logic :as hl])
  (:use [clojure.pprint])
  (:import (clojure.lang PersistentQueue)))

;Vectors add to the end and remove on the end
(defn test-vector []
  (let [line [1 2 3]]
    (println line)
    (println (conj line 4))
    (println (pop line))))

;Lists add and remove from the start
(defn test-list []
  (let [line '(1 2 3)]
    (println line)
    (println (conj line 4))
    (println (pop line))))

;Sets doesn't allow repeat values
;It doesn't store elements in a sorted order
;You can't (pop #{1 2}) since it's not a
;clojure.lang.IPersistentStack

(defn test-set []
  (let [line #{1 2 3}]
    (println line)
    (println (conj line 3))
    (println (conj line 4))))

; PersistentQueue is FIFO
(defn test-queue []
  (let [line (conj PersistentQueue/EMPTY 1 2 3)]
    (pprint line)
    (pprint (conj line 4))
    (pprint (peek line))
    (pprint (pop line))))

(test-vector)
(test-list)
(test-set)
(test-queue)

;This def is a problem since it represents a global state
;Multiple threads using it can cause concurrency problems
(def hospital (hm/create-hospital))
(defn hospital-day []
  (println "Hospital opened")
  (pprint hospital)
  (pprint (hl/new-arrival hospital :line 2))
  (pprint (hl/attend-patient hospital :lab-1-line))
  (pprint (hl/new-arrival hospital :lab-1-line 6)))

;(hospital-day)

;Java interop. Thread run
(defn execute-in-thread []
  (.start (Thread. #(do (Thread/sleep (rand)) (println "Hi"))))
  (.start (Thread. #(do (Thread/sleep (rand)) (println "Hi")))))

(execute-in-thread)