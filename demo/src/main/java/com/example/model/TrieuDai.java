package com.example.model;

import java.util.ArrayList;

public class TrieuDai extends General {
    public TrieuDai(String ten) {
        super(ten);
    }

    ArrayList<Vua> cacVua = new ArrayList<Vua>();

    public boolean addVua (Vua vua) {
        if (!cacVua.contains(vua))
            cacVua.add(vua);
        return true;
    }



    public ArrayList<Vua> getCacVua() {
        return cacVua;
    }
    
}
