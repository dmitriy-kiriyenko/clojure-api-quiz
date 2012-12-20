(ns clojure-api-quiz.store
    (:require [clj-redis.client :as redis]))

(def db (redis/init {:url "redis://127.0.0.1:6379"}))

(defn get-value []
  (redis/get db "value"))

(defn set-value [value]
  (redis/set db "value" value))
