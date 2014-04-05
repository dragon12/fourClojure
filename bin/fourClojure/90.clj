(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 90 - cartesian product
(defn solution-90 [s1 s2]
  (set (mapcat (fn [i] (map (fn [j] (vector i j)) s2)) s1))
)


(deftest problem-90 ;
  (let [solutions
        [solution-90]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
             #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
               ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
               ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
      (= (__ #{1 2 3} #{4 5})
         #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
      (= 300 (count (__ (set (range 10))
                        (set (range 30)))))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

