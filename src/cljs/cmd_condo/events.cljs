(ns cmd-condo.events
  (:require
   [cmd-condo.db :as db]
   [re-frame.core :as re-frame]
   [reitit.frontend.controllers :as frontend.controllers]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-fx
 ::navigate
 (fn [db [_ & route]]
   ;; See `navigate` effect in routes.cljs
   {::navigate! route}))


(re-frame/reg-event-db
 ::navigated
 (fn [db [_ new-match]]
   (let [old-match   (:current-route db)
         controllers (frontend.controllers/apply-controllers (:controllers old-match) new-match)]
     (assoc db :current-route (assoc new-match :controllers controllers)))))
