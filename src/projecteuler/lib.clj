(ns projecteuler.lib
  (:require [clojure.math.combinatorics :as combo]
            [taoensso.encore :as enc])
  (:import [java.util ArrayList List]))

(set! *warn-on-reflection* true)

;; memo-fn —————————————————————————————————————————————————————————————————————————

(defn fix [f] (fn g [& args] (apply f g args)))

(defmacro fn-memo [fname args & body]
  `(fix
    (memoize
     (fn [~fname ~@args]
       (do ~@body)))))

(comment
  (time
   (let [fibo (fn-memo fibo [n]
                (if (< n 2)
                  n
                  (+ (fibo (dec n)) (fibo (- n 2)))))]
     (fibo 40)))
  )

(defmacro defn-memo [fname & ftail]
  `(def ~fname (fn-memo ~fname ~@ftail)))

;; —————————————————————————————————————————————————————————————————————————————————

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
  (time (last (take 10 all-primes)))
  (time (last (take 1000 all-primes)))
  (time (last (take 10000 all-primes)))
  )

(defn sieve-primes [m]
  (let [a (long-array (range m))]
    (aset a 0 -1)
    (aset a 1 -1)
    (doseq [i (range m)
            :when (pos? (aget a i))
            j (range (* i 2) m i)]
      (aset a j -1))
    (filter pos? a)))

(defn-memo prime-factors [n]
  (let [max-p (int (Math/sqrt n))
        p (loop [[p & ps] all-primes]
            (when (<= p max-p)
              (if (zero? (mod n p))
                p
                (recur ps))))]
    (if (nil? p)
      (list n)
      (cons p (prime-factors (/ n p))))))

(comment
  (prime-factors 10)
  (prime-factors 16)
  (combo/subsets (prime-factors 220))
  )

(defn-memo divisors [n]
  (->> n
       prime-factors
       combo/subsets
       (map #(reduce * 1 %))
       (sort)))

(defn proper-divisors [n]
  (remove #{n} (divisors n)))

(comment
  (divisors 24)
  (proper-divisors 24)
  )

(defn prime? [n]
  (loop [[p & ps] all-primes]
    (cond
      (= p n) true
      (> p n) false
      :else   (recur ps))))

(comment
  (prime? 3)
  (prime? 383)
  (prime? 384)
  )

(defn prime-factorization [n]
  (frequencies (prime-factors n)))

(comment
  (prime? 409)
  (prime-factorization 32)
  )

(defn digit-seq [n]
  (loop [r (transient [])
         n n]
    (if (< n 10)
      (persistent! (conj! r n))
      (recur (conj! r (mod n 10))
             (quot n 10)))))

(comment

  (digit-seq 523423)

  (for [n (range 0 1e4)
        :when (not= (digit-seq n)
                 (digit-seq-3 n))]
    n)

  (let [n 987654321]
    (enc/qb [4 1e5]
            (count (digit-seq n))
            (count (rev-digit-seq n))))

  )

(defn count-digits [n]
  (inc (long (Math/floor (Math/log10 n)))))
