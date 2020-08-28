(ns projecteuler.p0003)

(defn factors [N]
  (loop [n N
         m (int (Math/sqrt n))
         i 2
         result []]
    (cond
      (< m i) (if (= n N) result (conj result n))
      (zero? (mod n i)) (let [n (/ n i)]
                          (recur n (int (Math/sqrt n)) 2 (conj result i)))
      :else (recur n m (inc i) result))))

(apply max (factors 600851475143))
