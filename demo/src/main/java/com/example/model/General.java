package com.example.model;

public class General implements IGeneral{
    private String ten;

    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getTen() {
        return ten;
    }

    public General(){

    }
    public General(String ten){
        this.ten = ten;
    }
    public void print(){
        System.out.println("Tên: "+this.getTen());
    }
}