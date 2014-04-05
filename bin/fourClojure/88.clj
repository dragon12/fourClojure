(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 122 - iterate
(defn solution-122 [x]
  (read-string (str "2r" x))
)

(deftest problem-122 ;
  (let [solutions
        [solution-122]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= 0     (__ "0")))
      (is (= 7     (__ "111")))
      (is (= 8     (__ "1000")))
      (is (= 9     (__ "1001")))
      (is (= 255   (__ "11111111")))
      (is (= 1365  (__ "10101010101")))
      (is (= 65535 (__ "1111111111111111")))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)



