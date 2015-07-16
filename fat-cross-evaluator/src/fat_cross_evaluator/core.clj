(ns fat-cross-evaluator.core)

(defn fat-cross-evaluator [player-num cap-dists tile-array strat-weights]
  1 )

(defn total-weights [weight-map]
  (reduce + (map val weight-map)))

(defn city-resources [tile-list]
  (map :resource tile-list))

(defn has-resource? [resource-list resource]
  (reduce #(or %1 %2) (map #(= % resource) resource-list)))

(defn get-city-tile [tile-list]
  (first 
    (filter #(and (= (:x %) 0) (= (:y %) 0)) tile-list)))

(defn city-tile-on-hill? [tile-list]
  (= (:height (get-city-tile tile-list)) 1))



