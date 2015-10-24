package org.sumanta;


 
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class jSoup {
 
	public static void main(String[] args) {

		TextToVoice ttv = new TextToVoice();

		Document doc;
		try {

			// need http protocol
			doc = Jsoup.connect(
					"http://en.wikipedia.org/wiki/Subhas_Chandra_Bose").get();

			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				// get the value from href attribute
				// System.out.println("\nlink : " + link.attr("href"));
				// System.out.println("text : " + link.text());
			}

			Elements ln = doc.select("p");
			for (Element link : ln) {
				if (link.hasText()) {
					System.out.println(" " + link.text());
					ttv.sayIt(link.text());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
 
}