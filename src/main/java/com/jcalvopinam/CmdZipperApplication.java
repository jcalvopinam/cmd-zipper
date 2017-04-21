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
        String option = "";

        do {
            System.out.println("M E N U");
            System.out.println("[1] Split file in parts");
            System.out.println("[2] Attach parts of the file");
            System.out.println("[0] Exit");

            System.out.print("Please choose an option: ");
            option = scanner.nextLine();

        } while (option != "" && !option.matches(Commons.REGEX_NUMBERS));

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
        scanner.close();
    }

}
