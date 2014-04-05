
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 157 - merging indices
(defn solution-157a [x]
  (map vector x (range (count x)))
  )

(defn solution-157b [x]
  (map-indexed (comp reverse vector) x)
  )

(deftest problem-157 ;
  (let [solutions
        [solution-157a
         solution-157b
         ]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]]))
      (is (= (__ [0 1 3]) '((0 0) (1 1) (3 2))))
      (is (= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

