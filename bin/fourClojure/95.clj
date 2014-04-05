(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 95 - detecting trees
(defn ^:dynamic solution-95 [[x y z :as all]]
  (if (= 3 (count all))
    (and     
      (or (nil? y) (and (coll? y) (solution-95 y)))
      (or (nil? z) (and (coll? z) (solution-95 z)))
      )
    false
  )
)



(deftest problem-95 ;
  (let [solutions
        [solution-95]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ '(:a (:b nil nil) nil)) true))
      (is (= (__ '(:a (:b nil nil))) false))
      (is (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]]) true))
      (is (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]]) false))
      (is (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil]) true))
      (is (= (__ [1 [2 [3 [4 false nil] nil] nil] nil]) false))
      (is (= (__ '(:a nil ())) false)) 
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

;(dotrace [solution-95] (solution-95  [2 [3 nil nil] [4 nil nil]]))

(run-tests)

