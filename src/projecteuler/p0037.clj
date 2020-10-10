(ns projecteuler.p0037
  (:require [projecteuler.lib :as l]))

#_(defn t-prime? [n]
  (and (< 9 n)
       (prime? n)
       (let [digits (digit-seq n)]
         (every? (fn [i]
                   (and (prime? (digits->num (take i digits)))
                        (prime? (digits->num (drop i digits)))))
                 (range 1 (count digits))))))

;;(defonce prime? (memoize lib/prime?))

#_(defn prime? [n]
  (println n)
  true)

(defn t-prime? [n prime?]
  (and (prime? n)
       (every? (fn [^long i]
                 (and (prime? (quot n (long (Math/pow 10 i))))
                      (prime? (mod n (long (Math/pow 10 (- (Math/ceil (Math/log10 n))
                                                           i)))))))
               (range 1 (l/count-digits n)))))

(comment
  (time
   (let [m 1e6
         primes (set (l/sieve-primes m))]
     (def tps (doall
               (filter #(t-prime? % primes) (range 10 m))))))

  (count tps)
  (reduce + tps)

  )
