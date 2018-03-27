(ns my-exercise.home-test
  (:require [clojure.test :refer :all]
            [my-exercise.home :refer :all]))

(deftest place-ocd-test
  (testing "Test that the Place OCD conversion works correctly"
    (is (= "place:new_york_city" (convert-to-place-ocd {:city "New York City"})))))
