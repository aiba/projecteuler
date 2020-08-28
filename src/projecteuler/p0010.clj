(ns projecteuler.p0010)

(defn sieve-primes [m]
  (let [a (long-array (range m))]
    (aset a 0 -1)
    (aset a 1 -1)
    (doseq [i (range m)
            :when (pos? (aget a i))
            j (range (* i 2) m i)]
      (aset a j -1))
    (filter pos? a)))

;; (apply + (sieve-primes 2e6))
