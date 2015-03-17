package team.misc;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MarkUpText {

	public static String markUp(String text, ArrayList<String> words) {
		if (text == null || words.size() < 1 || text.equals("")) {
			return text;
		} else if (words.size() == 1 && words.get(0).equals("")) {
			return text;
		}
		Document doc = Jsoup.parse(text, "UTF-8");
		Elements elements = doc.select("p");

		for (Element element : elements) {
			String paragraphText = element.text();
			for (String word : words) {
				paragraphText = paragraphText.replaceAll("\\b(?i)(" + word
						+ ")\\b", "<mark>$1</mark>");
				element.html(paragraphText);
			}
		}
		return doc.html();
	}
}