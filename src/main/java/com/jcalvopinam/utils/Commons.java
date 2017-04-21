package com.jcalvopinam.utils;

/**
 * Created by juanca on 4/21/17.
 */
public class Commons {

    public final static String SUFFIX = "_001.zip";
    public final static String REGEX_NUMBERS = "[0-2]+";

    public static boolean validateFirstPart(String fullFilePath) {
        return fullFilePath.toLowerCase().endsWith(SUFFIX);
    }
}
