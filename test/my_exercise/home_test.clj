(ns my-exercise.home-test
  (:require [clojure.test :refer :all]
            [my-exercise.home :refer :all]))

;Create form-params to be used in conversion tests
(def form-params {:city "New York City" :state "NY"})

;Define the test url with a functioning url.
(def test-url
  "https://api.turbovote.org/elections/upcoming?district-divisions=ocd-division/country:us/state:ny,ocd-division/country:us/state:ny/place:new_york_city")

;Define a proper place ocd for the url test.
(def test-place-ocd
  "place:new_york_city")

;Define a proper state ocd for the url test. 
(def test-state-ocd
  "state:ny")

;Test for the place converter: lowercase and underscore.
(deftest place-ocd-test
  (testing "Test that the Place OCD conversion works correctly"
    (is (= "place:new_york_city" (convert-to-place-ocd form-params)))))

;Test for the state converter: lowercase.
(deftest state-ocd-test
  (testing "Test that the State OCD conversion works correctly"
    (is (= "state:ny" (convert-to-state-ocd form-params)))))

;Test to make sure the create-url function is properly creating the url for the API request.
(deftest url-test
  (testing "Test that the url created is correct"
    (is (= test-url (create-url test-place-ocd test-state-ocd)))))