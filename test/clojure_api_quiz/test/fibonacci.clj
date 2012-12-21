(ns clojure-api-quiz.test.fibonacci
  (:use [clojure-api-quiz.fibonacci])
  (:use [clojure.test]))

(deftest test-fib
  (is (= 144N (fib 12N)))
  (is (= 354224848179261915075N (fib 100N))))
