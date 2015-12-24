(ns clojure-docker-api.cmd.containers
  (:require [clojure-docker-api.util :as util]
            [org.httpkit.client :as http]))

;; List containers
;; GET /containers/json
(defn list-containers
  [url & param]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "containers/json"
                         (if-not (empty? param)
                                  (str
                                    "?"
                                    (util/map-param-str (first param))))))]
    (util/build-resp-body @resp)))
