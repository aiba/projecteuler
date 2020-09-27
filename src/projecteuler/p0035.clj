(ns projecteuler.p0035
  (:require [projecteuler.lib :refer [count-digits sieve-primes]]))

(defn rotations [n]
  (let [d (count-digits n)
        m (long (Math/pow 10 (dec d)))]
    (loop [r (transient [])
           n n
           i 0]
      (if (= i d)
        (persistent! r)
        (let [n' (+ (* 10 (mod n m))
                    (quot n m))]
          (recur (conj! r n') n' (inc i)))))))

(comment
  (count
   (let [m 1e6
         primes (set (sieve-primes m))]
     (for [p primes
           :when (every? primes (rotations p))]
       p)))
  )
