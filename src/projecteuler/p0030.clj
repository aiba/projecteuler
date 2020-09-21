(ns projecteuler.p0030
  (:require [projecteuler.lib :refer [digit-seq]]
            [projecteuler.plot :as p]))

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
  (p/plot-fns! (range 1 7)
               {:max (fn [d] (dec (long (Math/pow 10 d))))
                :sdp5 (fn [d]
                        (let [m (dec (long (Math/pow 10 d)))]
                          (sum-digit-pow m 5)))})
  )

;; max 6 digits
