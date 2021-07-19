(ns projecteuler.p0041
  (:require [projecteuler.lib :as l]))

;; can we sieve primes up to largest potential pandigital 987654321
(comment

  (time
   (def primes (l/sieve-primes (inc 987654321))))

  (count primes)

  (float
   (/ (* 987654321 4)
      (* 1024 1024 1024)
      ))

  )
