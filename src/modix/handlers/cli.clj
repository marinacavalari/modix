(ns modix.handlers.cli 
  (:require [modix.controllers.clothes :as c.clothes]))

(defn ask-question [question]
  (println question)
  (read-line))

(defn create-clothe []
  (let [name (ask-question "Qual peça deseja incluir?")
        color (ask-question "Qual a cor?")
        style (ask-question "Qual o tipo da roupa?")]
    (c.clothes/create name color style))
  (println "Legal, está cadastrado! Agora vamos escolher uma nova opção"))

(defn organized-clothe [{:clothe/keys [id name style color]}]
  (println id name color style))

(defn list-all-clothes []
  (mapv organized-clothe (c.clothes/list-all-clothes)))

(defn delete-clothe []
 (let [id (ask-question "Qual peça gostaria de remover?")]
   (c.clothes/delete (java.util.UUID/fromString id)))
  (println "a peça já foi removida!"))

(defn update-clothe []
  (println "Essas são as peças disponiveis:" )
  (list-all-clothes)
  (let [id (ask-question "Qual peça gostaria de atualizar?")
        name (ask-question "Qual o novo nome?")
        color (ask-question "Qual a nova cor?")
        style (ask-question "Qual o novo estilo?")]
    (c.clothes/update-clothe id name color style))
  (println "peça atualizada!"))