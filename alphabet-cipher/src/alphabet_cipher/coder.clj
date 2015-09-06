(ns alphabet-cipher.coder)

(defn encode [keyword message]
  "encodeme")

(defn decode [keyword message]
  "decodeme")

(defn decypher [cypher message]
  "decypherme")

(defn convert "convert ascii code into string" [x]
  (str(char x)))

(defn substitute [chr offset]
  (convert (ascii (+ (int chr)(- (int offset) 97)))))

(defn ascii "get ascii code from ascii +- offset"
  [a] (if (< a 123)
        (if (> a 96)
          a
          (ascii (+ a 26))
          )
        (ascii (- a 26))))