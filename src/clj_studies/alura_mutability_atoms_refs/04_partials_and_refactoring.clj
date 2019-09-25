(ns clj-studies.alura-mutability-atoms-refs.04-partials-and-refactoring)

(def numbers-atom (atom []))

(defn conj-number! [atm num]
  (swap! atm conj num))

;Partial application allows to inform only part of the params
;It returns another function that receives the parameters
;no informed yet
(def conj-num-to-atom! (partial conj-number! numbers-atom))

(defn do-something []
  (let [numbers [1 2 3 4 5]]
    (map conj-num-to-atom! numbers)                         ;Map is lazy
    (println @numbers-atom)                                 ;So this prints nothing
    (mapv conj-num-to-atom! numbers)                        ;mapv is not lazy
    (println @numbers-atom)                                 ;So it prints the numbers
    (reset! numbers-atom [])                                ;Just reset the atom to it's initial state
    (println @numbers-atom)
    (doseq [n numbers]                                      ;Uses doseq to execute conj-number! to all numbers
      (conj-number! numbers-atom n))
    (println @numbers-atom)
    (dotimes [n 10]                                         ;Execute "n" times
      (conj-number! numbers-atom n))
    (println @numbers-atom)))

(do-something)