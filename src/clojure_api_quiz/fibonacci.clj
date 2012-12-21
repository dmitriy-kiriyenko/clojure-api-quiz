(ns clojure-api-quiz.fibonacci)

(defn fib-iter [a b p q n]
  (defn square [x] (* x x))
  (cond
    (= n 0) b
    (even? n) (fib-iter a
                        b
                        (+ (square p) (square q))
                        (+ (* 2 p q) (square q))
                        (/ n 2))
    :else (fib-iter (+ (* b q) (* a q) (* a p))
                    (+ (* b p) (* a q))
                    p
                    q
                    (- n 1))))

(defn fib [n]
  (fib-iter 1N 0N 0N 1N n))
