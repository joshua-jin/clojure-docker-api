(ns clojure-docker-api.util
  (:require [clojure.string :as s]))

(defn map-param-str
  [m]
  (s/join "&"
          (reduce #(conj %1
                             (str (name (key %2)) "=" (val %2)))
                      []
                      m)))

(defn wrap-url
  [url]
  (if (= \/ (last url))
    url
    (str url "/")))
