(ns projecteuler.p0001)

(->> (range 1 1000)
     (filter (fn [n]
               (or (zero? (mod n 3))
                   (zero? (mod n 5)))))
     (reduce +))
