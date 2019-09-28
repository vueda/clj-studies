(ns clj-studies.style-guide.style-guide
  (:require [clojure.string :as str]))

;https://github.com/bbatsov/clojure-style-guide
;https://guide.clojure.style/

;Body indentation with 2 spaces
(when (= 1 1)
  (println "1 = 1"))

;Function and arguments alignment
(filter even?
        [1 2 3])

;One space for args when there are no args in fn line
;*My comment*: Don't like this one very much
(filter
  even?
  (range 1 10))

;Bindings align vertically
(let [thing1 "some stuff"
      thing2 "other stuff"]
  (println thing1 thing2))

;Map - keys alignment
{:thing1 "thing1"
 :thing2 "thing2"}

; Unix line endings
;$ git config --global core.autocrlf true

;Bracket spacing
(println (println "baz") "quux")

;No Commas in Sequential Collection Literals
[1 2 3]                                                     ;Bad [1, 2, 3]

;Optional commas in map
;; good
{:name "Bruce Wayne" :alter-ego "Batman"}

;; good and arguably a bit more readable
{:name      "Bruce Wayne"
 :alter-ego "Batman"}

;; good and arguably more compact
{:name "Bruce Wayne", :alter-ego "Batman"}

;Gather Trailing Parentheses - All trailing parenthesis in the same line
(when (= 1 1)
  (println "AAA"))

;Use a single empty line between top-level forms.
(def x 1)

(defn foo [] 1)

;An exception to the rule is the grouping of related defs together.
(def min-rows 10)
(def max-rows 20)
(def min-cols 15)
(def max-cols 30)

;Avoid blank lines in the middle of a function or macro
;Avoid lines longer than 80 characters
;Avoid trailing whitespaces

;One file per namespace
;(ns foo.bar)

;Avoid single-segment namespaces.
;; (ns example.ns) -------> good

;; (ns example) ----------> Bad

