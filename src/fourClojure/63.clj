
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 63 - grouping a sequence
(defn solution-63 [f s]
  (reduce #(merge-with concat %1 %2) (map #(assoc {} (> % 5) %) s))
)


(deftest problem-63 ;
  (let [solutions
        [solution-63]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
      (is (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
             {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
      (is (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
             {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

