(ns clj-studies.alura-mutability-atoms-refs.hospital-logic)

(defn new-arrival [hospital queue patient]
  (update hospital queue conj patient))

(defn attend-patient [hospital queue]
  (update hospital queue pop))