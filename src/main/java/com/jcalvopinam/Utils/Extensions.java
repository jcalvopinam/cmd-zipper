package com.jcalvopinam.Utils;

/**
 * Created by juanca on 4/20/17.
 */
public enum Extensions {

    ZIP(".zip");

    private String extension;

    Extensions(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}
