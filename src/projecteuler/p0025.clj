(ns projecteuler.p0025)

(comment
  (->> [1N 1N]
       (iterate (fn [[a b]]
                  [b (+ a b)]))
       (map first)
       (map #(count (str %)))
       (take-while #(< % 1000))
       (count)
       (inc))
  )
