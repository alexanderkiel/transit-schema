(ns transit-schema.core
  #?(:cljs (:require-macros [transit-schema.macros :as m]))
  (:require [cognitect.transit :as t]
            [schema.core :as s])
  #?(:clj
     (:import [schema.core Predicate AnythingSchema]
              [java.util UUID Date]
              [java.util.regex Pattern])))

(def ^:private records
  #?(:clj
     [schema.core.EqSchema
      schema.core.EnumSchema
      schema.core.Predicate
      schema.core.Maybe
      schema.core.NamedSchema
      schema.core.Either
      schema.core.Both
      schema.core.RequiredKey
      schema.core.OptionalKey
      schema.core.MapEntry
      schema.core.One
      schema.core.FnSchema
      schema.core.Isa]))

(defn- read-leaf-schema [x]
  (case x
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

(def ^:private record-read-handlers
  #?(:clj (apply t/record-read-handlers records))
  #?(:cljs (m/record-read-handlers
             EqSchema
             EnumSchema
             Predicate
             Maybe
             NamedSchema
             Either
             Both
             RequiredKey
             OptionalKey
             MapEntry
             One
             FnSchema
             Isa)))

(def read-handlers
  (assoc record-read-handlers
    "S" (t/read-handler read-leaf-schema)))

(defn- write-type-leaf-schema [x]
  #?(:clj
     (condp = x
       Boolean "Bool"
       Date "Inst"
       Number "Num"
       Pattern "Regex"
       String "Str"
       UUID "Uuid")))

(defn- write-pred-leaf-schema [x]
  #?(:clj
     (condp = (:p? x)
       integer? "Int"
       string? "Str"
       keyword? "Keyword"
       symbol? "Symbol")))

(def write-handlers
  #?(:clj
     (assoc (apply t/record-write-handlers records)
       Class (t/write-handler "S" write-type-leaf-schema)
       Predicate (t/write-handler "S" write-pred-leaf-schema)
       AnythingSchema (t/write-handler "S" (constantly "Any"))))
  #?(:cljs {}))
