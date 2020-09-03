(ns projecteuler.p0028)

(defn spiral-diags [edge-size]
  (loop [sum 1
         e 1]
    (if (<= edge-size e)
      sum
      (recur (apply + sum (for [i (range 4)]
                            (+ (* e e) (* (inc i) (inc e)))))
             (+ e 2)))))

(comment
  (spiral-diags 1001)
  )
