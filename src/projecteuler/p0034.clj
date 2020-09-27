(ns projecteuler.p0034
  (:require [clojure.math.combinatorics :as combo]
            [projecteuler.lib :refer [count-digits defn-memo digit-seq]]
            [projecteuler.plot :as p]))

(defn-memo fact [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (* n (fact (dec n)))))

(defn dfact ^long [^long d]
  (case d
    0      1
    1      1
    2      2
    3      6
    4     24
    5    120
    6    720
    7   5040
    8  40320
    9 362880))

(defn sum-digit-fact ^long [^long n]
  (reduce (fn [^long r, ^long d]
            (+ r (dfact d)))
          0
          (digit-seq n)))

(comment
  (sum-digit-fact 145)
  (sum-digit-fact 111)
  (sum-digit-fact 40585)

  (p/plot-fns! (range 1 9)
               {

                :min-n
                (fn [d] (Math/pow 10 (dec d)))

                #_#_
                :max-n
                (fn [d] (dec (Math/pow 10 d)))

                :max-sdf
                (fn [d]
                  (let [m (dec (long (Math/pow 10 d)))]
                    (sum-digit-fact m)))})
  )

(comment

  (time
   (apply +
          (for [i (range 3 1e7)
                :when (= i (sum-digit-fact i))]
            i)))

  )
