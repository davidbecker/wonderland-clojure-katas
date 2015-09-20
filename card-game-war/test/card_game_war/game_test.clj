(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round"
    (is (= 3 (higherRank 2 3)))
    (is (= 4 (higherRank 3 4)))
    (is (= 5 (higherRank 4 5)))
    (is (= 6 (higherRank 5 6)))
    (is (= 7 (higherRank 6 7)))
    (is (= 8 (higherRank 7 8)))
    (is (= 9 (higherRank 8 9)))
    (is (= 10 (higherRank 9 10)))
    (is (= :jack (higherRank 10 :jack))))
  (testing "queens are higher rank than jacks"
    (is (= :queen (higherRank :queen :jack))))
  (testing "kings are higher rank than queens"
    (is (= :king (higherRank :queen :king))))
  (testing "aces are higher rank than kings" 
    (is (= :ace (higherRank :ace :king))))
  (testing "if the ranks are equal, clubs beat spades"
    (is (= 0 1)))
  (testing "if the ranks are equal, diamonds beat clubs"
    (is (= 0 1)))
  (testing "if the ranks are equal, hearts beat diamonds"
    (is (= 0 1))))

(deftest test-play-game
  (testing "the player loses when they run out of cards"
    (is (= 0 1))))

