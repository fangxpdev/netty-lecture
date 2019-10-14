package com.fangxp.netty.custom;

import java.io.Serializable;

public class FMessageHeader implements Serializable {

    private static final long serialVersionUID = 1008747321763691187L;

    private int version;

    private int contentLength;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }


    @Override
    public String toString() {
        return "FMessageHeader{" +
                "version=" + version +
                ", contentLength=" + contentLength +
                '}';
    }
}
