package com.example.scraper;

import com.example.model.ListLichSu;
import com.example.model.SuKien;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ScraperSuKien {
    public static void scraperSukien(ListLichSu listLichSu) throws IOException {

        System.setProperty("webdriver.chrome.driver", LinkScraper.linkChrome);
        // System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get(LinkScraper.linkSuKien);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Thời_tiền_sử")));
        String html = driver.getPageSource();
        driver.quit();
        Document document = Jsoup.parse(html);

        Elements elements = document.select(".mw-parser-output > p:nth-of-type(n+2), dl");
        for (Element element : elements) {
            String ngaySuKien = "";
            String tenSukien = "";
            if (element.tagName().equals("dl")) {
                for (Element dd : element.select("dd")) {
                    String bText = dd.select("b").text();
                    ngaySuKien += bText + " năm " + element.previousElementSibling().text();
                    tenSukien += dd.text().replace(bText, "");
                    SuKien suKien = new SuKien(tenSukien, ngaySuKien);

                    Elements a = dd.select("a");
                    for (Element aHref : a) {
                        String linkVua = LinkScraper.linkWeb + "/vi/" + aHref.attr("title").replace(" ", "_");
                        if (MapClass.mapVua.get(linkVua) != null) {
                            suKien.addVua(MapClass.mapVua.get(linkVua));
                        }
                    }
                    listLichSu.addGeneral(suKien);
                    ngaySuKien = "";
                    tenSukien = "";
                }
            } else {

                String bText = element.select("b").text();
                ngaySuKien += bText;
                tenSukien += element.text().replace(bText, "");
                if (tenSukien.isEmpty())
                    continue;
                SuKien suKien = new SuKien(tenSukien, ngaySuKien);

                Elements a = element.select("a");
                for (Element aHref : a) {
                    String linkVua = LinkScraper.linkWeb + "/vi/" + aHref.attr("title").replace(" ", "_");
                    if (MapClass.mapVua.get(linkVua) != null) {
                        suKien.addVua(MapClass.mapVua.get(linkVua));
                    }
                }
                listLichSu.addGeneral(suKien);
            }

        }

    }

}