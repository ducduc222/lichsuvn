package com.example.model;

public class Vua extends General {
    private String ngaysinh;
    private String ngaymat;
    private String ngaylenngoi;
    private String cha;
    public String getNgaymat() {
        return ngaymat;
    }

    public void setNgaymat(String ngaymat) {
        this.ngaymat = ngaymat;
    }


    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNgaylenngoi() {
        return ngaylenngoi;
    }

    public void setNgaylenngoi(String ngaylenngoi) {
        this.ngaylenngoi = ngaylenngoi;
    }

    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha;
    }
    public Vua(){

    }


    public Vua(String ten, String ngaysinh, String ngaymat, String ngaylenngoi, String cha){
        super(ten);
        this.ngaysinh = ngaysinh;
        this.ngaymat = ngaymat;
        this.ngaylenngoi = ngaylenngoi;
        this.cha = cha;
    }

}
