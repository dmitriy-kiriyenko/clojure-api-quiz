(ns clojure-api-quiz.test.core
  (:use [clojure-api-quiz.core])
  (:use [clojure.test]))

(defn request [method resource web-app & params]
   (web-app {:request-method method :uri resource :params (first params)}))

(deftest test-main-routes
  (is (= "{\"response\":144}"
         (:body (request :get "/fib/12" main-routes))))
  (is (re-matches #"\{\"response\":\"[a-f0-9]{40}\"\}"
         (:body (request :get "/google-body" main-routes))))
  (is (= "{\"response\":\"ok\"}")
         (:body (request :post "/store" main-routes {:value "something"})))

  (is (= "{\"response\":\"somevalue\"}")
         (:body
           ( do
             (request :post "/store" main-routes {:value "somevalue"})
             (request :get "/store" main-routes)))))
