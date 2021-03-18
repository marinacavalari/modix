(ns modix.db.clothes)

(defn insert! [{:clothe/keys [name]} :as clothe]
  (println (str name " inserido com sucesso")))