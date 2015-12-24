(ns clojure-docker-api.cmd.misc
  (:require [clojure-docker-api.util :as util]
            [org.httpkit.client :as http]))

(defn auth
  [url auth-param]
  (let [resp (http/post (str (util/wrap-url url) "auth")
                        {:query-params auth-param,
                         :headers {"ContentType" "application/json"}})]
    (util/build-resp-body @resp)))

(defn info
  [url]
  (let [resp (http/get  (str (util/wrap-url url) "info"))]
    (util/build-resp-body @resp)))

(defn version
  [url]
  (let [resp (http/get (str (util/wrap-url url) "version"))]
    (util/build-resp-body @resp)))

(defn ping
  [url]
  (let [resp (http/get (str (util/wrap-url url) "/_ping"))]
    (util/build-resp-body @resp)))

(defn new-image-from-container
  [url param]
  (let [resp (http/post
               (str (util/wrap-url url)
                    "commit?"
                    (util/map-param-str param)))]
    (util/build-resp-body @resp)))

(defn events
  [url param]
  (let [resp (http/get (str (util/wrap-url url)
                            "events?"
                            (util/map-param-str param)))]
    (util/build-resp-body @resp)))

;; Exec Create
;; POST /containers/(id)/exec
(defn exec-create
  [url id]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "containers/"
                          id
                          "/exec"))]
    (util/build-resp-body @resp)))

;; Exec Start
;; POST /exec/(id)/start
(defn exec-start
  [url id]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "exec/"
                          id
                          "start"))]
    (util/build-resp-body @resp)))

;; Exec Resize
;; POST /exec/(id)/resize
(defn exec-resize
  [url id param]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "exec/"
                          id
                          "/resize?"
                          (util/map-param-str param)))]
    (util/build-resp-body @resp)))

;; Exec Inspect
;; GET /exec/(id)/json
(defn exec-inspect
  [url id]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "exec/"
                         id
                         "/json"))]
    (util/build-resp-body @resp)))

;; List Volumes
;; GET /volumes
(defn list-volumes
  [url]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "/volumes"))]
    (util/build-resp-body @resp)))

;; Create a volume
;; POST /volumes/create
(defn create-volume
  [url param]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "volumes/create")
                        {:query-params param,
                         :headers {"ContentType" "application/json"}})]
    (util/build-resp-body @resp)))

;; Inspect a volume
;; GET /volumes/(name)
(defn inspect-volume
  [url name]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "volumes/"
                         name))]
    (util/build-resp-body @resp)))

;; Remove a volume
;; DELETE /volumes/(name)
(defn remove-volume
  [url name]
  (let [resp (http/delete (str
                            (util/wrap-url url)
                            "volumes/"
                            name))]
    (util/build-resp-body @resp)))

;; List networks
;; GET /networks
(defn list-networks
  [url]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "networks"))]
    (util/build-resp-body @resp)))

;; Inspect networks
;; GET /networks/<network-id>
(defn inspect-networks
  [url id]
  (let [resp (http/get (str
                         (util/wrap-url url)
                         "networks/"
                         id))]
    (util/build-resp-body @resp)))

;; Create a network
;; POST /networks/create
(defn create-network
  [url param]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "/networks/create")
                        {:query-params param,
                         :headers {"ContentType" "application/json"}})]
    (util/build-resp-body @resp)))

;; Connect a container to a network
;; POST /networks/(id)/connect
(defn connect-network
  [url id]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "networks/"
                          id
                          "/connect"))]
    (util/build-resp-body @resp)))

;; Disconnect a container from a network
;; POST /networks/(id)/disconnect
(defn disconnect-network
  [url id]
  (let [resp (http/post (str
                          (util/wrap-url url)
                          "networks/"
                          id
                          "/disconnect"))]
    (util/build-resp-body @resp)))

;; Remove a network
;; DELETE /networks/(id)
(defn remove-network
  [url id]
  (let [resp (http/delete (str
                            (util/wrap-url url)
                            "networks/"
                            id))]
    (util/build-resp-body @resp)))