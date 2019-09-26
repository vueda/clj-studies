(ns clj-studies.alura-mutability-atoms-refs.hospital-logic)

(defn attend? [hospital queue]
  (-> (get hospital queue)
      count
      (< 5)))

(defn new-arrival [hospital queue patient]
  (if (attend? hospital queue)
    (update hospital queue conj patient)
    (throw (ex-info "Queue is full" {:patient patient}))))

(defn attend-patient [hospital queue]
  (update hospital queue pop))

(defn transfer-patient [hospital from to]
  (let [patient (peek (get hospital from))]
    (-> hospital
        (attend-patient from)
        (new-arrival to patient))))