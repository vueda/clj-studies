(ns clj-studies.book-fn-prog-intro-clojure._01_intro)

;Exercises and notes from the book Programação Funcional: Uma introdução em Clojure
;https://www.casadocodigo.com.br/products/livro-programacao-funcional-clojure

;Some info from http://clojure-doc.org/articles/tutorials/introduction.html and
;http://clojure-doc.org/articles/tutorials/getting_started.html as well

;Reload a namespace with
;my-proj.core=> (require 'my-proj.core :reload)

;lein repl

;Clojure syntax is Lisp like. It is made up of expressions that evaluate to some value
;Expressions in bracket are also referred as forms
;Below are some expressions
10                                                          ;=> 10
"Hello World!"                                              ;=> "Hello World!"
(+ 1 2)                                                     ; 3

;Can contain sub-expressions
;Executes from inside to outside
(+ 3 (* 3 3))                                               ;=> 12

;See the doc of function (doc some-fn)

;See the source code (source some-fn)

;Concatenate strings

(str "Hello, " "World" "!")

;Comparisons

(= 3 (+ 1 2))                                               ;=> true
(= "Hello" "Hey")                                           ;=> false
(= 2 (+ 1 1) (/ 4 2))                                       ;=> true
(not= 1 3)                                                  ;=> true

;Some other things you can do
(even? 2)                                                   ;=> true
(mod 9 3)                                                   ;=> 0

;Identifiers name things

(def keyblade-master "Aqua")
(println keyblade-master)                                   ;=> prints "Aqua"

;You can use _<>!?* too for naming

;Create your own functions
(defn say [word]
  (println (str "You said " word "!")))

(say "Hi")                                                  ;=> prints "You said Hi!"

;Namespaces are like Java packages. They group functions. Namespace + Function name is that function identifier
;This is a namespace (ns clj-studies.book-fn-prog-intro-clojure._01_intro)

;Scalars
;https://softwareengineering.stackexchange.com/a/238045
;he term "scalar" comes from linear algebra, where it is used to differentiate a single number from a vector or matrix.
; The meaning in computing is similar. It distinguishes a single value like an integer or float from a data
; structure like an array.
; This distinction is very prominent in Perl, where the $ sigil (which resembles an 's') is used to denote a scalar
; variable and an @ sigil (which resembles an 'a') denotes an array. It doesn't have anything to do with the type of
; the element itself. It could be a number, character, string, or object. What matters to be called a scalar is that
; there is one of them

;
nil
true
false
1                                                           ; integer
1N                                                          ; arbitrary-precision integer
1.2                                                         ; float/double/decimal
1.2M                                                        ; arbitrary-precision decimal
1.2e4                                                       ; scientific notation
1.2e4M                                                      ; sci notation of arbitrary-precision decimal
0x3a                                                        ; hex literal (58 in decimal)
1/3                                                         ; Rational number, or "ratio".
\a                                                          ; The character "a".
"hi"                                                        ; A string.
#"^foo\d?$"                                                 ; A regular expression.
:foo                                                        ; A keyword. Refers to itself. Used as keys in a map i.e.
'foo                                                        ; A symbol. Name of something, not it's value

;Conditionals

(if (even? 2) "Two is even!" "2 is not even?")              ;=> "Two is even!"

(cond (< 1 2) "1 < 2"
      (> 4 3) "4 > 3"
      :else' "2")                                           ;=> "1 < 2" - Returns on the first condition met


(cond (= 1 2) "1  2"
      (= 4 3) "4 = 3"
      :else "ELSE")                                         ;=> "ELSE" - The keyword evaluates to true. Could be any
                                                            ;other keyword or truthy value

