(ns projecteuler.p0040
  (:require [projecteuler.lib :refer [digit-seq]]))

(defn pow [a x]
  (long (Math/pow a x)))

(defn d [i]
  (when (pos? i)
    (loop [i i, p 1]
      (let [m (* p 9 (pow 10 (dec p)))]
        (if (< m i)
          (recur (- i m) (inc p))
          (let [i (dec i) ;; convert to index
                d (nth (range (pow 10 (dec p)) (pow 10 p))
                       (quot i p))]
            (nth (reverse (digit-seq d))
                 (mod i p))))))))

(comment

  (map d (range 100))

  (apply * (for [p (range 0 7)]
             (d (pow 10 p))))

  )
