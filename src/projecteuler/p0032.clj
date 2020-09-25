(ns projecteuler.p0032
  (:require [projecteuler.lib :refer [digit-seq divisors]]))

(defn pandigital-product [n]
  (let [digits (digit-seq n)
        s (set digits)]
    (when (= (count digits) (count s))
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

  ;; 398085

  )

;; alternate aproach: enumerate the products

;; 987,654,321
;; 9876543

#_(comment
  (time
   (count
    (range 9876543)))
  )

#_(defn pandigital-products []
  (for [a (range 1 100)
        :let [maxb ()]
        ]

    )
  )
