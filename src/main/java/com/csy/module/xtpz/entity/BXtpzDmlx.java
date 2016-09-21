package com.csy.module.xtpz.entity;

public class BXtpzDmlx {
    private Integer id;

    private Integer dmlxbh;

    private String ywm;

    private String zwm;

    private String pYwm;

    private String dmlxms;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDmlxbh() {
        return dmlxbh;
    }

    public void setDmlxbh(Integer dmlxbh) {
        this.dmlxbh = dmlxbh;
    }

    public String getYwm() {
        return ywm;
    }

    public void setYwm(String ywm) {
        this.ywm = ywm == null ? null : ywm.trim();
    }

    public String getZwm() {
        return zwm;
    }

    public void setZwm(String zwm) {
        this.zwm = zwm == null ? null : zwm.trim();
    }

    public String getpYwm() {
        return pYwm;
    }

    public void setpYwm(String pYwm) {
        this.pYwm = pYwm == null ? null : pYwm.trim();
    }

    public String getDmlxms() {
        return dmlxms;
    }

    public void setDmlxms(String dmlxms) {
        this.dmlxms = dmlxms == null ? null : dmlxms.trim();
    }
}