(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 97 - pascal's triangle
(defn solution-97 [lineNo]
  (last 
    (take lineNo
          (iterate 
            (fn getNextLine [line] 
              (conj 
                (vec 
                  (conj 
                    (map + line (rest line))
                    1)
                  ) 
                1)
              ) 
            [1]
            )
          )
    )
)


(deftest problem-97 ;
  (let [solutions
        [solution-97]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ 1) [1]))
      (is (= (map __ (range 1 6))
             [     [1]
              [1 1]
              [1 2 1]
              [1 3 3 1]
              [1 4 6 4 1]]))
      (is (= (__ 11)
             [1 10 45 120 210 252 210 120 45 10 1]))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

