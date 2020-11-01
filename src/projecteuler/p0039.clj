(ns projecteuler.p0039)

(defn square [x] (* x x))
(defn sqrt [x] (int (Math/sqrt x)))

(def max-perimiter 1000)
(def all-squares (into (sorted-set) (map square (range 1 max-perimiter))))

(def all-triangles
  (for [aa all-squares
        bb all-squares
        :when (<= aa bb)
        :let [cc (+ aa bb)]
        :when (and (contains? all-squares cc))
        :let [[a b c] (map sqrt [aa bb cc])]
        :when (<= (+ a b c) max-perimiter)]
    [a b c]))

(count all-triangles)

(->> all-triangles
     (group-by #(apply + %))
     (sort-by (fn [[p v]] (count v)) >)
     first
     first)
