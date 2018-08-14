package com.example.testapplication.utils;

import org.json.JSONArray;

public class SessionItem {

    private static JSONArray array;

    public static JSONArray getArray() {
        return array;
    }

    public static void setArray(JSONArray array) {
        SessionItem.array = array;
    }
}
