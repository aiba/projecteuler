(ns projecteuler.p0026)

(defn unit-frac [d]
  (let [result (fn [[a b]]
                 [(vec (map second a))
                  (map second b)])]
    (when (< 1 d)
      (loop [ret []
             n   10]
        (let [q (quot n d)
              r (rem n d)
              i (.indexOf ret [n q])]
          (cond
            (< n d)   (recur (conj ret [n 0]) (* r 10))
            (zero? r) (result [(conj ret [n q]) ()])
            (<= 0 i)   (result (split-at i ret))
            :else     (recur (conj ret [n q]) (* r 10))))))))

(comment
  (->> (range 1000)
       (map (fn [d] [d (unit-frac d)]))
       (map (fn [[d [a b]]] [d (count b)]))
       (sort-by (fn [[d n]] n) >)
       (take 3))

  (double (/ 1 84))
  (double (/ 1 40))
  )
