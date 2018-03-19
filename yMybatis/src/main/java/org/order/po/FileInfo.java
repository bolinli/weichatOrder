package org.order.po;

import java.io.Serializable;

/**
 *
 * @Author libolin
 * @Create 2018/3/14 16:43
 */
public class FileInfo implements Serializable {
    private String orgName;
    private String fileName;
    private Long fileSize;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}


