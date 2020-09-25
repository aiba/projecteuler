(ns projecteuler.p0032
  (:require [projecteuler.lib :refer [digit-seq divisors]]))

(defn pandigital-product [n]
  (let [digits (digit-seq n)
        s (set digits)]
    (when (and (not (contains? s 0))
               (= (count digits) (count s)))
      (let [target (remove s (range 1 10))]
        (->> (divisors n)
             (reduce (fn [_ a]
                       (when (and (not= a 1) (not= a n))
                         (let [b (/ n a)]
                           (when (= target (sort (concat (digit-seq a)
                                                         (digit-seq b))))
                             (reduced [a b])))))
                     false))))))

(comment
  (pandigital-product 1)
  (pandigital-product 7254)
  (pandigital-product 9876543)

  (time
   (->> (range 1 (inc 9876543))
        (filter pandigital-product)
        (reduce +)))
  )
