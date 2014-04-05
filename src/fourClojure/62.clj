(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 62 - iterate
(defn solution-62 [f x]
  (cons x (lazy-seq (solution-62 f (f x))))
)

(deftest problem-62 ;
  (let [solutions
        [solution-62]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16]))
      (is (= (take 100 (__ inc 0)) (take 100 (range))))
      (is (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)



