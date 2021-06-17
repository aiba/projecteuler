(ns projecteuler.p0041
  (:require [clojure.math.combinatorics :as combo]
            [projecteuler.lib :as l]))

(defn largest-n-digit-pandigital-prime [n]
  (->> (range 1 (inc n))
       reverse
       combo/permutations
       (map reverse)
       (map l/digits->num)
       (filter l/prime?)
       first))

(comment
  (largest-n-digit-pandigital-prime 4)
  )
