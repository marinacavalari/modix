(defproject modix "0.1.0-SNAPSHOT"
  :description "A web window to help you catalog and find the best options for your clothes, from the favorite ones till the ones you never imagined of."
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [com.datomic/datomic-free "0.9.5697" :exclusions [org.slf4j/slf4j-nop]]
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.26"]
                 [org.slf4j/jcl-over-slf4j "1.7.26"]
                 [org.slf4j/log4j-over-slf4j "1.7.26"]
                 [io.pedestal/pedestal.service "0.5.8"]
                 [io.pedestal/pedestal.jetty "0.5.8"]
                 [selmer/selmer "1.12.33"]]
  :plugins [[lein-sass "0.5.0"]]
  :resource-paths ["config" "resources"]
  :profiles {:cli {:main modix.main-cli}
             :prod-web {:main modix.main-prod-web}
             :dev {:aliases {"run-dev" ["trampoline" "run" "-m" "modix.main-dev-web/-main"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.5.8"]]
                   :main modix.main-dev-web}}
  :aliases {:cli ["with-profile" "cli" "run"]}
  :sass {:src "resources/sass"
         :output-directory "resources/public/css"
         :style :compressed}
  :repl-options {:init-ns modix.main-dev-web})