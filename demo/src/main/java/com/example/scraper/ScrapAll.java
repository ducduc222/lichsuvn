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
    public static void scrapAll(ListLichSu listLichSu) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String currentDirectory = System.getProperty("user.dir");
         System.out.println(currentDirectory);

         SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
         Date date = new Date();
         String dateString = dateFormat.format(date);

         File directory = new File(currentDirectory + "/src/main/resources/" + dateString);

         if (!directory.exists()) {
             if (directory.mkdirs())
                 System.out.println("đã tạo thư mục " + dateString);
         }
         
        String nameFile = currentDirectory + "/src/main/resources/" + dateString + "/cacVua.json";
        ScraperVua.scraperVua(listLichSu);
        System.out.println("Đã xong vua");
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(listLichSu.getVuas(), writer);
        }

       ScraperTrieuDai.scraperTrieuDai(listLichSu);
       System.out.println("Đã xong triều đại");
       nameFile = currentDirectory + "/src/main/resources/" + dateString + "/cacTrieuDai.json";
       try (FileWriter writer = new FileWriter(nameFile)) {
           gson.toJson(listLichSu.getTrieuDais(), writer);
       }

       ScraperDiTich.scraperDiTich(listLichSu);
       System.out.println("Đã xong di tích ");
       nameFile = currentDirectory + "/src/main/resources/" + dateString + "/cacDiTich.json";
       try (FileWriter writer = new FileWriter(nameFile)) {
           gson.toJson(listLichSu.getDiTichs(), writer);
       }

        ScraperSuKien.scraperSukien(listLichSu);
        System.out.println("Đã xong sự kiện ");
        nameFile = currentDirectory + "/src/main/resources/" + dateString + "/cacSuKien.json";
        try (FileWriter writer = new FileWriter(nameFile)) {
            gson.toJson(listLichSu.getSuKiens(), writer);
        }

         ScraperLeHoi.scraperLeHoi(listLichSu);
         System.out.println("Đã xong lễ hội");
         nameFile = currentDirectory + "/src/main/resources/" + dateString + "/cacLeHoi.json";
         try (FileWriter writer = new FileWriter(nameFile)) {
             gson.toJson(listLichSu.getLeHois(), writer);
         }

         nameFile = currentDirectory + "/src/main/java/com/example/lichsu.json";
         try (FileWriter writer = new FileWriter(nameFile)) {
             gson.toJson(listLichSu, writer);
         }
         listLichSu.printLength();

//        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//         driver.get("http://127.0.0.1:5500/src/main/java/org/example/web/index.html");
    }
}
