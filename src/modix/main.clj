(ns modix.main)

;; (defn handle-create-clothe []
  
;;   (create-clothe name asd))

(defn handle-option [option]
  (case option
    "1" (handlers.cli/create-clothe)
    "2" (println "Editando...")
    "3" (println "Excluindo...")
    "4" (println "Listando...")
    (println "nao vai ta dando")))

(defn show-menu-options []
  (println "1) CADASTRAR")
  (println "2) EDITAR")
  (println "3) EXCLUIR")
  (println "4) LISTAR")
  (println "0) SAIR"))

(defn show-menu
  []
  (println "Olá, você esta no Modix!")
  (show-menu-options)
  (println "O que gostaria de fazer hoje?: ")

  (loop [option (read-line)]
    (if (= option "0")
      (println "Até logo!")
      (do
        (handle-option option)
        (recur (read-line)))))) 


(defn -main [& args]
  (show-menu))

