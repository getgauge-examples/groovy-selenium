package com.thoughtworks.gauge.example.pages

import com.thoughtworks.gauge.datastore.DataStore
import com.thoughtworks.gauge.datastore.DataStoreFactory

/*
To use the examples locally you would need to follow these steps:
-----------------------------------------------------------------
 git clone https://github.com/getgauge/activeadmin-demo
 cd activeadmin-demo
 bundle install
 ./script/rails server
*/

 abstract class BasePage {
    protected static String BASE_URL = System.getenv("APP_ENDPOINT")

     static void storeStringToScenarioDataStore(String key, String value) {
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore()
        scenarioStore.put(key, value)
    }

     static void storeStringToSpecDataStore(String key, String value) {
        DataStore specStore = DataStoreFactory.getSpecDataStore()
        specStore.put(key, value)
    }

     static void storeStringToSuiteDataStore(String key, String value) {
        DataStore suiteStore = DataStoreFactory.getSuiteDataStore()
        suiteStore.put(key, value)
    }

     static String fetchStringFromScenarioDataStore(String key) {
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore()
        scenarioStore.get(key)
    }

     static String fetchStringFromSpecDataStore(String key) {
        DataStore specStore = DataStoreFactory.getSpecDataStore()
        specStore.get(key)
    }

     static String fetchStringFromSuiteDataStore(String key) {
        DataStore suiteStore = DataStoreFactory.getSuiteDataStore()
        suiteStore.get(key)
    }
}
