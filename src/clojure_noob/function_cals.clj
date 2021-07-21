(ns clojure-noob.function-cals)

(defn inc-maker
  "create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

