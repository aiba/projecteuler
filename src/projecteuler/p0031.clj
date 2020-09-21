(ns projecteuler.p0031)

(def all-coins [200 100 50 20 10 5 2 1])

(def count-combos
  (memoize
   (fn [n coins]
     (if (zero? n)
       1
       (let [[C & coins'] (filter #(<= % n) coins)]
         (cond
           (nil? C) 0
           (empty? coins') (if (zero? (mod n C)) 1 0)
           :else (let [A (inc (quot n C))]
                   (apply + (for [a (range A)]
                              (count-combos (- n (* a C)) coins'))))))))))

(comment
  (count-combos 200 all-coins)
  )
