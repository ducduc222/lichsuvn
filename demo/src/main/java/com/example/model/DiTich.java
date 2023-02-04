package com.example.model;

public class DiTich extends General {
    private String diadiem;
    private String loaiditich;
    private String namcongnhan;


    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getLoaiditich() {
        return loaiditich;
    }

    public void setLoaiditich(String loaiditich) {
        this.loaiditich = loaiditich;
    }

    public String getNamcongnhan() {
        return namcongnhan;
    }

    public void setNamcongnhan(String namcongnhan) {
        this.namcongnhan = namcongnhan;
    }

    public DiTich(String ten, String diadiem, String loaiditich, String namcongnhan) {
        super(ten);
        this.diadiem = diadiem;
        this.loaiditich = loaiditich;
        this.namcongnhan = namcongnhan;
    }

    public void print() {
        System.out.println("Di tich: "+this.getTen());
        System.out.println("Dia diem: "+this.getDiadiem());
        System.out.println("Nam cong nhan: "+this.getNamcongnhan());
        System.out.println("Loai di tich: "+this.getLoaiditich());
    }

    public DiTich() {
    }
}
