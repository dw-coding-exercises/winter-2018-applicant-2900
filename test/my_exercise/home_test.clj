(ns my-exercise.home-test
  (:require [clojure.test :refer :all]
            [my-exercise.home :refer :all]))

(def form-params {:city "New York City" :state "NY"})

(deftest place-ocd-test
  (testing "Test that the Place OCD conversion works correctly"
    (is (= "place:new_york_city" (convert-to-place-ocd form-params)))))

(deftest state-ocd-test
  (testing "Test that the State OCD conversion works correctly"
    (is (= "state:ny" (convert-to-state-ocd form-params)))))