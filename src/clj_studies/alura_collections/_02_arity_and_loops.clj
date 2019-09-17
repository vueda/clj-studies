(ns clj-studies.alura-collections.-02-arity-and-loops)

(def keyblade-wielders ["Sora"  "Riku" "Kairi" "Axel" "Roxas" "Xion" "Mickey" "Aqua" "Ventus" "Terra"])

(defn my-count
  ([coll] (my-count 0 coll))
  ([acc coll]
   (if (seq coll)
     (recur (inc acc) (rest coll))
     acc)))

(println (my-count 0 keyblade-wielders))
(println (my-count keyblade-wielders))


(defn my-other-count
  [coll]
  (loop [acc 0
         rest-coll coll]
    (if (seq rest-coll)
      (recur (inc acc) (rest rest-coll))
      acc)))

(println (my-other-count keyblade-wielders))