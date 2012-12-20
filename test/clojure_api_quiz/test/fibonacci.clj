(ns clojure-api-quiz.test.fibonacci
  (:use [clojure-api-quiz.fibonacci])
  (:use [clojure.test]))

(deftest test-fibs
  (is (= [0N, 1N, 1N, 2N, 3N, 5N, 8N, 13N, 21N, 34N]
         (take 10 (fibs)))))

(deftest test-fib
  (is (= 144N (fib 12N)))
  (is (= 354224848179261915075N (fib 100N))))
