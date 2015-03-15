package team.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLContentExtractor {
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

		return contents;
	}

	
}
