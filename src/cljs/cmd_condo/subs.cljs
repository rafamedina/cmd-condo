(ns cmd-condo.subs
  (:require
   [re-frame.core :as re-frame]))

(defn query [db [event-id]]
  (event-id db))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::current-route
 (fn [db]
   (:current-route db)))
