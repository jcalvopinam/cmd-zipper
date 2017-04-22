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
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by juanca on 4/17/17.
 */
public class Zipping {

    /***
     *
     * @param path path of file to core
     * @param fileSize size for each file in MB
     */
    public Zipping(String path, int fileSize) throws IOException {
        CustomFile customFile = new CustomFile();
        File inputFile = new File(path);

        customFile.setPath(String.format("%s%s", inputFile.getParent(), File.separator));
        customFile.setFileName(FilenameUtils.getBaseName(inputFile.getName()));
        customFile.setFileNameExtension(inputFile.getName());
        customFile.setFileExtension(FilenameUtils.getExtension(inputFile.getName()));

        int bufferSize = CustomFile.BYTE_SIZE * CustomFile.BYTE_SIZE * fileSize;
        splitAndZipFile(inputFile, bufferSize, customFile);
    }

    private static void splitAndZipFile(File inputFile, int bufferSize, CustomFile customFile) throws IOException {

        int counter = 1;
        byte[] bufferPart;
        byte[] buffer = new byte[bufferSize];
        File newFile;
        FileInputStream fileInputStream;
        ZipOutputStream out;
        String temporalName;
        String outputFileName;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))) {

            int tmp;

            System.out.println("Please wait while the file is split:");
            while ((tmp = bis.read(buffer)) > 0) {
                temporalName = String.format("%s.%03d", customFile.getFileName(), counter);
                newFile = new File(inputFile.getParent(), temporalName);

                try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
                    fileOutputStream.write(buffer, 0, tmp);
                }

                fileInputStream = new FileInputStream(newFile);//file001.zip
                outputFileName = String
                        .format("%s%s_%03d%s", customFile.getPath(), customFile.getFileName(), counter,
                                Extensions.ZIP.getExtension());
                out = new ZipOutputStream(new FileOutputStream(outputFileName));

                out.putNextEntry(new ZipEntry(customFile.getFileNameExtension()));

                bufferPart = new byte[CustomFile.BYTE_SIZE];
                int count;

                while ((count = fileInputStream.read(bufferPart)) > 0) {
                    out.write(bufferPart, 0, count);
                    System.out.print(".");
                }

                counter++;
                fileInputStream.close();
                out.close();

                FileUtils.deleteQuietly(newFile);
            }
        }

        System.out.println("\nEnded process!");
    }

}
