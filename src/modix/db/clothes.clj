(ns modix.db.clothes)

(def clothes-db (atom {}))

(defn uuid []
  (str (java.util.UUID/randomUUID)))

(defn upsert! [clothe]
  (swap! clothes-db assoc (or (:id clothe) (uuid)) clothe))

(defn delete! [clothe]
  (swap! clothes-db dissoc (:id clothe)))

(defn get-all-clothes [] @clothes-db)
