(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]))

(defn n-digit-pandigital-prime [n]
  (->> (range 1 (inc n))
       reverse
       combo/permutations
       (map )
       (filter (fn [n]
                 (prime? )
                 ))
       )

  )

(comment
  (combo/permutations (reverse (range 1 (inc n))))
  )
