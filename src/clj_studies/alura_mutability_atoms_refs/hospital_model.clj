(ns clj-studies.alura-mutability-atoms-refs.hospital-model
  (:import (clojure.lang PersistentQueue)))

(defn create-hospital []
  {:line       PersistentQueue/EMPTY
   :lab-1-line (conj PersistentQueue/EMPTY 1)
   :lab-2-line PersistentQueue/EMPTY
   :lab-3-line PersistentQueue/EMPTY}
  )