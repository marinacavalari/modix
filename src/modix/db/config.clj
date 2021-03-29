(ns modix.db.config
  (:require [datomic.api :as d]))

(def datomic-uri
  (let [host     (or (System/getenv "DATOMIC_DB_HOST")
                     "localhost")
        password (or (System/getenv "DATOMIC_DB_PASSWORD")
                     "123")]
    (str "datomic:free://" host ":4334/modix?password=" password)))

(defn datomic-conn []
  (d/connect datomic-uri))

(defn datomic-db []
  (d/db (datomic-conn)))

(comment
  (d/create-database "datomic:free://0.0.0.0:4334/modix?password=123")
  
  )
