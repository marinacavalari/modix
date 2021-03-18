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