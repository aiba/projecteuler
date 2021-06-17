(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]
            [projecteuler.lib :as l]))

(defn n-digit-pandigital-prime [n]
  (->> (range 1 (inc n))
       reverse
       combo/permutations
       (map l/digits->num)
       (take 3)))

(comment
  (combo/permutations (reverse (range 1 (inc n))))
  )
