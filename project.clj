(defproject clojure-api-quiz "0.0.1"
  :description "A solution to a classical api quiz. See README.md"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.2.0"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 [clj-redis "0.0.13-SNAPSHOT"]
                 [enlive "1.0.0-SNAPSHOT"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler clojure-api-quiz.core/engine})
