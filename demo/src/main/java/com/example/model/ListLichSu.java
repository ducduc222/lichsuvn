package com.example.model;

import java.util.ArrayList;

public class ListLichSu {
    private ArrayList<Vua> vuas = new ArrayList<Vua>();
    private ArrayList<SuKien> suKiens = new ArrayList<SuKien>();
    private ArrayList<TrieuDai> trieuDais = new ArrayList<TrieuDai>();
    private ArrayList<LeHoi> leHois = new ArrayList<LeHoi>();
    private ArrayList<DiTich> diTichs = new ArrayList<DiTich>();

    public void printLength() {
        System.out.print("Số Vua, nhân vật lịch sử: ");
        System.out.println(vuas.size());
        System.out.print("Số triều đại: ");
        System.out.println(trieuDais.size());
        System.out.print("Số di tích: ");
        System.out.println(diTichs.size());
        System.out.print("Số sự kiện: ");
        System.out.println(suKiens.size());
        System.out.print("Số lễ hội: ");
        System.out.println(leHois.size());
    }
    public ArrayList<Vua> getVuas() {
        return vuas;
    }

    public ArrayList<SuKien> getSuKiens() {
        return suKiens;
    }

    public ArrayList<TrieuDai> getTrieuDais() {
        return trieuDais;
    }

    public ArrayList<LeHoi> getLeHois() {
        return leHois;
    }

    public ArrayList<DiTich> getDiTichs() {
        return diTichs;
    }

    public int getLength(ArrayList<? extends General> generals) {
        return generals.size();
    }
    public boolean addGeneral(General general) {
        if (general instanceof SuKien) suKiens.add((SuKien) general);
        if (general instanceof Vua) vuas.add((Vua) general);
        if (general instanceof TrieuDai) trieuDais.add((TrieuDai) general);
        if (general instanceof DiTich) diTichs.add((DiTich) general);
        if (general instanceof LeHoi) leHois.add((LeHoi) general);

        return true;
    }

    public void setVuas(ArrayList<Vua> vuas) {
        this.vuas = vuas;
    }

    public void setSuKiens(ArrayList<SuKien> suKiens) {
        this.suKiens = suKiens;
    }

    public void setTrieuDais(ArrayList<TrieuDai> trieuDais) {
        this.trieuDais = trieuDais;
    }

    public void setLeHois(ArrayList<LeHoi> leHois) {
        this.leHois = leHois;
    }

    public void setDiTichs(ArrayList<DiTich> diTichs) {
        this.diTichs = diTichs;
    }
}
