(ns clj-studies.alura-mutability-atoms-refs.03-atoms-and-retries
  (:use [clojure.pprint])
  (:require [clj-studies.alura-mutability-atoms-refs.hospital-logic :as hlogic])
  (:import (clojure.lang PersistentQueue)))


;Creates an atom. Atoms provide a way to manage shared, synchronous, independent state
;deref (same as @) to get value
;swap! change the atom value
;The ! is a convention that represents fn with side-effects
;swap! retries when it fails because the atom has changed during execution
(defn atom-test []
  (let [my-hospital (atom {:line PersistentQueue/EMPTY})]
    (pprint my-hospital)
    (pprint (deref my-hospital))
    (pprint @my-hospital)
    (swap! my-hospital assoc :lab-1-line PersistentQueue/EMPTY)
    (pprint @my-hospital)
    (swap! my-hospital update :lab-1-line conj 1 2)
    (pprint @my-hospital)
    (swap! my-hospital hlogic/new-arrival :lab-1-line 3)
    (swap! my-hospital hlogic/new-arrival :lab-1-line 4)
    (swap! my-hospital hlogic/new-arrival :lab-1-line 5)
    (pprint @my-hospital)))

(atom-test)

