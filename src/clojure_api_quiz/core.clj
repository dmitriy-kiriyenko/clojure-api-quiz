(ns clojure-api-quiz.core
  (:gen-class)
  (:use compojure.core)
  (:use clojure-api-quiz.fibonacci)
  (:use clojure-api-quiz.sha1-url)
  (:use clojure-api-quiz.store)
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [ring.middleware.params :only [wrap-params]])
  (:require [compojure.route :as route]
            [clojure.data.json :as json]
            [compojure.handler :as handler]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes main-routes
  (GET "/" [] (json-response "api-quiz main route"))
  (GET ["/fib/:n", :num #"\d+"] [n] (json-response (fib (bigint n))))
  (GET "/google-body" [] (json-response (sha1-url "https://google.com.ua")))
  (GET "/store" [] (json-response (get-value)))
  (POST "/store" [value]
        (do
          (set-value value)
          (json-response "ok")))
  (route/not-found (json-response "Page not found" 404)))

(def engine
  (handler/site (wrap-params main-routes)))
