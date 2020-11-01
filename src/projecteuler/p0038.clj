(ns projecteuler.p0038
  (:require [projecteuler.lib :as l]))

(def digits (set (range 1 10)))

(defn digit-product [n m]
  (reduce (fn [ret i]
            (concat (l/digit-seq (* n i)) ret))
          []
          (range 1 (inc m))))

(defn pandigitals [m]
  (doall
   (for [a (range 1 m)
         b (range 2 (l/ceil (/ 9 (l/count-digits a))))
         :let [p (digit-product a b)]
         :when (and (= 9 (count p))
                    (= digits (set p)))]
     [(l/digits->num p) a b])))

(defn max-pandigital [max-digits]
  (loop [a 1
         m 0]
    (let [d (l/count-digits a)
          max-b (l/floor (/ 9 d))]
      (if (< max-b 2)
        m
        (recur (inc a)
               (apply max m (for [b (range 2 (inc max-b))
                                  :let [p (digit-product a b)]
                                  :when (and (= 9 (count p))
                                             (= digits (set p)))]
                              (l/digits->num p))))))))

(comment
  (doall
   (for [a (range 1 m)
         b (range 2 (l/ceil (/ 9 (l/count-digits a))))
         :let [p (pandigit-product a b)]
         :when (and (= 9 (count p))
                    (= digits (set p)))]
     [(l/digits->num p) a b]))
  )

(comment
  (time
   (->> (pandigitals 1e8)
        (sort-by first >)))
  )

(comment
  (time
   (max-pandigital 4))
  )
