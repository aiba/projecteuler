(ns projecteuler.p0014)

(set! *warn-on-reflection* true)

;; memoized
;; (declare collatz-chain)
;; (def collatz-chain
;;   (memoize
;;    (fn [n]
;;      (if (= n 1)
;;        [1]
;;        (let [n' (if (even? n) (/ n 2) (inc (* 3 n)))]
;;          (concat [n] (collatz-chain n')))))))

#_(defn collatz-chain-length
  ([n len]
   (if (= n 1)
     (inc len)
     (let [n' (if (even? n) (/ n 2) (inc (* 3 n)))]
       (recur n' (inc len)))))
  ([n]
   (collatz-chain-length n 0)))

(def chain-length* (atom {1 1}))

(defn collatz-chain-length [n]
  (loop [n n
         chain []]
    (if-let [l (@chain-length* n)]
      (do (doseq [i (range (count chain))]
            (swap! chain-length* assoc (chain i) (+ l (- (count chain) i))))
          (get @chain-length* (or (first chain) n)))
      (let [n' (if (even? n) (/ n 2) (inc (* 3 n)))]
        (recur n' (conj chain n))))))

(comment
  @chain-length*
  (collatz-chain-length 1)
  (collatz-chain-length 2)
  (collatz-chain-length 4)
  (collatz-chain-length 13)

  (time
   (->> (range 1 1e6)
        (map (fn [n]
               [n (collatz-chain-length n)]))
        (sort-by second >)
        (first)))

  )
