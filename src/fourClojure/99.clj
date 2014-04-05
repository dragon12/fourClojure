
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 99 - product digits
(defn solution-99 [x1 x2]
  (map #(- (int %) 48) (str (* x1 x2)))
)


(deftest problem-99 ;
  (let [solutions
        [solution-99]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ 1 1) [1]))
      (is (= (__ 99 9) [8 9 1]))
      (is (= (__ 999 99) [9 8 9 0 1]))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