;Avoid the use of overly long namespaces (i.e., more than 5 segments).
;(ns examples.ns
;  (:refer-clojure :exclude [next replace remove]) ----> Same as (refer 'clojure.core <filters>)
;  (:require [clojure.string :as s :refer [blank?]])
;  (:import java.util.Date))

;; better
;(ns examples.ns
;  (:require
;    [clojure.string :as s :refer [blank?]]
;    [clojure.set :as set]
;    [clojure.java.shell :as sh])
;  (:import
;    java.util.Date
;    java.text.SimpleDateFormat
;    [java.util.concurrent Executors
;                          LinkedBlockingQueue]))

;; good
;(ns examples.ns
;  (:require [clojure.string :as s :refer [blank?]]
;            [clojure.set :as set]
;            [clojure.java.shell :as sh])
;  (:import java.util.Date
;           java.text.SimpleDateFormat
;           [java.util.concurrent Executors
;                                 LinkedBlockingQueue]))

;Prefer :require Over :use

;; good
;(ns examples.ns
;  (:require [clojure.zip :as zip]))
;
;;; good
;(ns examples.ns
;  (:require [clojure.zip :refer [lefts rights]]))
;
;;; acceptable as warranted
;(ns examples.ns
;  (:require [clojure.zip :refer :all]))
;
;;; bad
;(ns examples.ns
;  (:use clojure.zip))

;Optional New Line After Fn Name
;; good
(defn foo
  [x]
  (println x))

(defn foo [x]
  (println x))

;Multimethod Dispatch Val Placement

;(defmethod foo :bar [x] (println x))
;
;(defmethod foo :bar
;  [x]
;  (println x))

;Optionally omit the new line between the argument vector and a short function body.

;Indent each arity form of a function definition vertically aligned with its parameters.

(defn foo
  "I have two arities."
  ([x]
   (println x 1))
  ([x y]
   (+ x y)))

;Sort the arities of a function from fewest to most arguments.

;Function Length
;Avoid functions longer than 10 LOC (lines of code). Ideally, most functions will be shorter than 5 LOC.

;Function Positional Parameters Limit
;Avoid parameter lists with more than three or four positional parameters.

;Prefer function pre and post conditions to checks inside a function’s body.
(defn do-something [x]
  {:pre  [(odd? x)]
   :post [(= % 2)]}
  (+ x 1))

(do-something 3)

;;;;;;;;;;;;;;;;;;;;;;;

;; good
(defn foo [x]
  {:pre [(pos? x)]}
  (println x))

;; bad
(defn foo [x]
  (if (pos? x)
    (println x)
    (throw (IllegalArgumentException. "x must be a positive number!"))))

;Avoid the use of namespace-manipulating functions like require and refer outside REPL

;Forward References
;Avoid forward references. They are occasionally necessary, but such occasions are rare in practice.

;Declare
;Use declare to enable forward references when forward references are necessary.

;Prefer higher-order functions like map to loop/recur.

;Don’t define vars inside functions.
;; very bad
;(defn foo []
;  (def x 5)
;  ...)

;Don’t shadow clojure.core names with local bindings.
;; bad - clojure.core/map must be fully qualified inside the function
;(defn foo [map]
;  ...)

;Use alter-var-root instead of def to change the value of a var.
;; good
(def thing 1)                                               ; value of thing is now 1
; do some stuff with thing
(alter-var-root #'thing (constantly nil))                   ; value of thing is now nil

;; bad
(def thing 1)
; do some stuff with thing
(def thing nil)
; value of thing is now nil

;Use seq as a terminating condition to test whether a sequence is empty (this technique is sometimes called nil punning).
;; good
(defn print-seq [s]
  (when (seq s)
    (prn (first s))
    (recur (rest s))))

;; bad
(defn print-seq [s]
  (when-not (empty? s)
    (prn (first s))
    (recur (rest s))))

;Converting Sequences to Vectors
;; good
(vec (seq '(1 2 3)))

;; bad
(into [] '(1 2 3))

;Use when instead of (if …​ (do …​)).
;; good
(when (= 1 1)
  (println "1")
  (println "2"))

;; bad
(if (= 1 1)
  (do
    (println "1")
    (println "2")))

;Use if-let instead of let + if.
;; good
(if-let [result (:b {:b 1})]
  (println result)
  (println "else"))

;; bad
(let [result (:b {:b 1})]
  (if result
    (println result)
    (println "else")))

;Use when-let instead of let + when.

;; good
;(when-let [result (foo x)]
;  (do-something-with result)
;  (do-something-more-with result))
;
;; bad
;(let [result (foo x)]
;  (when result
;    (do-something-with result)
;    (do-something-more-with result)))

;Use if-not instead of (if (not …​) …​).
;; good
(if-not (= 1 1)
  (println "A"))

;; bad
(if (not (= 1 1))
  (println "A"))

;Use when-not instead of (when (not …​) …​).
;; good
;(when-not pred
;  (foo)
;  (bar))

;; bad
;(when (not pred)
;  (foo)
;  (bar))

;Use when-not instead of (if-not …​ (do …​)).
;; good
;(when-not pred
;  (foo)
;  (bar))

;; bad
;(if-not pred
;  (do
;    (foo)
;    (bar)))

;Use not= instead of (not (= …​)).
;; good
(not= 1 2)

;; bad
(not (= 1 2))

;Use printf instead of (print (format …​)).

;Flexible comparison function
(< 5 x 10)

;Prefer % over %1 in function literals with only one parameter.
#(Math/round %)

;Prefer %1 over % in function literals with more than one parameter.
#(Math/pow %1 %2)

;Don’t wrap functions in anonymous functions when you don’t need to.
;; good
(filter even? (range 1 10))

;; bad
(filter #(even? %) (range 1 10))

;Favor the use of complement versus the use of an anonymous function.
;Complement returns the opposite value of the given fn

;; good
;(filter (complement some-pred?) coll)

;; bad
;(filter #(not (some-pred? %)) coll)

;Favor comp over anonymous functions for function composition.

(map (comp str/capitalize str/trim) ["top " " test "])

;Favor partial over anonymous functions for currying.

;Prefer the use of the threading macros -> (thread-first) and ->> (thread-last) to heavy form nesting.

;Use :else as the catch-all test expression in cond.

;Prefer condp instead of cond when the predicate & expression don’t change.
;; good
(cond
  (= x 10) :ten
  (= x 20) :twenty
  (= x 30) :thirty
  :else :dunno)

;; much better
(condp = x
  10 :ten
  20 :twenty
  30 :thirty
  :dunno)

;Prefer case instead of cond or condp when test expressions are compile-time constants.
(case x
  10 :ten
  20 :twenty
  30 :forty
  :dunno)

;Use short forms in cond and related. If not possible give visual hints for the
;pairwise grouping with comments or empty lines.

;; good
(remove #{1} [0 1 2 3 4 5])

;; bad
(remove #(= % 1) [0 1 2 3 4 5])

;; good
(count (filter #{\a \e \i \o \u} "mary had a little lamb"))

;; bad
(count (filter #(or (= % \a)
                    (= % \e)
                    (= % \i)
                    (= % \o)
                    (= % \u))
               "mary had a little lamb"))

;Use (inc x) & (dec x) instead of (+ x 1) and (- x 1).

;Use (pos? x), (neg? x) & (zero? x) instead of (> x 0), (< x 0) & (= x 0).

;Use list* instead of a series of nested cons invocations.
;; good
(list* 1 2 3 [4 5])

;; bad
(cons 1 (cons 2 (cons 3 [4 5])))

;Sugared Java Interop
(java.util.ArrayList. 100)
(Math/pow 2 10)
(.substring "hello" 1 3)

;Compact Metadata Notation For True Flags
;; good
(def ^:private a 5)

;; bad
(def ^{:private true} a 5)

;Denote private parts of your code.

;; good
(defn- private-fun [] ...)

(def ^:private private-var ...)

;When naming namespaces favor the following two schemas:
;  project.module
;  organization.project.module

;Use CamelCase for protocols, records, structs, and types. (Keep acronyms like HTTP, RFC, XML uppercase.)

;The names of predicate methods (methods that return a boolean value) should end in a question mark (e.g., even?).

;The names of functions/macros that are not safe in STM transactions should end with an exclamation mark (e.g. reset!).

;Use -> instead of to in the names of conversion functions.
;(defn f->c ...)

;Use earmuffs for things intended for rebinding (ie. are dynamic).
;(def ^:dynamic *a* 10)

;Use _ for destructuring targets and formal argument names whose value will be ignored by the code at hand.
(let [[a b _ c] [1 2 3 4]]
  (println a b c))

;Idiomatic Names
;Follow clojure.core's example for idiomatic names like pred and coll.
;in functions:
;   f, g, h - function input
;   n - integer input usually a size
;   index, i - integer index
;   x, y - numbers
;   xs - sequence
;   m - map
;   s - string input
;   re - regular expression
;   coll - a collection
;   pred - a predicate closure
;   & more - variadic input
;   xf - xform, a transducer
;in macros:
;   expr - an expression
;   body - a macro body
;   binding - a macro binding vector

;Data Structures

;Avoid the use of lists for generic data storage (unless a list is exactly what you need).

;Prefer the use of keywords for hash keys.

;Prefer the use of the literal collection syntax where applicable. However, when defining sets, only use literal syntax
; when the values are compile-time constants.
[1 2 3]
#{1 2 3}
(hash-set (func1) (func2))                                  ; values determined at runtime

;Avoid accessing collection members by index whenever possible.

;Prefer the use of keywords as functions for retrieving values from maps, where applicable.
;(:name m)

;Avoid Java Collections and Arrays

;Types & Records
;Constructors. Don't use interop syntax (.)
(defrecord Foo [a b])
(deftype Bar [a b])

;; good
(->Foo 1 2)
(map->Foo {:b 4 :a 3})
(->Bar 1 2)

;Add custom type/record constructors when needed (e.g. to validate properties on record creation).

;Don’t override the auto-generated type/record constructor functions

(defrecord Foo [num])

;; good
(defn make-foo
  [num]
  {:pre [(pos? num)]}
  (->Foo num))

;; bad
(defn ->Foo
  [num]
  {:pre [(pos? num)]}
  (Foo. num))

(def a (ref 0))

(dosync
  (io! (println "hello"))
  (alter a inc))
;IllegalStateException I/O in transaction

(dosync
  (println "hello")
  (alter a inc))

;Avoid the use of ref-set whenever possible.

(def r (ref 0))

;; good
(dosync (alter r + 5))

;; bad
(dosync (ref-set r 5))

;Try to keep the size of transactions (the amount of work encapsulated in them) as small as possible.

;Avoid having both short- and long-running transactions interacting with the same Ref.

;Agents

;Use send only for actions that are CPU bound and don’t block on I/O or other threads.
;Use send-off for actions that might block, sleep, or otherwise tie up the thread.

;Atoms

;Avoid atom updates inside STM transactions.
;Try to use swap! rather than reset!, where possible.

;Strings
;Prefer string manipulation functions from clojure.string over Java interop or rolling your own.

;Exceptions

;Reuse existing exception types. Idiomatic Clojure code — when it does throw an exception — throws an exception of
;a standard type
;(e.g. java.lang.IllegalArgumentException, java.lang.UnsupportedOperationException,
;      java.lang.IllegalStateException, java.io.IOException).

;Favor with-open over finally. -> It's like try with resources in Java

; Comments
;;;; Frob Grovel

;;; This section of code has some important implications:
;;;   1. Foo.
;;;   2. Bar.
;;;   3. Baz.

(defn fnord [zarquon]
  ;; If zob, then veeblefitz.
  (quux zot
        mumble             ; Zibblefrotz.
        frotz))


;TODO
;Use TODO to note missing features or functionality that should be added at a later date.

;FIXME
;Use FIXME to note broken code that needs to be fixed.

;OPTIMIZE
;Use OPTIMIZE to note slow or inefficient code that may cause performance problems.

;HACK
;Use HACK to note "code smells" where questionable coding practices were used and should be refactored away.

;REVIEW
;Use REVIEW to note anything that should be looked at to confirm it is working as intended.
;For example: REVIEW: Are we sure this is how the client does X currently?