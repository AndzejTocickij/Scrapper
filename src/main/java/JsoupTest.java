import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupTest {
    public static void main(String[] args) throws IOException {


        // Downloads the html from URL and parses it
        final Document doc = Jsoup.connect("https://www.google.lt/search?q=apple").get();

        // Selects a bunch CSS tags
        final Elements newsHeadLines = doc.select("h3.r a");

        // Prints to console
        for (Element headline :
                newsHeadLines) {
            System.out.println(headline.text());
        }

        System.out.println("\n\n--------------------------------------------------------\n\n");
        System.out.println(doc.outerHtml());

    }

}
