(ns clj-studies.alura-record-protocol-multimethod.04-defmulti-defmethod)

(defrecord ParticularPatient [id name status])

(defrecord HealthPlanPatient [id name status plan])

(defn auth-checker [patient-care]
  (let [patient (:patient patient-care)
        status (:status patient)
        urgent? (= status :urgent)]
    (if urgent? :authorized (class patient))))

(defmulti pre-auth-required? auth-checker)

(defmethod pre-auth-required? :authorized
  [patient]
  false)

(defmethod pre-auth-required? ParticularPatient
  [patient]
  true)

(defmethod pre-auth-required? HealthPlanPatient
  [patient]
  true)

(let [p1 (->ParticularPatient 1 "Sora" :urgent)
      p2 (->HealthPlanPatient 2 "Kairi" :normal {})
      p3 (->HealthPlanPatient 2 "Riku" :urgent {})]
  (println (pre-auth-required? {:patient p1}))
  (println (pre-auth-required? {:patient p2}))
  (println (pre-auth-required? {:patient p3})))