(ns clojure-api-quiz.test.sha1-url
  (:use [clojure-api-quiz.sha1-url])
  (:use [clojure.test]))

(deftest test-fibs
  (is (= "98f0265108f71779ced7623c6cec9b90b7e67649"
         (sha1-url "http://example.com"))))
