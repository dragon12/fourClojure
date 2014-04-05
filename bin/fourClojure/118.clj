(ns com.gers.clojure.4clojure
  (:use clojure.test)
  )


;;; problem 118 - simple closures
(defn solution-118 [f coll]
  (lazy-seq (when-let [s (seq coll)]
              (cons (f (first s)) (solution-118 f (rest s)))
              ))
  )

(deftest problem-118
  (let [solutions [solution-118] ]
    (loop [__ (first solutions) rest-solutions (rest solutions)]
      (is (= [3 4 5 6 7]
             (__ inc [2 3 4 5 6])))
      (is (= (repeat 10 nil)
             (__ (fn [_] nil) (range 10))))
      (is (= [1000000 1000001]
             (->> (__ inc (range))
               (drop (dec 1000000))
               (take 2))))
      (if (seq rest-solutions)
        (recur (first rest-solutions) (rest rest-solutions))
        )
      )
    )
  )

(run-tests)


