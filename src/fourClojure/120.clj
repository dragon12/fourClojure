
(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 120 - merging indices
(defn solution-120a [x]
  (count (filter #(< % (apply + (map (comp (fn [x] (* x x)) (fn [x] (- x 48)) int) (str %)))) x))
  )

(defn solution-120b [x]
  (count (filter #(< % (apply + (map (fn [y] (Math/pow (Integer/parseInt (str y)) 2)) x) )) x))
  )

(deftest problem-120 ;
  (let [solutions
        [solution-120a
        solution-120b
         ]
       ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= 8 (__ (range 10))))
      (is (= 19 (__ (range 30))))
      (is (= 50 (__ (range 100))))
      (is (= 50 (__ (range 1000))))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)

