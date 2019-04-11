package com.nvh.hoannguyen.hoctienganh.cauhoi;

import java.io.Serializable;


public class cauhoi implements Serializable {
    private int id;
    private String cauhoi;
    private String dapana;
    private String dapanb;
    private String dapanc;
    private String dapand;
    private String ketqua;
    private String anh;
    private int sode;
    private int lop;
    private String traloi="";
    public int choiceID=-1;// hỗ trợ check ID của radiobutton

    public String getTraloi() {
        return traloi;
    }

    public void setTraloi(String traloi) {
        this.traloi = traloi;
    }

    public cauhoi(int id, String cauhoi, String dapana, String dapanb, String dapanc, String dapand, String ketqua, String anh, int sode, int lop, String traloi) {
        this.id = id;
        this.cauhoi = cauhoi;
        this.dapana = dapana;
        this.dapanb = dapanb;
        this.dapanc = dapanc;
        this.dapand = dapand;
        this.ketqua = ketqua;
        this.anh = anh;
        this.sode = sode;
        this.lop= lop;
        this.traloi=traloi;
    }

    public cauhoi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getDapana() {
        return dapana;
    }

    public void setDapana(String dapana) {
        this.dapana = dapana;
    }

    public String getDapanb() {
        return dapanb;
    }

    public void setDapanb(String dapanb) {
        this.dapanb = dapanb;
    }

    public String getDapanc() {
        return dapanc;
    }

    public void setDapanc(String dapanc) {
        this.dapanc = dapanc;
    }

    public String getDapand() {
        return dapand;
    }

    public void setDapand(String dapand) {
        this.dapand = dapand;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getSode() {
        return sode;
    }

    public void setSode(int sode) {
        this.sode = sode;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }
}
