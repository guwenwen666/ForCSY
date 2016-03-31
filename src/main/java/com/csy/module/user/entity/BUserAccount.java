package com.csy.module.user.entity;

import java.util.Date;

public class BUserAccount {
    private Long id;

    private String account;

    private String password;

    private String nickname;

    private String email;

    private Byte emailstatue;

    private String phone;

    private Byte phonestatue;

    private String safekey;

    private Byte status;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getEmailstatue() {
        return emailstatue;
    }

    public void setEmailstatue(Byte emailstatue) {
        this.emailstatue = emailstatue;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Byte getPhonestatue() {
        return phonestatue;
    }

    public void setPhonestatue(Byte phonestatue) {
        this.phonestatue = phonestatue;
    }

    public String getSafekey() {
        return safekey;
    }

    public void setSafekey(String safekey) {
        this.safekey = safekey == null ? null : safekey.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}