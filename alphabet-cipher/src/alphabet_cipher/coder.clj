(ns alphabet-cipher.coder)

(defn getr [arr offset]
  (if (get arr offset)
    (get arr offset)
    (getr arr (- offset (count arr)))))

(defn ascii "get ascii code from ascii +- offset"
  [a] (if (< a 123)
        (if (> a 96)
          a
          (ascii (+ a 26))
          )
        (ascii (- a 26))))

(defn convert "convert ascii code into string" [x]
  (str(char x)))

(defn substitute [chr offset]
  (if (and chr offset)
    (convert
      (ascii
        (+
          (int chr)
          (- (int offset) 97))))))

(defn rev-substitute [chr offset]
  (if (and chr offset)
    (convert
      (ascii
        (+
          (- (int chr) 97)
          (- 123 (int offset))
          97)))))

(defn replace? [s1 s2]
  (loop [i 0]
    (if (< i (count s1))
      (if (= (getr s1 i) (getr s2 i))
        (recur (inc i))
        false)
      true)))
      
(defn shortest [s]
  (loop [i 1]
      (let [tmp (apply str (take i s))]
      (if (< i (count s))
        (if (replace? s tmp)
          (str tmp)
          (recur (inc i))        
        )))))

(defn algo [func keyword message]
  (loop [i 0 m ""]
      (let [msg (func
        (get (char-array message) i)
        (getr (char-array keyword) i))]
      (if (< i (count message))
        (recur (inc i) (str m msg))
        (str m)))))

(defn encode [keyword message]
  (algo substitute keyword message))

(defn decode [keyword message]
  (algo rev-substitute keyword message))

(defn decypher [cypher message]
  (shortest (decode message cypher)))