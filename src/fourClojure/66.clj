(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 66 - GCD
(defn solution-66 [x1 x2]
  (apply max
         (filter #(and
                   (zero? (mod x1 %))
                   (zero? (mod x2 %)))
                 (range 1 (inc (min x1 x2)))
         )
  )
)

(deftest problem-66 ;
  (let [solutions
        [solution-66]
       ]
    (loop [solution (first solutions) rest-solutions (rest solutions)]
      (is (= (solution 2 4) 2))
      (is (= (solution 10 5) 5))
      (is (= (solution 5 7) 1))
      (is (= (solution 1023 858) 33))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)


