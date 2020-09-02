(ns projecteuler.p0015)

(def paths-from
  (memoize
   (fn [x y]
     (if (or (= x 0) (= y 0))
       1
       (+ (paths-from (dec x) y)
          (paths-from x (dec y)))))))

(comment
  (paths-from 20 20)
  )
