(ns clojure-docker-api.core-test
  (:require [expectations :refer :all]
            [clojure-docker-api.core :as api-core]
            [clojure-docker-api.util :as util]))
(def param-map {:name "kim", :age 20, :password "helloworld"})

(expect "http://www.google.com/" (util/wrap-url "http://www.google.com"))
(expect "http://www.google.com/" (util/wrap-url "http://www.google.com/"))
(expect "name=kim&age=20&password=helloworld" (util/map-param-str param-map))
