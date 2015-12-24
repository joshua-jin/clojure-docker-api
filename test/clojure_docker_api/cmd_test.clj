(ns clojure-docker-api.cmd-test
  (:require [expectations :refer :all]
            [clojure-docker-api.util :as util]))

(def docker-url "http://119.254.211.121:4243")
(def param-map {:name "kim", :age 20, :password "helloworld"})

;; auth command url
(expect "http://119.254.211.121:4243/auth" (str (util/wrap-url docker-url) "auth"))

;; info command url
(expect "http://119.254.211.121:4243/info" (str (util/wrap-url docker-url) "info"))

;; version command url
(expect "http://119.254.211.121:4243/version" (str (util/wrap-url docker-url) "version"))

;; ping command url
(expect "http://119.254.211.121:4243/_ping" (str (util/wrap-url docker-url) "_ping"))

;; create a new image from a container's change url
(expect "http://119.254.211.121:4243/commit?name=kim&age=20&password=helloworld"
        (str (util/wrap-url docker-url)
             "commit?"
             (util/map-param-str param-map)))

;; monitor docker's events url
(expect "http://119.254.211.121:4243/events?name=kim&age=20&password=helloworld"
        (str (util/wrap-url docker-url)
             "events?"
             (util/map-param-str param-map)))

;; exec instance in a running container url
(expect "http://119.254.211.121:4243/containers/2924324/exec"
        (str (util/wrap-url docker-url)
             "containers/"
             "2924324"
             "/exec"))

;; start an instance url
(expect "http://119.254.211.121:4243/exec/2924324/start"
        (str (util/wrap-url docker-url)
             "exec/"
             "2924324"
             "/start"))

;; exec resize url
(expect "http://119.254.211.121:4243/exec/2924324/resize?name=kim&age=20&password=helloworld"
        (str (util/wrap-url docker-url)
             "exec/"
             "2924324"
             "/resize?"
             (util/map-param-str param-map)))


;; exec inspect url
(expect "http://119.254.211.121:4243/exec/2924324/json"
        (str (util/wrap-url docker-url)
             "exec/"
             "2924324"
             "/json"))

;; exec list volumes url
(expect "http://119.254.211.121:4243/volumes"
        (str (util/wrap-url docker-url)
             "volumes"))

;; exec create volume url
(expect "http://119.254.211.121:4243/volume/create"
        (str (util/wrap-url docker-url)
             "volume/create"))

;; exec inspect/remove volume url
(expect "http://119.254.211.121:4243/volumes/joshua"
        (str (util/wrap-url docker-url)
             "volumes/"
             "joshua"))

;; list networks volume url
(expect "http://119.254.211.121:4243/networks"
        (str (util/wrap-url docker-url)
             "networks"))

;; inspect networks url
(expect "http://119.254.211.121:4243/networks/4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"
        (str (util/wrap-url docker-url)
             "networks/"
             "4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"))

;; create a network url
(expect "http://119.254.211.121:4243/networks/create"
        (str (util/wrap-url docker-url)
             "networks/create"))

;; connect a container to a network url
(expect "http://119.254.211.121:4243/networks/4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11/connect"
        (str (util/wrap-url docker-url)
             "networks/"
             "4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"
             "/connect"))

;; disconnect a container to a network url
(expect "http://119.254.211.121:4243/networks/4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11/disconnect"
        (str (util/wrap-url docker-url)
             "networks/"
             "4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"
             "/disconnect"))

;; remove a network in container url
(expect "http://119.254.211.121:4243/networks/4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"
        (str (util/wrap-url docker-url)
             "networks/"
             "4a6ee5804c21483c091142ec51e2fc862d8972941cd5379c94f9065c9bc94a11"))