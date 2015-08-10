(defproject org.clojars.akiel/transit-schema "0.2-SNAPSHOT"
  :description "Semantic types for Transit to convey Schemas."
  :url "https://github.com/alexanderkiel/hap-todo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [com.cognitect/transit-clj "0.8.275"
                  :exclusions
                  [com.fasterxml.jackson.datatype/jackson-datatype-json-org
                   com.googlecode.json-simple/json-simple]]
                 [com.cognitect/transit-cljs "0.8.220"]
                 [prismatic/schema "0.4.3"]])
