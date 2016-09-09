package com.csy.module.user.entity;

import java.util.Date;

public class BUserInfo {
    private String foreignAccount;

    private Byte gender;

    private Date birthday;

    private String signature;

    private String favicon;

    private Integer blood;

    private String address;

    private String tag;

    public String getForeignAccount() {
        return foreignAccount;
    }

    public void setForeignAccount(String foreignAccount) {
        this.foreignAccount = foreignAccount == null ? null : foreignAccount.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon == null ? null : favicon.trim();
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}