(ns clojure-api-quiz.fibonacci)

(defn fibs []
  (defn fib-step [[a b]]
    [b (+ a b)])
  (map first (iterate fib-step [0N 1N])))

(defn fib [n]
  (nth (fibs) n))
