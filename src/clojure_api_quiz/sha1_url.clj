(ns clojure-api-quiz.sha1-url
    (:require [net.cgrand.enlive-html :as html]))

(defn sha1-url [url]
  (defn fetch-url [url]
    (apply str (html/html-resource (java.net.URL. url))))

  (defn sha1 [string]
    (apply str
      (map (partial format "%02x")
        (.digest (doto (java.security.MessageDigest/getInstance "SHA-1")
                       .reset
                       (.update (.getBytes string)))))))

  (sha1 (fetch-url url)))
