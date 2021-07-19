(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]
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



  (prime? 27)
  (prime? 7)

  (mod 27 3)
  (let [n 27]
    (contains? @prime-divisors n))

  (take 10 @prime-divisors)
  (contains? @prime-divisors 27)

  (c/quick-bench (peek [1 2 3]))

  (let [a (into (sorted-set) [1 2 3])]
    (c/quick-bench (last a)))

  (for [n (combo/permutations [3 2 1])]

    )


  )

()
;; can we sieve primes up to largest potential pandigital 987654321
(comment

  (time
   (def primes (l/sieve-primes (long (inc (Math/floor (Math/sqrt 987654321)))))))

  (count primes)

  (float
   (/ (* 987654321 4)
      (* 1024 1024 1024)
      ))

  (combo/permutations (range 10))

  )
