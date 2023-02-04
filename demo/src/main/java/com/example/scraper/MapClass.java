package com.example.scraper;

import com.example.model.*;

import java.util.HashMap;
import java.util.Map;

public class MapClass {
    public static Map<String, Vua> mapVua = new HashMap<String, Vua>();
    public static Map<String, TrieuDai> mapTrieuDai = new HashMap<String, TrieuDai>();
    public static Map<String, SuKien> mapSuKien = new HashMap<String, SuKien>();
    public static Map<String, LeHoi> mapLeHoi = new HashMap<String, LeHoi>();
    public static Map<String, DiTich> mapDiTich = new HashMap<String, DiTich>();

    public static boolean setMap(String link, General general) {
        if (general instanceof Vua)
            mapVua.put(link, (Vua) general);
        if (general instanceof TrieuDai)
            mapTrieuDai.put(link, (TrieuDai) general);
        if (general instanceof DiTich)
            mapDiTich.put(link, (DiTich) general);
        if (general instanceof LeHoi)
            mapLeHoi.put(link, (LeHoi) general);
        if (general instanceof SuKien)
            mapSuKien.put(link, (SuKien) general);

        return true;
    }
}
