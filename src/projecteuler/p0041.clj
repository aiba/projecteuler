(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]
            [projecteuler.lib :as l]))

;; can we sieve primes up to largest potential pandigital 987654321
(comment

  (time
   (def primes (l/sieve-primes (inc 987654321))))

  (count primes)

  (float
   (/ (* 987654321 4)
      (* 1024 1024 1024)
      ))

  (combo/permutations (range 10))

  )
