(ns modix.logic.clothes)

(defn ->clothe [name color style]
  #:clothe{:name name
           :color color
           :style style
           :status :enabled})

(defn updating [old-clothe name color style]
  (assoc old-clothe
         :clothe/name name
         :clothe/color color
         :clothe/style style))

(defn mark-as-deleted [clothe]
  (assoc clothe :clothe/status :disabled))