(ns com.gers.clojure.4clojure
  (:use clojure.test)
  (:use clojure.tools.trace)
  )

(defn ^:dynamic fib[n] (if (< n 2) n (+ (fib (dec n)) (fib (- n 2)))))

;(dotrace [fib] (fib 3))

(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

;(println (+ (* 2 3) (dbg (* 8 9))))



;;; problem 97 - pascal's triangle
(defn ^:dynamic getNextLine [line] 
  (conj (vec (conj (map + line (rest line)) 1)) 1)
  )

(defn ^:dynamic solution-97 [lineNo]
  (last 
    (take lineNo
          (iterate getNextLine [1])
          )
    )
)

; (dotrace [solution-97 getNextLine] (solution-97 5))
 
 
 (defn ^:dynamic remap [f s]
  cons (f (first s)) (lazy-seq (remap f (rest s)))
  )





