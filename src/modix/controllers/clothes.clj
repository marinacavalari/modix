(ns modix.controllers.clothes
  (:require [modix.db.clothes :as db.clothes]
            [modix.logic.clothes :as l.clothes]))

(defn create [name color style]
  (-> (l.clothes/->clothe name color style)
      db.clothes/upsert!))

(defn list-all-clothes []
  (db.clothes/get-all-clothes))

(defn update-clothe [id name color style]
  (-> (db.clothes/get-by-id id)
      (l.clothes/updating name color style)
      db.clothes/upsert!))

(defn delete [id]
  (-> (db.clothes/get-by-id id)
      l.clothes/mark-as-deleted
      db.clothes/upsert!))