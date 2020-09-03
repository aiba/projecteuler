(ns projecteuler.p0029
  (:require [projecteuler.lib :refer [prime-factorization]]))

(defn canon-pow [a b]
  (reduce-kv (fn [m k v]
               (assoc m k (* v b)))
             {}
             (prime-factorization a)))

(let [m 100]
  (count
   (distinct
    (for [a (range 2 (inc m))
          b (range 2 (inc m))]
      (canon-pow a b)))))
