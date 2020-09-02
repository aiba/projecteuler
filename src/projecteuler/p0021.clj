(ns projecteuler.p0021
  (:require [clojure.math.combinatorics :as combo])
  (:import [java.util ArrayList List]))

(set! *warn-on-reflection* true)

(def init-primes [2 3])
(def primes* (ArrayList. ^List init-primes))

(defn next-prime! []
  (let [primes ^ArrayList primes*]
    (loop [i (.get primes (dec (.size primes)))]
      (if (some #(zero? (mod i %)) primes)
        (recur (inc i))
        (do (.add primes i)
            i)))))

(def all-primes
  (concat init-primes
          (repeatedly next-prime!)))

(comment
  (time (last (take 10 (primes))))
  (time (last (take 1000 (primes))))
  (time (last (take 10000 (primes))))
  )

(declare prime-factors)
(def prime-factors
  (memoize
   (fn [n]
     (let [max-p (int (Math/sqrt n))
           p (loop [[p & ps] all-primes]
               (when (<= p max-p)
                 (if (zero? (mod n p))
                   p
                   (recur ps))))]
       (if (nil? p)
         (list n)
         (cons p (prime-factors (/ n p))))))))

(comment
  (prime-factors 10)

  (combo/subsets (prime-factors 220))

  (time
   (prime-factors (int 1e6)))
  (time
   (prime-factors (int 1e9)))
  )

(defn divisors [n]
  (->> n
       prime-factors
       combo/subsets
       (map #(reduce * 1 %))
       (distinct)
       (sort)))

(defn proper-divisors [n]
  (remove #{n} (divisors n)))

(defn amicable? [a]
  (let [d (fn [n] (apply + (proper-divisors n)))
        b (d a)]
    (and (not= a b)
         (= a (d b)))))

(comment
  (->> (range 2 10000)
       (filter amicable?)
       (apply +)
       )
  )
