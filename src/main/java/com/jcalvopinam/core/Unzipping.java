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

package com.jcalvopinam.core;

import com.jcalvopinam.domain.CustomFile;
import com.jcalvopinam.utils.Extensions;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by juanca on 4/19/17.
 */
public class Unzipping {

    private final static String REBUILT = "rebuilt";

    public Unzipping(String path) throws IOException {
        CustomFile customFile = new CustomFile();
        File inputFile = new File(path);

        customFile.setPath(String.format("%s%s", inputFile.getParent(), File.separator));
        customFile.setFileName(inputFile.getName());
        customFile.setFileNameExtension(inputFile.getName());
        customFile.setFileExtension(FilenameUtils.getExtension(inputFile.getName()));

        joinAndUnzipFile(inputFile, customFile);
    }

    private static void joinAndUnzipFile(File inputFile, CustomFile customFile)
            throws IOException {

        ZipInputStream is = null;
        File path = inputFile.getParentFile();

        List<InputStream> fileInputStream = new ArrayList<>();
        for (String fileName : path.list()) {
            if (fileName.startsWith(customFile.getFileName()) && fileName.endsWith(Extensions.ZIP.getExtension())) {
                fileInputStream.add(new FileInputStream(String.format("%s%s", customFile.getPath(), fileName)));
                System.out.println(String.format("File found: %s", fileName));
            }
        }

        if (fileInputStream.size() > 0) {
            String fileNameOutput = String.format("%s%s", customFile.getPath(), customFile.getFileName());
            OutputStream os = new BufferedOutputStream(new FileOutputStream(fileNameOutput));
            try {
                System.out.println("Please wait while the files are joined: ");

                ZipEntry ze;
                for (InputStream inputStream : fileInputStream) {
                    is = new ZipInputStream(inputStream);
                    ze = is.getNextEntry();
                    customFile.setFileName(String.format("%s_%s", REBUILT, ze.getName()));

                    byte[] buffer = new byte[CustomFile.BYTE_SIZE];

                    for (int readBytes; (readBytes = is.read(buffer, 0, CustomFile.BYTE_SIZE)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                        System.out.print(".");
                    }
                }
            } finally {
                os.flush();
                os.close();
                is.close();
                renameFinalFile(customFile, fileNameOutput);
            }
        } else {
            throw new FileNotFoundException("Error: The file not exist!");
        }
        System.out.println("\nEnded process!");
    }

    private static void renameFinalFile(CustomFile customFile, String fileNameOutput) {
        File output = new File(fileNameOutput);
        output.renameTo(new File(customFile.getPath() + customFile.getFileName()));
    }

}
