(ns projecteuler.p0004)

(apply max
       (for [a (range 100 1000)
             b (range 100 1000)
             :let [n (* a b)]
             :when (= (seq (str n))
                      (reverse (str n)))]
         n))
