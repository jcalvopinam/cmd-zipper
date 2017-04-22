/*
This file is part of cmd-zipper.

cmd-zipper is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License.

cmd-zipper is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

http://www.gnu.org/licenses/
*/

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
