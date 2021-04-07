(ns modix.main-cli
  (:require [modix.handlers.cli :as h.cli]))


(defn handle-option [option]
  (case option
    "1" (h.cli/create-clothe)
    "2" (h.cli/update-clothe)
    "3" (h.cli/delete-clothe)
    "4" (h.cli/list-all-clothes)
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
      (println "Até logo!"
               (System/exit 0))
      (do
        (handle-option option)
        (show-menu-options)
        (recur (read-line)))))) 

(defn -main [& args]
  (show-menu))

