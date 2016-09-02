package com.csy.module.user.entity;

import java.util.Date;

public class BUserFilestore {
    private Integer id;

    private String foreignAccount;

    private String filetype;

    private String tags;

    private String filename;

    private Long filesize;

    private Date createtime;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForeignAccount() {
        return foreignAccount;
    }

    public void setForeignAccount(String foreignAccount) {
        this.foreignAccount = foreignAccount == null ? null : foreignAccount.trim();
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}