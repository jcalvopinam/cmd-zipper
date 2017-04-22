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

package com.jcalvopinam.domain;

import com.jcalvopinam.utils.Commons;

/**
 * Created by juanca on 4/20/17.
 */
public class CustomFile {

    public final static int BYTE_SIZE = 1024;

    private String path;
    private String fileName;
    private String fileNameExtension;
    private String fileExtension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (Commons.validateFirstPart(fileName)) {
            this.fileName = fileName.replace(Commons.SUFFIX.toLowerCase(), "");
        } else {
            this.fileName = fileName;
        }
    }

    public String getFileNameExtension() {
        return fileNameExtension;
    }

    public void setFileNameExtension(String fileNameExtension) {
        this.fileNameExtension = fileNameExtension;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
}
