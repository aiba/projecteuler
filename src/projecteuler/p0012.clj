(ns projecteuler.p0012)

(defn primes []
  (let [init-primes [2 3]
        primes (java.util.ArrayList. init-primes)
        next-prime! (fn []
                      (loop [i (.get primes (dec (.size primes)))]
                        (if (some #(zero? (mod i %)) primes)
                          (recur (inc i))
                          (do (.add primes i)
                              i))))]
    (concat init-primes
            (repeatedly next-prime!))))

(comment
  (time (last (take 10 (primes))))
  (time (last (take 1000 (primes))))
  (time (last (take 10000 (primes))))
  )

(defn prime-factors [n]
  (let [pf (fn [n]
             (let [max-p (int (Math/sqrt n))]
               (loop [[p & ps] (primes)]
                 (when (<= p max-p)
                   (if (zero? (mod n p))
                     p
                     (recur ps))))))]
    (loop [n n
           result []]
      (if (= n 1)
        []
        (if-let [p (pf n)]
          (recur (/ n p) (conj result p))
          (conj result n))))))

(comment
  (time
   (prime-factors (int 1e6)))
  )

(defn prime-factorization [n]
  (frequencies (prime-factors n)))

(comment
  (prime-factorization 10)
  )

(defn count-divisors [n]
  (->> (prime-factorization n)
       (vals)
       (map inc)
       (reduce * 1)))

(defn triangle-nums []
  (->> [1 1]
       (iterate (fn [[n i]]
                  (let [i (inc i)]
                    [(+ n i) i])))
       (map first)))

(comment
  (->> (triangle-nums)
       (filter #(< 500 (count-divisors %)))
       (first))
  )
