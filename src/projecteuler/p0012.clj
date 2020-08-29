(ns projecteuler.p0012
  (:import java.util.ArrayList
           java.util.List))

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
  (time
   (prime-factors (int 1e6)))
  (time
   (prime-factors (int 1e9)))
  )

(defn prime-factorization [n]
  (frequencies (prime-factors n)))

(comment
  (prime-factorization 10)
  )

(defn count-divisors [n]
  (->> (prime-factorization n)
       (vals)
       (map inc)
       (reduce * 1)))

(defn triangle-nums []
  (->> [1 1]
       (iterate (fn [[n i]]
                  (let [i (inc i)]
                    [(+ n i) i])))
       (map first)))

(comment
  (time
   (->> (triangle-nums)
        (filter #(< 500 (count-divisors %)))
        (first)))
  )
