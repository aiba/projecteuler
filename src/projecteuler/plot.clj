(ns projecteuler.plot
  (:require [taoensso.nippy :as nippy]
            [clj-http.client :as http]))

(def plot-url "http://localhost:10666/")
(def control-url "http://localhost:10667/")

(defn plot! [plot-data]
  (http/request
   {:url control-url
    :method :post
    :body (nippy/freeze {:method :view! :args [plot-data]})}))

(defn xy-plot! [xs ys]
  (plot!
   {:data {:values (map (fn [x y] {:x x, :y y}) xs ys)}
    :encoding {:x {:field "x" :type "quantitative"}
               :y {:field "y" :type "quantitative"}}
    :mark "line"
    :width 640
    :height 480}))

(comment
  (xy-plot! (range 100)
            (map #(* % %) (range 100)))
  )

(defn plot-fns! [xs fns]
  (plot!
   {:width 640
    :height 480
    :data {:values (for [x xs, [k f] fns]
                     {:x x :y (f x) :fn (name k)})}
    :mark {:type "line", :point true}
    :encoding {:x {:field "x" :type "quantitative"}
               :y {:field "y" :type "quantitative"}
               :color {:field "fn", :type "nominal"}}}))
