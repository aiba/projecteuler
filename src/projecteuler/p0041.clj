(ns projecteuler.p0041
  (:require [projecteuler.lib :as l]))

;; can we sieve primes up to largest potential pandigital 987654321
(comment
  (time
   (def primes (l/sieve-primes 987654321)))

  (l/sieve-primes 7)

  (count primes)
  )
