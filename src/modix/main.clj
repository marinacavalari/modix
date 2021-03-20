(ns modix.main 
  (:require [modix.handlers.cli :as h.cli]))

;; (defn handle-create-clothe []
  
;;   (create-clothe name asd))


(defn handle-option [option]
  (case option
    "1" (h.cli/create-clothe)
    "2" (println "Editando...")
    "3" (println "Excluindo...")
    "4" (println (h.cli/list-all-clothes))
    (println "nao vai ta dando")))

(defn show-menu-options []
  (println)
  (println "1) CADASTRAR")
  (println "2) EDITAR")
  (println "3) EXCLUIR")
  (println "4) LISTAR")
  (println "0) SAIR"))

(defn show-menu
  []
  (println "Olá, você esta no Modix!")
  (println "O que gostaria de fazer hoje?: ")
  (show-menu-options)
  
  (loop [option (read-line)]
    (if (= option "0")
      (println "Até logo!")
      (do
        (handle-option option)
        (show-menu-options)
        (recur (read-line)))))) 

(defn -main [& args]
  (show-menu))

