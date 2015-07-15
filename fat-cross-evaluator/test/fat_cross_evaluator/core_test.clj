(ns fat-cross-evaluator.core-test
  (:use clojure.test
        fat-cross-evaluator.core))

;(deftest a-test
;  (testing "FIXME, I fail."
;    (is (= 0 1))))

; parameters received:
; player number
; hash of player number -> distances (including own)
; array of 21 tiles (below)
; hash map of strategic weights

; tiles: hash map of:
; x = integer, relative to bfc-center
; y = integer, relative to bfc-center
; terrain = grass/plains/tundra/desert/ice
; resource = corn/gems/etc
; height = 0/1/2/3 for peak/hill/flat/water
; feature = jungle/forest/oasis
; auto-routed = true or false (e.g. if a city is planted here, will it automatically connect to an existing city that you own?)
; adjacent to river = true or false
; shared_with_allied_city = true or false
; shared_with_enemy_city = true or false

(def simple-weights
  {:city-on-hill 0.2
   :has-copper 0.9
   :has-iron 0.0
   :has-ancient-luxury 0.6
   :has-classical-luxury 0.0})

(def simple-weights-b
  {:city-on-hill 0.5
   :has-copper 0.6
   :has-iron 0.3
   :has-ancient-luxury 0.0
   :has-classical-luxury 0.0})


(deftest total-weights-test
  (testing "total-weights works"
           (is (= (total-weights simple-weights) 1.7))))
