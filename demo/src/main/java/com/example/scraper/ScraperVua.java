package com.example.scraper;

import com.example.model.ListLichSu;
import com.example.model.Vua;
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

public class ScraperVua {
    public static void scraperVua(ListLichSu listLichSu) throws IOException {
//         scrap vua

        Document document = Jsoup.connect(LinkScraper.linkVua).timeout(5000).get();
        Elements elements = document.select("td div span a");

            for (Element ele : elements) {
                try {
                String linkVua = LinkScraper.linkWeb + ele.attr("href");
                String name = ele.text();

                Document doc1 = Jsoup.connect(linkVua).timeout(5000).get();
                String ngaysinh = doc1.select("th:contains(Sinh) + td").hasText() ? doc1.select("th:contains(Sinh) + td").text() : "?";


                String ngaymat = doc1.select("th:contains(Mất) + td").hasText() ? doc1.select("th:contains(Mất) + td").text() : "?";
                String ngaylenngoi = doc1.select("th:contains(Trị vì) + td").hasText() ? doc1.select("th:contains(Trị vì) + td").text() : "?";
                String cha = doc1.select("th:contains(Thân phụ) +td").text();
                Vua vua = new Vua(name, ngaysinh, ngaymat, ngaylenngoi, cha);
                listLichSu.addGeneral(vua);
                System.out.println(vua.getTen());
                MapClass.setMap(linkVua, vua);
                } catch (Exception e) {

                }

            }


            // scrap anh hùng dân tộc
            System.setProperty("webdriver.chrome.driver", LinkScraper.linkChrome);
            // System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");

            WebDriver driver = new ChromeDriver(chromeOptions);
            WebDriverWait wait = new WebDriverWait(driver, 60);
            driver.get(LinkScraper.linkAnhHungDanToc);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Đặc_điểm")));
            String html = driver.getPageSource();
            driver.quit();
            Document document2 = Jsoup.parse(html);

            Element olElement = document2.select("ol").first();
            Elements elements2 = olElement.select("li");
            for (Element element : elements2) {
                try {
                String linkAnhHung = LinkScraper.linkWeb + "/vi/" + element.select("a").first().attr("title").replaceAll(" ", "_");
                if (MapClass.mapVua.get(linkAnhHung) != null) continue;
                String name = element.select("a").first().attr("title");
                Document doc1 = Jsoup.connect(linkAnhHung).timeout(5000).get();
                String ngaysinh = doc1.select("th:contains(Sinh) + td").hasText() ? doc1.select("th:contains(Sinh) + td").text() : "?";


                String ngaymat = doc1.select("th:contains(Mất) + td").hasText() ? doc1.select("th:contains(Mất) + td").text() : "?";
                String ngaylenngoi = doc1.select("th:contains(Trị vì) + td").hasText() ? doc1.select("th:contains(Trị vì) + td").text() : "?";
                String cha = doc1.select("th:contains(Thân phụ) +td").text();
                Vua vua = new Vua(name, ngaysinh, ngaymat, ngaylenngoi, cha);
                listLichSu.addGeneral(vua);
                MapClass.setMap(linkAnhHung, vua);


                } catch (Exception e) {

                }
        }
    }

}
