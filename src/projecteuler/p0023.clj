(ns projecteuler.p0023
  (:require [projecteuler.lib :refer [proper-divisors]]))

(defn spd [n]
  (apply + (proper-divisors n)))

(def abundant-numbers
  (->> (range)
       (drop 1)
       (filter #(< % (spd %)))))

(defn is-sum-of-2-abundant? [n]
  (let [anums (set (take-while #(< % n) abundant-numbers))]
    (some #(contains? anums (- n %)) anums)))

(comment
  (->> (range 1 28124)
       (remove is-sum-of-2-abundant?)
       (reduce +))
  )
