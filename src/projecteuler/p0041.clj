(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]
            [clj-http.client :as http]
            [criterium.core :as c]
            [projecteuler.lib :as l]))

(def prime-divisors
  (delay (into (sorted-set)
               (l/sieve-primes (long (inc (Math/sqrt 987654321)))))))

(def max-prime-divisor
  (delay (apply max @prime-divisors)))

(defn prime? [n]
  (if (<= n @max-prime-divisor)
    (contains? @prime-divisors n)
    (not (some #(zero? (mod n %)) @prime-divisors))))

(comment
  (count @prime-divisors)
  (last @prime-divisors)
  (peek @prime-divisors)
  )

(comment

  (->> (combo/permutations (reverse (range 1 8)))
       (map reverse)
       (map l/digits->num)
       (filter prime?)
       (first))

  )
