(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I' am a little teapot"))

(+ 1 2 3)
(str "it was the panda " "in the library " "with a dust buster")
(if false?
  "true"
  "false")

(if false?
  (do (println "Success")
      "By zeus hammer!")
  (do (println "Failure")
      "By Posseidon trident"))

(when true?
  (println  "Success!")
  "Abra Cadabra")

(nil? 1)

(nil? nil)

(if "bears eat beets"
  "bears beets Battlestar Galactica")

(if nil
  "This wont be the result beacause nil is falsey"
  "nil is falsey")

(= 1 1)
(= nil nil)
(= 1 2 )

(or false nil :large_i_mean_venti :why_cant_i_just_say_large)
(or (= 0 1) (= "yes" "no"))
(or nil)

(and :free_wifi :hot_coffee)

(and :feeling_super_cool nil false)

(def failed-protagonist-names
  ["Larry Potter" "Dorer the Explorer" "The incredible Bulk"])

(first failed-protagonist-names)

(defn error-message
  [severity]
  (str "Oh God! Its a disaster! we are "
        (if (= severity :mild)
          "Mildly incovenienced!"
          "Doooooomed")))

(defn concatener
  [new-item actual-list]
  (def newlist
    [new-item actual-list])
  newlist)

(def name "Cheawbaca")
(str "Uglglglglglglg - " name)

{}

{:first-name "Charlie"
 :last-name "McFishwich"}

{"string-key" +}
{:name {:first "John" :middle "Jacob" :last "Jingleheimerschimdt"}}

(hash-map :a 1 :b 2)

(get {:a 0 :b {:c "ho hum"}} :b)
(get {:a 0 :b 1} :b)
(get {:a 0 :b 1} :c "unicorns?")

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])

({:name "The Human Coffepot"} :name)





;AXIOMAS DE PEANO
; 1: 1 é um número natural
; 2: Para tod0 natural x, x = x. (igualdade reflexiva)
; 3: Para todos os números naturais x e y, se x = y, então y = x. (igualdade simetrica)
; 4: Para todos os números naturais x, y, e z, se x = y e y = z, então x = z. (igualdade transitiva)
; 5: os números naturais são fechados em sua igualdade.

; Algoritmos em Clojure (iteração e recursão linear) respectivamente de acordo a teoria da complexidade de algoritmos
(defn (+ x y)
  (if (= x 0)
    y
    (x (- 1 + x) (1 + y))))
;iteration
;time = 0(x)
;space = 0(1)
;I

(defn (+ x y)
  (if (= x 0)
    y
    (1 + (+ (- 1 + x) y))))
;linear recursion
;time = 0(x)
;space = 0(x)
;>


(:a {:a 1 :b 2 :c 3})
(get {:a 1 :b 2 :c 3} :a)
(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")

[3 2 1]
(get [3 2 1] 0)
(get ["a" {:name "Pugsley Winterbotton"} "c"] 1)
(vector "creepy" "full" "moon")

(conj [1 2 3] 4)

'(1 2 3 4 )
(nth '(:a :b :c) 2)
(list 1 "two" {3 4})
(conj '(1 2 3 4) 4)

#{"kurt vonnegut" 20 :icicle}
(hash-set 1 1 2 2)
(conj #{:a :b} :b)

(set [3 3 3 4 4])

(contains? #{:a :b} :a)
(contains? #{:a :b} :3)
(contains? #{nil} nil)

(:a #{:a :b})
(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a :b} "Kurt vonnengut")

; valid function calls
(or + -)                                                    ;return plus operator
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

; invalid function calls
(1 2 3 4)
("test" 1 2 3 4 )

(inc 1.1)
(map inc [0 1 2 3])

(defn increstwo
    [x]
    (+ x 2))

(map increstwo [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2)))
(+ 200 (/ 100 5))
(+ 200 20)

(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOUR ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Renan")

(defn no-parameter
  []
  "no parameters, arity zero")

(defn one-parameter
  [a]
  (str "one parameter: " a))

(defn two-parameters
  [p1 p2]
  (str "parameter one:" p1 "parameter two" p2))

(defn receive-treasue-location
  [{:keys [lat lang] :as treasury-location}]
  (println (str "treasury lat: " lat))
  (println (str "trasury lang: " lang))
  (str "steer-ship!" treasury-location))

(defn illustrative-function
  []
  (+ 1 1024)
  30
  "Renan")

(defn number-comment
  [x]
  (if (> x 6)
    (str "Que numero ernorme ----lenny face----")
    (str "Numero ok")))


(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr. M"])

((fn [x] (* x 3)) 8)

(def my-special-multiplication (fn [x] (* x 3)))

#(* % 3)
(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Mr M" "Mr Catra"])

(defn valor-descontado
  [valor-bruto]
  (let [taxa-de-desconto 0.1
        desconto         (* valor-bruto taxa-de-desconto)]
    (- valor-bruto desconto)))

(defn valor-descontado-maior-que-cem
  [aplica-desconto? valor-bruto]
  (if (aplica-desconto? valor-bruto)
    (let [taxa-de-desconto 0.1
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(defn desconto-aplicavel?
  [valor]
  (> valor 100))


(def precos [20 700 10000])

(get precos 0)

(filter desconto-aplicavel? precos)
(reduce + precos)
