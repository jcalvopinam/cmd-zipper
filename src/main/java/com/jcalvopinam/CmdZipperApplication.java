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

package com.jcalvopinam;

import com.jcalvopinam.core.Unzipping;
import com.jcalvopinam.core.Zipping;
import com.jcalvopinam.utils.Commons;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by juanca on 4/17/17.
 */
public class CmdZipperApplication {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            System.out.println("M E N U");
            System.out.println("[1] Split file in parts");
            System.out.println("[2] Attach parts of the file");
            System.out.println("[0] Exit");

            System.out.print("Please choose an option: ");
            option = scanner.nextLine();
            options(option, scanner);

        } while (!option.equals(String.valueOf(0)));
        scanner.close();
    }

    private static void options(String option, Scanner scanner) throws IOException {
        if (option.matches(Commons.REGEX_NUMBERS)) {
            switch (Integer.valueOf(option)) {
                case 1:
                    System.out.println("Please enter the full file path: ");
                    String fileToZip = scanner.nextLine();
                    System.out.println("Please enter the size file (MB) to split: ");
                    int fileSize = scanner.nextInt();
                    Zipping zipping = new Zipping(fileToZip, fileSize);
                    break;
                case 2:
                    System.out.println("Please enter the full path of the first part: ");
                    String fileToUnzip = scanner.nextLine();
                    if (Commons.validateFirstPart(fileToUnzip)) {
                        Unzipping unzipping = new Unzipping(fileToUnzip);
                    } else {
                        System.out.println("Wrong file!");
                    }
                    break;
            }
        }
    }
}
