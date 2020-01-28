import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TestScrapper {
    public static void main(String[] args) throws IOException {
        final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
        final String query = "geles";
        final Document page = Jsoup.connect("https://www.google.lt/search?q=" + URLEncoder.encode(query,"UTF-8")).userAgent(USER_AGENT).get();
        final PrintWriter out = new PrintWriter("geles.txt");
        for (Element searchResult:
             page.select("div > div:nth-child(1) > a")) {
                final String title = searchResult.text();
                final String url = searchResult.attr("href");
            out.write(title + "-->" + url + "\n");

          /*      // Print values of title + url
            System.out.println(title + " --> " + url);*/

        }
        out.close();

    }
}
