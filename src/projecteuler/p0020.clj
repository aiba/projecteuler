(ns projecteuler.p0020)

(comment
  (->> (range 1 101)
       (reduce * 1N)
       str
       (map #(Long/parseLong (str %)))
       (reduce +))
  )
