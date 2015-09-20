(ns card-game-war.game)

;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))


(defn compareIndex [indexRank1 indexRank2]
	(if (= indexRank1 indexRank2)
		nil
		(if (> indexRank1 indexRank2)
			indexRank1
			indexRank2)))

(defn higherRank [rank1 rank2]
	"returs the higher rank. returns nil if the two ranks are the same"
	(let [index (compareIndex
				(.indexOf ranks rank1)
				(.indexOf ranks rank2))]
		(if index (ranks index))))

(defn play-round [player1-card player2-card])

(defn play-game [player1-cards player2-cards])
