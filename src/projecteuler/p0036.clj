(ns projecteuler.p0036)

(defn double-base-palindromic? [n]
  (let [s (Long/toString n 10)]
    (and (= (seq s) (reverse (seq s)))
         (let [s (Long/toString n 2)]
           (= (seq s) (reverse (seq s)))))))

(comment
  (double-base-palindromic? 101)
  (double-base-palindromic? 585)
  )

(comment
  (time
   (def nums (->> (range 1e6)
                  (filter double-base-palindromic?)
                  (doall))))

  (count nums)
  (reduce + nums)
  )
