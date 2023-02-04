package com.example.scraper;

import com.example.model.ListLichSu;
import com.example.model.TrieuDai;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ScraperTrieuDai {
    public static void scraperTrieuDai(ListLichSu listLichSu) throws IOException {
        Document document = Jsoup.connect(LinkScraper.linkTrieuDai).timeout(5000).get();
        Elements elements = document.select("tr");
        for (Element element : elements) {
            if (!element.select("th > a").hasText())
                continue;
            String name = element.select("th > a").text();
            Elements vuas = element.select("td > div > span a");
            TrieuDai trieuDai = new TrieuDai(name);
            for (Element a : vuas) {
                try {
                    String linkVua = LinkScraper.linkWeb + a.attr("href");
                    trieuDai.addVua(MapClass.mapVua.get(linkVua));
                } catch (Exception e) {
                }
            }
            listLichSu.addGeneral(trieuDai);
        }
    }
}
