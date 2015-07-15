(ns fat-cross-evaluator.core)

(defn fat-cross-evaluator [player-num cap-dists tile-array strat-weights]
  1 )

(defn total-weights [weight-map]
  (reduce + (map val weight-map)))

(defn city-resources [tile-list]
  (map :resource tile-list))

(defn has-resource? [tile-list resource]
  (reduce or (map #(= % resource) (city-resources tile-list))))

(defn on-plains-hill? [tile-list]
  false)

