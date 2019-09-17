(ns clj-studies.alura-collections.-01-recursion-and-tail-recursion)

(def keyblade-wielders ["Sora"  "Riku" "Kairi" "Axel" "Roxas" "Xion" "Mickey" "Aqua" "Ventus" "Terra"])

(println (first keyblade-wielders))                         ;=> "Sora"
(println (rest keyblade-wielders))                          ;=> All but "Sora"
(println (next keyblade-wielders))                          ;=> All but "Sora"
(println (rest []))                                         ;=> ()
(println (next []))                                         ;=> nil

(println (seq []))                                          ;=> nil
(println (seq [1 2 3 4]))                                   ;=> (1 2 3 4)

(def not-nil? (comp not nil?))

;Tail recursion
(defn my-map
  [my-fn coll]
  (let [fst (first coll)]
    (if (not-nil? fst)
      (do
        (my-fn fst)
        (recur my-fn (rest coll))))))

(my-map println keyblade-wielders)