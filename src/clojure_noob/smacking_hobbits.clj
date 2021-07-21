(ns clojure-noob.smacking-hobbits)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "expect a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

(let [x 2]
  x)

(def dalmatian-list
  ["pango" "pengo" "pingo" "pongo" "cleiton"])

(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(def x 0)
(let [x 1] x)
(println x)

(let [x (inc x)]
  x)

(let [[pango & dalmatians] dalmatian-list]
  [pango dalmatians])

(into [] (set [:a :a]))

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Adios")
    (recur (inc iteration))))

(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Adíos")
     (recursive-printer (inc iteration)))))

(recursive-printer)

(re-find #"^left-" "left-eye")

(re-find #"^left-" "cleft-eye")

(re-find #"^left-" "cucabeludo")

(defn replacing-match-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(replacing-match-part {:name "left-egg" :size 1})
(replacing-match-part {:name "head" :size 5})

(reduce + [1 2 3 4 5])
(+ (+ (+ (+ 1 2) 3) 4) 5)

(reduce + 15 [1 2 3 4 5])

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(better-symmetrize-body-parts asym-hobbit-body-parts)

(defn hit
  [asym-hobbit-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-hobbit-body-parts)
    body-part-size-sum (reduce + (map :size sym-parts))
    target (rand body-part-size-sum)]
   (loop [[part & remaining] sym-parts
          accumulated-size (:size part)]
     (if (> accumulated-size target)
       part
       (recur remaining (+ accumulated-size (:size (first remaining))))))))


(hit asym-hobbit-body-parts)


;exercises

;1
(str "Renan " "Campos " 25 " anos")
(vector "a" 2 "feijao" :renan {:nome {:primeiro "Renan" :segundo "Campos"}})
(list 1 2 3)
(def batata (hash-map :renan 1 :campos "2" "2" :ribeiro))
(println batata)
(hash-set batata  "Renan" 5 )

;2
(defn inc-100
  [number]
  (+ 100 number))

(inc-100 12)

;3
(defn dec-maker
  [number]
  #(- % number))

(def minus-ten (dec-maker 10))

(minus-ten 11)

;4

(map inc [1 1 2 2])
