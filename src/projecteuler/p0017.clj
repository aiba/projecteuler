(ns projecteuler.p0017
  (:require [clojure.string :as str]))

(defn ->words [n]
  (if (string? n)
    n
    (case n
      1 "one"
      2 "two"
      3 "three"
      4 "four"
      5 "five"
      6 "six"
      7 "seven"
      8 "eight"
      9 "nine"
      10 "ten"
      11 "eleven"
      12 "twelve"
      13 "thirteen"
      14 "fourteen"
      15 "fifteen"
      16 "sixteen"
      17 "seventeen"
      18 "eighteen"
      19 "nineteen"
      20 "twenty"
      30 "thirty"
      40 "forty"
      50 "fifty"
      60 "sixty"
      70 "seventy"
      80 "eighty"
      90 "ninety"
      (cond
        (< n 100) (str/join "-" (map ->words [(- n (mod n 10))
                                              (mod n 10)]))
        (< n 1000) (str/join " " (map ->words (concat
                                               [(int (/ n 100))
                                                "hundred"]
                                               (let [r (mod n 100)]
                                                 (when (< 0 r)
                                                   ["and" r])))))
        (= n 1000) "one thousand"
        :else "?"))))

(defn count-letters [n]
  (-> n
      ->words
      (str/replace #"[^a-z]" "")
      count))

(->> (range 1 1001)
     (map count-letters)
     (apply +))
