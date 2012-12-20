(ns clojure-api-quiz.core
  (:gen-class)
  (:use compojure.core)
  (:use clojure-api-quiz.fibonacci)
  (:use [ring.adapter.jetty :only [run-jetty]])
  (:use [ring.middleware.params :only [wrap-params]])
  (:require [compojure.route :as route]
           [clojure.data.json :as json]
           [compojure.handler :as handler]
           [clj-redis.client :as redis]
           [net.cgrand.enlive-html :as html])
  (:import [java.io File]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:response data})})

(defroutes main-routes
  (GET "/" [] (json-response "api-quiz main route"))
  (GET ["/fib/:n", :num #"\d+"] [n] (json-response (fib (bigint n))))
  (route/not-found (json-response "Page not found" 404)))

(def engine
  (handler/site main-routes))
