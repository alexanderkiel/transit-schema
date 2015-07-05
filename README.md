__This software is ALPHA.__

# Transit Schema

[![Build Status](https://travis-ci.org/alexanderkiel/transit-schema.svg?branch=master)](https://travis-ci.org/alexanderkiel/transit-schema)

Semantic types for [Transit][1] to convey [Schemas][2]. Works in Clojure and
ClojureScript.

## Install

To install, just add the following to your project dependencies:

```clojure
[org.clojars.akiel/transit-schema "0.1-SNAPSHOT"]
```

## Usage

Add transit schema as dependency to your namespace declaration.

```clojure
(ns ...
  (:require [transit-schema.core :as ts]))
```

Add read and write handlers to your Transit readers and writers.

```clojure
(transit/reader in :json {:handlers (ts/read-handlers)})
(transit/writer out :json {:handlers (ts/write-handlers)})
```

## Semantic Types

| Semantic Type | Tag | Rep Tag | Rep    | String Rep | MessagePack | JSON     | JSON-Verbose |
|---------------|-----|---------|--------|------------|-------------|----------|--------------|
| leaf schema   | S   | s       | "leaf" |            | "~Sleaf"    | "~Sleaf" | "~Sleaf"     |
| record schema | record name | map | map suitable to create the record | |    |              |

The following leaf schemas are supported:

* Any 
* Bool 
* Keyword
* Inst 
* Int
* Num
* Regex
* Str
* Symbol
* Uuid 
                                  
## License

Copyright © 2015 Alexander Kiel

Distributed under the Eclipse Public License, the same as Clojure.

[1]: <https://github.com/cognitect/transit-format>
[2]: <https://github.com/Prismatic/schema>
