(ns clojure-api-quiz.test.store
  (:use [clojure-api-quiz.store])
  (:use [clojure.test]))

(deftest test-storage
  (is (= "some value"
         ( do
           (set-value "some value")
           (get-value))))

  (is (= "some other value"
         ( do
           (set-value "some value")
           (set-value "some other value")
           (get-value)))))
