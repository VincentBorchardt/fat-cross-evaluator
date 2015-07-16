(ns fat-cross-evaluator.core-test
  (:use clojure.test
        fat-cross-evaluator.core))

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
; wet: true or false
; adjacent to river = true or false
; shared_with_allied_city = true or false
; shared_with_enemy_city = true or false

; resources:
; early-strategic: copper, iron, horses
; late-strategic: oil, uranium, coal, aluminum
; wonder: stone, marble
; ancient-happy: fur, gems, gold, silver, ivory
; classical-happy: dye, incense, silk, spices, sugar, wine
; late-happy: movies, musicals, singles
; water-happy: whale
; farm-food: corn, rice, wheat
; pasture-food: cow, pig, sheep
; camp-food: deer
; calendar-food: banana
; water-food: clam, crab, fish

(def small-tile-list
  [{:x 0
    :y 0
    :terrain :grass
    :resource nil
    :height 1
    :feature nil
    :auto-routed true
    :wet true
    :river-adjacent true
    :allied-city false
    :enemy-city false}
   {:x 1
    :y 0
    :terrain :plains
    :resource :copper
    :height 2
    :feature nil
    :auto-routed false
    :wet true
    :river-adjacent false
    :allied-city false
    :enemy-city true}])

(deftest get-city-tile-test
  (testing "get-city-tile works"
           (is (= (get-city-tile small-tile-list) (first small-tile-list)))))

(deftest city-tile-on-hill-test
  (testing "city-tile-on-hill? works"
           (is (city-tile-on-hill? small-tile-list))))
   
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

(defn abs [n] (max n (- n)))

(deftest total-weights-test
  (testing "total-weights works"
           (is (< (abs (- (total-weights simple-weights) 1.7)) 0.0001))))
