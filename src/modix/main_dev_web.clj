(ns modix.main-dev-web
  (:gen-class)
  (:require [modix.handlers.web :as h.web]
            [io.pedestal.http :as server]))

(defn -main [& _args]
  (println "\nCreating your [DEV] server...")
  (-> h.web/dev-server-config
      server/default-interceptors
      server/dev-interceptors
      server/create-server
      server/start))



      


