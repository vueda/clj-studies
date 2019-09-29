(ns clj-studies.alura-record-protocol-multimethod.03-component
  (:require [clojure.pprint :as p :refer [pprint]])
  (:import (java.time LocalDateTime)))

(defn load-patient [id]
  (println "Loading" id "...")
  (Thread/sleep 2000)
  {:id id :created (LocalDateTime/now)})

(defn load-patient-when-not-exists
  [cache id load-fn]
  (if (contains? cache id)
    cache
    (->> (load-fn id)
         (assoc cache id))))

(defprotocol Loadable
  (load! [t id]))

(defrecord Cache
  [cache load-fn]
  Loadable
  (load! [_ id]
    (swap! cache load-patient-when-not-exists id load-fn)
    (get @cache id)))

(let [cache (->Cache (atom {}) load-patient)]
  (p/pprint cache)
  (load! cache 1)
  (load! cache 2)
  (load! cache 3)
  (pprint cache)
  (load! cache 1))