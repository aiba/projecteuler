(ns projecteuler.p0005)

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn divisible-by-all [nums]
  (->> (range 1 21)
       (reduce (fn [p n]
                 (* p (/ n (gcd n p)))))))

(comment
  (divisible-by-all (range 1 21))
  )
