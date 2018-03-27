(ns my-exercise.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]]
            ;Added wrap-params to allow the form to pass values along.
            [ring.middleware.params :refer [wrap-params]]
            [my-exercise.home :as home]))

(defroutes app
  (GET "/" [] home/page)
  (route/resources "/")
  ;Created a POST route for the form to hit after submission.
  (POST "/search" {form-params :form-params} home/search)
  (route/not-found "Not found"))

(def handler
  (-> app
      (wrap-defaults site-defaults)
      wrap-params
      wrap-reload))
