(ns projecteuler.p0030
  (:require [projecteuler.lib :refer [digit-seq]]))

(defn sum-digit-pow [n p]
  (->> n
       digit-seq
       (reduce (fn [r d]
                 (+ r (long (Math/pow d p))))
               0)))

(comment
  (sum-digit-pow 111 5)
  (sum-digit-pow 112 5)
 )

(comment
  (for [i (range 30)]
    [i (sum-digit-pow i 4)])
  )
