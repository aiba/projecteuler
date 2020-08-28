(ns projecteuler.p0006)

(defn square [n] (* n n))

(let [nums (range 1 101)]
  (- (square (apply + nums))
     (apply + (map square nums))))
