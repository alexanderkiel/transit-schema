(ns transit-schema.core-test
  (:require [clojure.test :refer :all]
            [transit-schema.core :as ts]
            [schema.core :as s]))

(deftest read-leaf-schema-test
  (are [rep schema] (= schema (#'ts/read-leaf-schema rep))
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

(deftest write-type-leaf-schema-test
  (are [x rep] (= rep (#'ts/write-type-leaf-schema x))
    s/Bool "Bool"
    s/Inst "Inst"
    s/Num "Num"
    s/Regex "Regex"
    s/Str "Str"
    s/Uuid "Uuid"
    Byte nil))

(deftest write-pred-leaf-schema-test
  (are [x rep] (= rep (#'ts/write-pred-leaf-schema x))
    s/Keyword "Keyword"
    s/Int "Int"
    s/Symbol "Symbol"))
