(ns projecteuler.p0007)

(defn primes [n]
  (loop [ps [2]
         i 3]
    (if (= n (count ps))
      ps
      (if (some #(zero? (mod i %)) ps)
        (recur ps (inc i))
        (recur (conj ps i) (inc i))))))

(last (primes 10001))


(comment
  (last (primes 10001))
  )
