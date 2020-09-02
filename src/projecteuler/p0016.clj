(ns projecteuler.p0016)

(comment

  (->> (nth (iterate #(* % 2) 1N) 1000)
       str
       (map #(Long/parseLong (str %)))
       (reduce +))

  )
