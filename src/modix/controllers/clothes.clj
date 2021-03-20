(ns modix.controllers.clothes 
  (:require [modix.db.clothes :as db.clothes]
            [modix.logic.clothes :as l.clothes]))

(defn create [name color style]
  (-> (l.clothes/new name color style)
      db.clothes/upsert!))

(defn list-all-clothes []
  (db.clothes/get-all-clothes))



(map identity (vals (list-all-clothes)))