(ns cmd-condo.views
  (:require
   [re-frame.core :as re-frame]
   [cmd-condo.subs :as subs]
   ))

(defn not-found-ui [] [:div "Not found"])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     ]))
