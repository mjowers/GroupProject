package team.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLScrapper {
	// read url from array and extract html from each url
	public String read(URL url) throws IOException {
		BufferedReader in;
		in = new BufferedReader(new InputStreamReader(url.openStream()));

		String inputLine;
		String contents = "";
		while ((inputLine = in.readLine()) != null) {
			contents += inputLine + "\n";
		}
		in.close();

		return sanitize(contents);
	}

	// contents = url from file
	protected String sanitize(String contents) {

		StringBuilder builder = new StringBuilder();
		Document doc = Jsoup.parse(contents, "UTF-8");
		Elements elements = doc.select("p");
		// extract the paragraph text only
		for (Element element : elements) {
			String targetHtml = element.text();
			builder.append("<p>").append(targetHtml).append("</p>");
		}
		// Puts just the text you want into a string that can then be searched
		// and highlighted
		return builder.toString();
	}
}
