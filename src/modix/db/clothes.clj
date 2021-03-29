(ns modix.db.clothes
  (:require [datomic.api :as d]
            [modix.db.config :as db.config]))

(defn uuid []
  (java.util.UUID/randomUUID))

(defn get-by-id [id]
  (when id
    (d/q '{:find [(pull ?clothe [:clothe/id :clothe/name :clothe/color :clothe/style]) .]
           :in [$ ?id]
           :where [[?clothe :clothe/id ?id]]}
         (db.config/datomic-db)
         id)))

(defn upsert! [{:clothe/keys [id] :as clothe}]
  (if-let [existing-clothe (get-by-id id)]
    (d/transact (db.config/datomic-conn) [(merge existing-clothe clothe)])
    (d/transact (db.config/datomic-conn) [(assoc clothe :clothe/id (uuid))])))


(defn get-all-clothes []
  (d/q '{:find [[(pull ?clothe [:clothe/id :clothe/name :clothe/color :clothe/style]) ...]]
         :where [[?clothe :clothe/id ?id]]}
       (db.config/datomic-db)))

(comment
  (d/transact (db.config/datomic-conn)
              [{:db/ident :clothe/name
                :db/valueType :db.type/string
                :db/cardinality :db.cardinality/one}
               {:db/ident :clothe/style
                :db/valueType :db.type/string
                :db/cardinality :db.cardinality/one}
               {:db/ident :clothe/color
                :db/valueType :db.type/string
                :db/cardinality :db.cardinality/one}
               {:db/ident :clothe/id
                :db/valueType :db.type/uuid
                :db/cardinality :db.cardinality/one
                :db/unique :db.unique/identity}])

  (d/transact (db.config/datomic-conn)
              [#:clothe{:id (uuid)
                        :style "casual"
                        :color "azul"
                        :name "jaqueta"}])

  (d/q '{:find [?name]
         :where [[?clothe :clothe/id]
                 [?clothe :clothe/name ?name]]}
       (db.config/datomic-db))

  )
