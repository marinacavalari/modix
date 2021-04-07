(ns modix.handlers.web
  (:require [io.pedestal.http :as server]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route :as route]
            [modix.controllers.clothes :as c.clothes]
            [clojure.java.io :as io]
            [selmer.parser :refer [render-file set-resource-path!]]))

(set-resource-path! (io/resource "templates"))

(def common-interceptors
  [(body-params/body-params)
   server/html-body])

(defn- home [_]
  {:status 200
   :body (render-file "home.html" {:clothes (c.clothes/list-all-clothes)})})


(defn- clothes-create [{{:keys [name style color]} :form-params}]
  (c.clothes/create name style color)
  {:status 201
   :body {}})

(defn- clothes-delete [{{:keys [id]} :form-params}]
  (c.clothes/delete (java.util.UUID/fromString id))
  {:status 200
   :body {}})
  

(defn routes []
  #{["/" :get (conj common-interceptors home) :route-name :home]
    ["/clothes" :post (conj common-interceptors clothes-create home) :route-name :clothes-new]
    ["/clothes/delete" :post (conj common-interceptors clothes-delete home) :route-name :clothes-delete]})

(def server-config
  {::server/port 8080
   ::server/type :jetty
   ::server/routes (route/expand-routes (routes))})

(def dev-server-config
  (merge server-config
         {:env :dev
          ::server/join? false
          ::server/routes #(route/expand-routes (routes))
          ::server/allowed-origins {:creds true :allowed-origins (constantly true)}
          ::server/secure-headers {:content-security-policy-settings {:object-src "'none'"}}}))