package com.wind.dashboard.jsonmapper.utils;

public class ConverterUtils {

    /**
     *
     * @param size
     * @return
     */
    public static String toGB(long size) {
        double gb = size /  (1024 * 1024 * 1024);
        return String.format("%.2f", gb);
    }
}