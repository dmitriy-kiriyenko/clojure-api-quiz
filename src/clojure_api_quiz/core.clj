(ns clojure-api-quiz.core
  (:gen-class)
  (:use compojure.core)
  (:use clojure-api-quiz.fibonacci)
  (:use clojure-api-quiz.sha1-url)
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [ring.middleware.params :only [wrap-params]])
  (:require [compojure.route :as route]
           [clojure.data.json :as json]
           [compojure.handler :as handler]
           [clj-redis.client :as redis]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes main-routes
  (GET "/" [] (json-response "api-quiz main route"))
  (GET ["/fib/:n", :num #"\d+"] [n] (json-response (fib (bigint n))))
  (GET "/google-body" [] (json-response (sha1-url "https://google.com.ua")))
  (route/not-found (json-response "Page not found" 404)))

(def engine
  (handler/site main-routes))
