package team.misc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ArticleSearch {

	public static void main(String[] args) throws IOException {
		String sep = File.separator;

		ArrayList<String> wordList = CustomWordListPrompter.prompt();
		ArrayList<String> urlList = CustomUrlPrompter.prompt();

		URLContentExtractor urlce = new URLContentExtractor();

		for (int i = 0; i < urlList.size(); i++) {
			ArrayList<String> textArray = new ArrayList<>();
			ArrayList<String> textWordsArray = new ArrayList<>();
			HashMap<String, Integer> articleContains = new HashMap<>();
			ArrayList<String> articleWords = new ArrayList<>();

			URL url = new URL(urlList.get(i));
			String text = urlce.read(url);

			Document doc = Jsoup.parse(text, "UTF-8");
			Elements elements = doc.select("p");
			for (Element element : elements) {
				textArray.add(element.text());
			}

			textWordsArray = ArrayOrganizer.createArray(textArray, ".?! ,()[]\"");
			articleContains = BinarySearcher.search(wordList, textWordsArray);

			Set<String> keySet = articleContains.keySet();
			articleWords.addAll(keySet);
			String markedText = MarkUpText.markUp(text, articleWords);

			String outPathString = System.getProperty("user.home") + sep
					+ "markeduparticle" + (i + 1) + ".htm";
			Path outPath = Paths.get(outPathString);

			HtmlOutput.htmlOut(markedText, outPath);
			
			ConsoleOutputResults.printArticleResults(i, articleContains);
		}
		ConsoleOutputResults.printOverallResults();
	}
}
