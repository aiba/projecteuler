(ns projecteuler.p0024
  (:require [clojure.math.combinatorics :as combo]))

(defn lex-perms [xs]
  (if (= (count xs) 1)
    (list xs)
    (for [a (sort xs)
          p (lex-perms (remove #{a} xs))]
      (cons a p))))

(comment

  (lex-perms (range 1))
  (lex-perms (range 2))
  (lex-perms (range 3))
  (lex-perms (range 4))

  (time
   (nth (combo/permutations (range 10))
        (int (dec 1e6))))

  (time
   (nth (lex-perms (range 10))
        (int (dec 1e6))))

  )
