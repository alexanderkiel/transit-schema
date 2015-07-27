(ns transit-schema.core-test
  (:require [clojure.test :refer :all]
            [transit-schema.core :as ts]
            [schema.core :as s]))

(deftest read-leaf-schema-test
  (are [x schema] (= schema (#'ts/read-leaf-schema x))
    "Any" s/Any
    "Bool" s/Bool
    "Keyword" s/Keyword
    "Inst" s/Inst
    "Int" s/Int
    "Num" s/Num
    "Regex" s/Regex
    "Str" s/Str
    "Symbol" s/Symbol
    "Uuid" s/Uuid))
