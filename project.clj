(defproject org.clojars.akiel/transit-schema "0.1"
  :description "Semantic types for Transit to convey Schemas."
  :url "https://github.com/alexanderkiel/hap-todo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.0.0"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [com.cognitect/transit-clj "0.8.275"
                  :exclusions
                  [com.fasterxml.jackson.datatype/jackson-datatype-json-org
                   com.googlecode.json-simple/json-simple]]
                 [com.cognitect/transit-cljs "0.8.220"]
                 [prismatic/schema "0.4.3"]])
