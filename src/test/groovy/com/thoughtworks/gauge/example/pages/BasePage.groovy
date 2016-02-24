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

public abstract class BasePage {
    protected static String Url = System.getenv("APP_ENDPOINT")

    public static void storeStringToScenarioDataStore(String key, String value) {
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore()
        scenarioStore.put(key, value)
    }

    public static void storeStringToSpecDataStore(String key, String value) {
        DataStore specStore = DataStoreFactory.getSpecDataStore()
        specStore.put(key, value)
    }

    public static void storeStringToSuiteDataStore(String key, String value) {
        DataStore suiteStore = DataStoreFactory.getSuiteDataStore()
        suiteStore.put(key, value)
    }

    public static String fetchStringFromScenarioDataStore(String key) {
        DataStore scenarioStore = DataStoreFactory.getScenarioDataStore()
        return (String) scenarioStore.get(key)
    }

    public static String fetchStringFromSpecDataStore(String key) {
        DataStore specStore = DataStoreFactory.getSpecDataStore()
        return (String) specStore.get(key)
    }

    public static String fetchStringFromSuiteDataStore(String key) {
        DataStore suiteStore = DataStoreFactory.getSuiteDataStore()
        return (String) suiteStore.get(key)
    }
}
