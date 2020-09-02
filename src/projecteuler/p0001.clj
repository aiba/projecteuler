(ns projecteuler.p0001)

(time
 (->> (range 1 1000)
      (filter (fn [n]
                (or (zero? (mod n 3))
                    (zero? (mod n 5)))))
      (reduce +)))

(time
 (->> (range 0 1000 3)
      (concat (range 0 1000 5))
      (distinct)
      (reduce +)))
