(ns clj-studies.learnclojureinyminutes.learnclojure
  (:import (java.time LocalDate)))

;https://learnxinyminutes.com/docs/clojure/

;String
(str "Hello" " " "World")

;Math
(+ 1 1)
(- 2 1)
(* 2 3)
(/ 4 2)

;Equality
(= 1 1)
(= 2 1)

;not
(not true)

;Nested forms
(+ 1 (- 3 2))

;Uses Java object types
(class 1)
(class 1.)
(class "")
(class false)
(class nil)

;To create a literal list use ' or quote to stop it from being evaluated
'(+ 1 2)
(quote (+ 1 2))

;Eval
(eval '(+ 1 2))

;Collections are Java classes too
;Vectors is array-backed
(class [1 2 3])

;Lists are linked-list data structures
(class '(1 2 3))
(class (list 1 2 3))

;Collections are group of data
;Examples below are true
(coll? '(1 2 3))
(coll? [1 2 3 ])
(coll? {})

;Sequences are abstract description of list data
(seq? '(1 2 3))

;A seq provide an entry when accessed
;So seq can be lazy and provide infinite series

(range 4)
(range)
(take 5 (range))

;Add to the beginning of list or vector
(cons 4 [1 2 3])
(cons 4 '(1 2 3 ))

;Conj will add in the most efficient way
;At the end for vector
;At the beginning for lists
(conj [1 2 3] 4)
(conj '(1 2 3) 4)

;Concat add lists or vectors together
(concat [1 2 3] '(4 5))

;Filter, map and reduce

(map inc [1 2 3])
(filter even? [1 2 3 4])
(reduce + 0 [1 2 3])
(reduce conj [] '(3 2 1))

;Functions
(fn hello [] "Hello")

((fn hello [] "Hello"))

;Creates a global var in the current namespace
(def x 1)

(def hello (fn [] "HELLO"))
(hello)

(defn hello [] "HELLO")

(defn hello-someone [name] (str "Hello " name))
(hello-someone "Sora")

(def hello-shortened #(str "Hello " %))
(hello-shortened "Kairi")

(defn hello-default
  ([] "Hello Default")
  ([name] (str "Hello " name)))

(hello-default)
(hello-default "Riku")

(defn hello-extra-args [name & args]
  (str "Hello " name ". I got " (count args) " args. Args: " args))

(hello-extra-args "Roxas" "Axel" "Xion" "Saix")

; Hash maps and array maps share an interface. Hash maps have faster lookups
; but don't retain key order.
(class {:a 1 :b 2 :c 3}) ; => clojure.lang.PersistentArrayMap
(class (hash-map :a 1 :b 2 :c 3)) ; => clojure.lang.PersistentHashMap
; Arraymaps will automatically become hashmaps through most operations
; if they get big enough, so you don't need to worry.

; Maps can use any hashable type as a key, but usually keywords are best
; Keywords are like strings with some efficiency bonuses
(class :a) ; => clojure.lang.Keyword

(assoc {} :key "value")
(dissoc {:a 1 :b 2} :b)

(class #{1 2 3}) ; => clojure.lang.PersistentHashSet
(set [1 2 3 1 2 3 3 2 1 3 2 1]) ; => #{1 2 3}

; Test for existence by using the set as a function:
(#{1 2 3} 1) ; => 1

; There are more functions in the clojure.sets namespace.

; Use let to create temporary bindings
(let [a 1 b 2]
  (> a b)) ; => false

; Group statements together with do
(do
  (print "Hello")
  "World")

; Functions have an implicit do
(defn print-and-say-hello [name]
  (print "Saying hello to " name)
  (str "Hello " name))
(print-and-say-hello "Jeff") ;=> "Hello Jeff" (prints "Saying hello to Jeff")

; So does let
(let [name "Urkel"]
  (print "Saying hello to " name)
  (str "Hello " name)) ; => "Hello Urkel" (prints "Saying hello to Urkel")

; Thread first

(->
  {:a 1 :b 2}
  (assoc :c 3)
  (dissoc :b))

; Thread last. Inserts the result of
; each line at the *end* of the form. This is useful for collection
; operations in particular:
(->>
  (range 10)
  (map inc)
  (filter odd?)
  (into []))

; as-> allows to choose where the result from the previous form will be placed
(as-> [1 2 3] input
      (map inc input)
      (nth input 2)
      (conj [4 5 6] input [8 9 10]))

;Use all fn's from the module
(use 'clojure.set)
(intersection #{1 2 3} #{2 3 4})
(difference #{1 2 3} #{2 3 4})

;Use only a subset o fn's
(use '[clojure.set :only [intersection]])

;Import a module
(require 'clojure.string)
(clojure.string/blank? "")

; You can give a module a shorter name on import
(require '[clojure.string :as str])
(str/blank? "")

; You can use require (and use, but don't) from a namespace using :require.
; You don't need to quote your modules if you do it this way.
;(ns test
;  (:require
;    [clojure.string :as str]
;    [clojure.set :as set]))

(import java.time.LocalDate java.util.Date java.util.HashMap)
(LocalDate/now)                                             ;Static method access
(Date.)
(.getTime (Date.))

(doto (HashMap.)
  (.put "a" 1)
  (.put "b" 2))

;STM -> Software Transaction Memory

; Software Transactional Memory is the mechanism clojure uses to handle
; persistent state. There are a few constructs in clojure that use this.

; An atom is the simplest. Pass it an initial value
(def my-atom (atom {}))
(swap! my-atom assoc :a 1)
@my-atom
(deref my-atom)

