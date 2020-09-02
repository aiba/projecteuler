(ns projecteuler.p0019)

(import java.time.LocalDate)
(import java.time.DayOfWeek)
(import java.time.format.DateTimeFormatter)

(->> (LocalDate/of 1901 1 1)
     (iterate (fn [^LocalDate d] (.plusDays d 1)))
     (take-while (fn [^LocalDate d] (< (.getYear d) 2001)))
     (filter (fn [^LocalDate d]
               (and (= 1 (.getDayOfMonth d))
                    (= DayOfWeek/SUNDAY (.getDayOfWeek d)))))
     (count))
