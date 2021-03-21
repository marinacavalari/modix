(ns modix.logic.clothes)

(defn new [name color style]
  #:clothe{:name name
           :color color
           :style style})

(defn organized-clothe [{:keys [name style color]}]
  (println name color style))
