(ns projecteuler.p0037
  (:require [projecteuler.lib :refer [digit-seq digits->num prime?]]))

(defn t-prime? [n]
  (and (< 9 n)
       (prime? n)
       (let [digits (digit-seq n)]
         (every? (fn [i]
                   (println (take i digits))
                   (println (drop i digits))

                   (and (prime? (digits->num (take i digits)))
                        (prime? (digits->num (drop i digits)))))
                 (range 1 (count digits))))))

(comment
  (t-prime? 3)
  (t-prime? 11)
  (t-prime? 23)
  (t-prime? 3797)
  )
