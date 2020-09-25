(ns projecteuler.p0033
  (:require [clojure.set :as set]
            [projecteuler.lib :refer [digit-seq]]))

(defn digit-canceling-frac? [a b]
  (when (< (/ a b) 1)
    (let [as (set (digit-seq a))
          bs (set (digit-seq b))
          as' (set/difference as bs)
          bs' (set/difference bs as)]
      (and (not-any? zero? as)
           (not-any? zero? bs)
           (= 2 (count as) (count bs))
           (= 1 (count as') (count bs'))
           (= (/ a b) (/ (first as') (first bs')))))))

(comment
  (digit-canceling-frac? 49 98)
  (digit-canceling-frac? 2 3)
  (digit-canceling-frac? 30 50)
  )

(comment
  (reduce *
          (for [a (range 1 100)
                b (range (inc a) 100)
                :when (digit-canceling-frac? a b)]
            (/ a b)))
  )
