(ns projecteuler.p0002)

(defn fibs []
  (->> [1 2]
       (iterate (fn [[a b]]
                  [b (+ a b)]))
       (map first)))

(->> (fibs)
     (take-while #(<= % 4e6))
     (filter even?)
     (reduce +))
