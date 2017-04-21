package com.jcalvopinam.domain;

import com.jcalvopinam.Utils.Commons;

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
