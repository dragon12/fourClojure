
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 135 - infix notation
(defn solution-135 [& args]
  (reduce #((first %2) %1 (last %2)) (first args) (partition 2 (rest args)))
  )


(deftest problem-135 ;
  (let [solutions
        [solution-135]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= 7  (__ 2 + 5)))
      (is (= 42 (__ 38 + 48 - 2 / 2)))
      (is (= 8  (__ 10 / 2 - 1 * 2)))
      (is (= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

