(ns modix.logic.clothes)

(defn new [name color style]
  #:clothe{:name name
           :color color
           :style style})


(defn updating [old-clothe name color style]
  (assoc old-clothe 
         :clothe/name name
         :clothe/color color
         :clothe/style style))


