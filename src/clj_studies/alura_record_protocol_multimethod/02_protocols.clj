(ns clj-studies.alura-record-protocol-multimethod.02-protocols
  (:import (java.util Date)))

(defprotocol Chargeable
  (need-pre-auth? [patient procedure]))

(defrecord ParticularPatient [id name])
(defrecord HealthPlanPatient [id name plan])

;Define protocol on record creation
(defrecord ParticularPatient [id name]
  Chargeable
  (need-pre-auth? [_ procedure]
    (> (:value procedure) 50)))

;Extend after
;(extend-type ParticularPatient
;  Chargeable
;  (need-pre-auth? [_ procedure]
;    (> (:value procedure) 50)))

(extend-type HealthPlanPatient
  Chargeable
  (need-pre-auth? [patient procedure]
    (let [patient-coverage (get-in patient [:plan :coverage])
          procedure-type (:type procedure)]
      (not-any? #(= % procedure-type) patient-coverage))))

(let [patient (->ParticularPatient 1 "Sora")
      other-patient (->HealthPlanPatient 2 "Kairi" {:coverage [:x-ray :blood-test]})
      procedure {:type :x-ray :value 90.5}]
  (if (need-pre-auth? patient procedure)
    (println "Needs an authorization")
    (println "No authorization needed"))

  (println "---")

  (if (need-pre-auth? other-patient procedure)
    (println "Needs an authorization")
    (println "No authorization needed")))


(defprotocol Dateable
  (->ms [t]))

(extend-type Number
  Dateable
  (->ms [t] t))

(extend-type Date
  Dateable
  (->ms [t] (.getTime t)))

(println (->ms 56))
(println (->ms (Date.)))