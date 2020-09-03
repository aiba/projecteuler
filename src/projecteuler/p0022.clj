(ns projecteuler.p0022
  (:require [clojure.string :as str]))

(->> (str/split (slurp "./data/p022_names.txt") #",")
     (map #(subs % 1 (dec (count %))))
     sort
     (map-indexed (fn [i x]
                    (* (inc i)
                       (->> x
                            (map #(inc (- (int %) (int \A))))
                            (reduce +)))))
     (reduce +))
