(ns clojure-noob.destruct)

(defn preco-total-do-produto [produto]
  (* (:quantidade produto) (:preco produto)))

(def pedido {:mochila {:quantidade 1 :preco 5}
             :cadeira {:quantidade 2 :preco 12}})

(defn total-pedido
  [pedido]
  (->> pedido
       vals
       (map preco-total-do-produto)
       (reduce +)))

(total-pedido pedido)


(def pedido {:mochila {:quantidade 1 :preco 5}
             :cadeira {:quantidade 2 :preco 12}
             :chaveiro {:quantidade 2}})

(defn gratuito?
  [[chave item]]
  (<= (get item :preco 0) 0))

(filter gratuito? pedido)

(defn myfirst
  [[first-thing & uninportant-things]]
  uninportant-things)

(myfirst ["uni" "duni" "te"])
