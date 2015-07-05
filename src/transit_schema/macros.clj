(ns transit-schema.macros)

(defmacro record-read-handler
  "Creates a read handler for a record."
  [record]
  `(cognitect.transit/read-handler
     (fn [x#]
       (~(symbol "schema.core" (str "map->" record ".")) x#))))

(defmacro record-read-handlers
  "Creates a map of record tags to read handlers."
  [& records]
  `(hash-map
     ~@(reduce (fn [c r]
                 (conj c (str "schema.core." r) `(record-read-handler ~r)))
               []
               records)))
