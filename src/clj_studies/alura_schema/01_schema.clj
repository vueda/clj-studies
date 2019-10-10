(ns clj-studies.alura-schema.01-schema
  (:require [schema.core :as s]))

;Enable validation everywhere
(s/set-fn-validation! true)

(defn add-patient [patients patient]
  (if-let [id (:id patient)]
    (assoc patients id patient)
    (throw (ex-info "Patient needs an id" {:patient patient}))))

(defn add-visit! [visits patient new-visits]
  (swap! visits update-in [patient] concat new-visits))

;Uses schema declaration for param
(s/defn print-report [visits patient :- Long]
  (println "Patient" patient "visits:\n" (get @visits patient)))

(let [visits (atom {})]
  (add-visit! visits 15 [:a :b])
  (add-visit! visits 15 [:c])
  (add-visit! visits 17 [:x :y :z])
  (print-report visits 15))

;schema validate
(s/defn simple-print-long [x :- Long]
  (println x))

(s/defn new-entry [id :- Long name :- s/Str]
  {:id id :name name})

;If you don't pass a value that matches the schema
;it throws an error
;(simple-print-long "3SSSSS")

(println (new-entry 1 "AAA"))
(println (new-entry 1 1))