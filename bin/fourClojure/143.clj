
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 143 - dot product
(defn solution-143 [v1 v2]
  (apply + (map * v1 v2))
)


(deftest problem-143 ;
  (let [solutions
        [solution-143]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= 0 (__ [0 1 0] [1 0 0])))
      (is (= 3 (__ [1 1 1] [1 1 1])))
      (is (= 32 (__ [1 2 3] [4 5 6])))
      (is (= 256 (__ [2 5 6] [100 10 1])))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

