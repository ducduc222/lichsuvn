package com.example.demo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Vua;
import com.google.gson.Gson;

public class JsonFileParser {

    public List<Vua> parseJsonFile(String filePath) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);
        Vuas vuas = gson.fromJson(reader, Vuas.class);
        reader.close();
        return vuas.vuas;
    }

    private static class Vuas {
        private List<Vua> vuas = new ArrayList<>();
    }

}
