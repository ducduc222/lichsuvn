package com.example.scraper;

import com.example.model.ListLichSu;
import com.example.model.DiTich;
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

public class ScraperDiTich {
    public static void scraperDiTich(ListLichSu listLichSu) throws IOException {
        System.setProperty("webdriver.chrome.driver", LinkScraper.linkChrome);
        // System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.get(LinkScraper.linkDiTich);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Lai_Châu")));
        String html = driver.getPageSource();
        driver.quit();
        Document document = Jsoup.parse(html);

        Elements elements = document.select("tbody > tr:nth-of-type(n+2)");
        for (Element element : elements) {
            Elements elements1 = element.select("td");
            if (elements1.hasText())
                if (elements1.get(2).text().contains("Lịch sử")) {
                    String ten = elements1.get(0).text();
                    String diadiem = elements1.get(1).text();
                    String loaiditich = elements1.get(2).text();
                    String namcongnhan = elements1.get(3).text();

                    DiTich diTich = new DiTich(ten, diadiem, loaiditich, namcongnhan);
                    listLichSu.addGeneral(diTich);
                    if (elements1.get(0).select("a").hasText()) {
                        String linkDiTich = LinkScraper.linkWeb + elements1.get(0).select("a").first().attr("href");
                        MapClass.setMap(linkDiTich, diTich);
                    }

                }
        }
    }

}
