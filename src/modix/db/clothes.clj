(ns modix.db.clothes)

(def clothes-db (atom {}))

(defn uuid []
  (str (java.util.UUID/randomUUID)))

(defn upsert! [{:clothe/keys [id] :as clothe}]
  (if id
    (swap! clothes-db assoc id clothe)
    (let [new-id (uuid)]
      (swap! clothes-db assoc new-id (assoc clothe :clothe/id new-id)))))

(defn delete-by-id! [id]
  (swap! clothes-db dissoc id))

(defn get-all-clothes [] @clothes-db)

(defn get-by-id [id]
  (get @clothes-db id))


