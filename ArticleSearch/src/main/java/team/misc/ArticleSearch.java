package team.misc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArticleSearch {
	public static void main(String[] args) throws IOException {
		String sep = File.separator;
		String resPath = new File("").getAbsolutePath() + sep + "src" + sep
				+ "main" + sep + "resources";

		Path wordsPath = Paths.get(resPath + sep + "words.txt");
		FileReaderObject words = new FileReaderObject(wordsPath);

		Path urlPath = Paths.get(resPath + sep + "urlslist.txt");
		FileReaderObject urls = new FileReaderObject(urlPath);

		ArrayList<String> wordList = words.sanitizeText(",\"");
		ArrayList<String> urlList = urls.getRawText();

		URLContentExtractor urlce = new URLContentExtractor();
		
		for (int i = 0; i < urlList.size(); i++) {
			ArrayList<String> textArray = new ArrayList<>();
			ArrayList<String> textWordsArray = new ArrayList<>();
			HashMap<String, Integer> articleContains = new HashMap<>();
			ArrayList<String> articleWords = new ArrayList<>();


			URL url = new URL(urlList.get(i));
			String text = urlce.read(url);
			textArray.add(text);

			textWordsArray = ArrayOrganizer.createArray(textArray,
					".?! ,()\"");

			articleContains = BinarySearcher.search(wordList, textWordsArray);

			Set<String> keySet = articleContains.keySet();
			System.out.println("Article " + (i + 1) + " contains...");
			for (String key : keySet) {
				System.out.println(key + " " + articleContains.get(key)
						+ " time(s).");
			}
			System.out.println();

			articleWords.addAll(keySet);

			String markedText = MarkUpText.markUp(text, articleWords);

			String outPathString = System.getProperty("user.home") + sep
					+ "markeduparticle" + (i + 1) + ".htm";
			Path outPath = Paths.get(outPathString);

			HtmlOutput.htmlOut(markedText, outPath);
		}
	}
}
