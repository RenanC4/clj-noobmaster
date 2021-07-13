(ns clojure-noob.maps-values-keys)

(def estoque {:mochila 10
              :camiseta 5})

(println estoque)
(count estoque)
(keys estoque)
(vals estoque)
(assoc estoque :mochila 12)
(dissoc estoque :mochila)
(update estoque :mochila inc)
(update estoque :mochila dec)

(def pedido {:mochila {:quantidade 1 :preco 5}
             :cadeira {:quantidade 2 :preco 12}})

(assoc pedido :camiseta {:preco 25 :quantidade 2})

(-> pedido
    :cadeira
    :preco
    println)


