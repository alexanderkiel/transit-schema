(defproject org.clojars.akiel/transit-schema "0.5"
  :description "Semantic types for Transit to convey Schemas."
  :url "https://github.com/alexanderkiel/transit-schema"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.5.2"
  :pedantic? :abort

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [com.cognitect/transit-cljs "0.8.243"]
                 [prismatic/schema "1.1.7"]]

  :profiles
  {:dev
   {:dependencies [[org.clojure/clojurescript "1.9.946"]]}})
