package com.example.scraper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.model.ListLichSu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;

public class ScrapAll {
    public static void scrapAll() throws IOException {
        ListLichSu listLichSu = new ListLichSu();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println("Đang quét Vua...");
        ScraperVua.scraperVua(listLichSu);
        System.out.println("Đã xong vua");

        System.out.println("\nĐang quét Triều đại...");
        ScraperTrieuDai.scraperTrieuDai(listLichSu);
        System.out.println("Đã xong triều đại");

        System.out.println("\nĐang quét Di tích...");
        ScraperDiTich.scraperDiTich(listLichSu);
        System.out.println("Đã xong di tích ");

        System.out.println("\nĐang quét Sự kiện...");
        ScraperSuKien.scraperSukien(listLichSu);
        System.out.println("Đã xong sự kiện ");

        System.out.println("\nĐang quét Lễ hội...");
        ScraperLeHoi.scraperLeHoi(listLichSu);
        System.out.println("Đã xong lễ hội");

        String currentDirectory = System.getProperty("user.dir");
        String nameFile = currentDirectory + "/src/main/java/com/example/lichsu.json";
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(listLichSu, writer);
        }
        listLichSu.printLength();

    }
}
