(ns clj-studies.alura-record-protocol-multimethod.01-records
  (:use clojure.pprint))

;You can't tell just by looking the params what they are
;Patients can be a list or a map for example
;The data in  the param can have requirements

(defn add-patients [patients patient]
  ())

;A record can be used to shape the data
;It's a class-like structure
;You still don't ensure param data types
(defrecord Patient [id name date-of-birth])

;Creates a Patient with id name and date-of-birth
(pprint (->Patient 1 "Sora" "01/01/2000"))
(pprint (Patient. 2 "Kairi" "02/02/2000"))
(pprint (map->Patient {:id 3 :name "Riku" :date-of-birth "03/03/2000"}))

;Use it like a map
(let [patient (->Patient 1 "Sora" "01/01/2000")
      patient2 (->Patient 2 "Roxas" "01/01/2000")]
  (pprint (:name patient))
  (pprint (assoc patient :keyblade "Kingdom Key"))
  (pprint (= patient patient2))
  (pprint (record? patient))
  (pprint (.name patient2)))