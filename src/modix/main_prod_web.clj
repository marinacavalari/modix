(ns modix.main-prod-web
  (:gen-class)
  (:require [modix.handlers.web :as h.web]
            [io.pedestal.http :as server]))

(defn -main [& _args]
  (-> h.web/server-config
      server/create-server
      server/start))