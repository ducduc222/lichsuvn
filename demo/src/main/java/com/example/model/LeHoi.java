package com.example.model;

import java.util.ArrayList;

public class LeHoi extends General {
    private String diadiem;
    private String ngaytochuc;
    private ArrayList<Vua> cacvua = new ArrayList<Vua>();
    private ArrayList<SuKien> cacsukien = new ArrayList<SuKien>();
    private ArrayList<DiTich> cacditich = new ArrayList<DiTich>();

    public ArrayList<Vua> getCacvua() {
        if (cacvua.isEmpty()) return null;
        return cacvua;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getNgaytochuc() {
        return ngaytochuc;
    }

    public void setNgaytochuc(String ngaytochuc) {
        this.ngaytochuc = ngaytochuc;
    }

    public boolean addVua(Vua vua) {
        if (!cacvua.contains(vua))
            cacvua.add(vua);
        return true;
    }

    public boolean addSuKien(SuKien suKien) {
        if (!cacsukien.contains(suKien))
            cacsukien.add(suKien);
        return true;
    }

    public boolean addDiTich(DiTich diTich) {
        if (!cacditich.contains(diTich))
            cacditich.add(diTich);
        return true;
    }

    public LeHoi(String ten, String diadiem, String ngaytochuc) {
        super(ten);
        this.diadiem = diadiem;
        this.ngaytochuc = ngaytochuc;
    }
    public LeHoi() {
        Vua vua = new Vua();
        SuKien suKien = new SuKien();
        DiTich diTich = new DiTich();
        this.addVua(vua);
        this.addDiTich(diTich);
        this.addSuKien(suKien);
    }

    public ArrayList<SuKien> getCacsukien() {
        return cacsukien;
    }

    public ArrayList<DiTich> getCacditich() {
        return cacditich;
    }
}
