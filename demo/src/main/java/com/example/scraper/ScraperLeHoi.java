package com.example.scraper;

import com.example.model.ListLichSu;
import com.example.model.LeHoi;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScraperLeHoi {
    public static void scraperLeHoi(ListLichSu listLichSu) throws IOException {
        System.setProperty("webdriver.chrome.driver", LinkScraper.linkChrome);
        // System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get(LinkScraper.linkLeHoi);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Danh_sách_một_số_lễ_hội")));
        String html = driver.getPageSource();
        driver.quit();

        Document document = Jsoup.parse(html);
        Elements elements = document.select("#Danh_sách_một_số_lễ_hội tbody > tr:nth-of-type(n+2)");

        String ngaytochuc = "";
        for (Element element : elements) {
            if (!element.hasText())
                continue;
            ngaytochuc = element.select("td").get(0).text();
            String ten = element.select("td").get(2).text();
            String diadiem = element.select("td").get(1).text();

            LeHoi leHoi = new LeHoi(ten, diadiem, ngaytochuc);

            if (element.select("td").get(2).select("a").hasText()) {
                try {
                    String linkLeHoi = LinkScraper.linkWeb
                            + element.select("td").get(2).select("a").first().attr("href");
                    Document doc = Jsoup.connect(linkLeHoi).timeout(5000).get();
                    Elements elements1 = doc.select("article > span a");
                    for (Element element1 : elements1) {
                        String linkVua = LinkScraper.linkWeb + element1.attr("href");
                        String linkDiTich = LinkScraper.linkWeb + element1.attr("href");

                        if (MapClass.mapVua.get(linkVua) != null)
                            leHoi.addVua(MapClass.mapVua.get(linkVua));
                        if (MapClass.mapDiTich.get(linkDiTich) != null) {
                            leHoi.addDiTich(MapClass.mapDiTich.get(linkDiTich));
                        }
                        if (MapClass.mapDiTich.get(linkLeHoi) != null) {
                            leHoi.addDiTich(MapClass.mapDiTich.get(linkLeHoi));
                        }
                    }
                } catch (Exception e) {

                }
            }
            listLichSu.addGeneral(leHoi);
        }
    }

}
