package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ListLichSu;
import com.example.model.Vua;
import com.google.gson.Gson;

public class JsonFileParser {

    public static ListLichSu parseJsonFile(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);
        ListLichSu listLichSu1 = gson.fromJson(reader, ListLichSu.class);

        return listLichSu1;
    }



}
