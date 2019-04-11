package com.nvh.hoannguyen.hoctienganh.Lop1;

// dòng bài học từ vựng
public class Baihoctuvung {
    private  String Ten;
    private  String Mota;
    private  int Hinh;

    public Baihoctuvung(String ten, String mota, int hinh) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
