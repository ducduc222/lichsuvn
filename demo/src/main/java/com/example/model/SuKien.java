package com.example.model;

import java.util.ArrayList;

public class SuKien extends General {

    private String ngay;
    ArrayList<Vua> vuas = new ArrayList<Vua>();


    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }


    public SuKien() {

    }


    public SuKien(String ten, String ngay) {
        super(ten);
        this.ngay = ngay;
    }

    public boolean addVua(Vua vua) {
        if (!vuas.contains(vua))
            vuas.add(vua);
        return true;
    }

    public void printVua() {
        if (!vuas.isEmpty()) {
            for (Vua vua : vuas) {
                System.out.print(vua.getTen() + ",");
            }
        }
    }

    public ArrayList<Vua> getVuas() {
        return vuas;
    }

}

