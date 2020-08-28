(ns projecteuler.p0009)

(defn square [n]
  (* n n))

(defn sqrt [n]
  (let [x (int (Math/sqrt n))]
    (when (= n (square x))
      x)))

(first
  (for [a (range 1 1000)
        b (range 1 1000)
        :let [c (sqrt (+ (square a) (square b)))]
        :when (and c (= 1000 (+ a b c)))]
    (* a b c)))
