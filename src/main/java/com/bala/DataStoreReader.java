package com.bala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DataStoreReader
 */
public class DataStoreReader {

    public static List<String> getMerchantCodes() {
        System.out.println("Loading values from data store");
        // In this example, I'm just returning a static list of String.
        /*
         * However, you can write a suitable code to connect to an external data store
         * (data grid or database or properties file or any other external system etc.,)
         * that contains the list of values
         */
        return new ArrayList<String>(Arrays.asList(new String[] { "P1", "P2" }));

    }
}