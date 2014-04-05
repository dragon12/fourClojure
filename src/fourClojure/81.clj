(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 81 - set intersection
(defn solution-81 [s1 s2]
  (clojure.set/difference s1 (clojure.set/difference s1 s2))
)

(deftest problem-81 ;
  (let [solutions
        [solution-81]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3}))
      (is (= (__ #{0 1 2} #{3 4 5}) #{}))
      (is (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)


