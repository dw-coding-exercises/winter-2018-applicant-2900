(ns my-exercise.home-test
  (:require [clojure.test :refer :all]
            [my-exercise.home :refer :all]))

(def form-params {:city "New York City" :state "NY"})

(def test-url
  "https://api.turbovote.org/elections/upcoming?district-divisions=ocd-division/country:us/state:ny,ocd-division/country:us/state:ny/place:new_york_city")

(def test-place-ocd
  "place:new_york_city")

(def test-state-ocd
  "state:ny")

(deftest place-ocd-test
  (testing "Test that the Place OCD conversion works correctly"
    (is (= "place:new_york_city" (convert-to-place-ocd form-params)))))

(deftest state-ocd-test
  (testing "Test that the State OCD conversion works correctly"
    (is (= "state:ny" (convert-to-state-ocd form-params)))))

(deftest url-test
  (testing "Test that the url created is correct"
    (is (= test-url (create-url test-place-ocd test-state-ocd)))))