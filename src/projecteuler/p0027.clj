(ns projecteuler.p0027
  (:require [projecteuler.lib :as lib]))

(def prime? (memoize lib/prime?))

(defn primes-generated [a b]
  (->> (range)
       (map (fn [n]
              (+ (* n n) (* a n) b)))
       (take-while prime?)
       count))

(comment

  (primes-generated 1 41)
  (primes-generated -79 1601)

  (let [m 1000]
    (->> (for [a (range (- (dec m)) m)
               b (range (- m) (inc m))]
           [a b])
         (apply max-key (fn [[a b]] (primes-generated a b)))
         (apply *)))

  )
