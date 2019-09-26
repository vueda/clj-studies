(ns clj-studies.alura-mutability-atoms-refs.05-more-complex-functions
  (:require [clj-studies.alura-mutability-atoms-refs.hospital-model :as hm]
            [clj-studies.alura-mutability-atoms-refs.hospital-logic :as hl])
  (:use [clojure.pprint]))

(defn patient-arrival! [hospital queue patient]
  (swap! hospital hl/new-arrival queue patient))

(defn transfer-patient! [hospital from to]
  (swap! hospital hl/transfer-patient from to))

(defn a-day []
  (let [hospital (atom (hm/create-hospital))]
    (pprint hospital)
    (patient-arrival! hospital :line 1)
    (patient-arrival! hospital :line 2)
    (pprint hospital)
    (transfer-patient! hospital :line :lab-1-line)
    (pprint hospital)
    (patient-arrival! hospital :line 3)
    (pprint hospital)))

(a-day)


(defn juxt-sample []
  (let [peek-pop (juxt peek pop)
        a-list '(1 2 3 4 5)
        [peeked popped] (peek-pop a-list)]
    (pprint peeked)
    (pprint popped)))

(juxt-sample)