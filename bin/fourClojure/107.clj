(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 107 - simple closures
(defn solution-107 [n]
  #(reduce * (repeat n %))
)

(deftest problem-107 ;
  (let [solutions
        [solution-107]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= 256 ((__ 2) 16)))
      (is (= 256 ((__ 8) 2 )))
      (is (= [1 8 27 64] (map (__ 3) [1 2 3 4])))
      (is (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4])))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)


