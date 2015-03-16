package team.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;
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

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		String sep = File.separator;
		String resPath = new File("").getAbsolutePath() + sep + "src" + sep
				+ "main" + sep + "resources";
		Path wordsPath = null;

		boolean ok = false;
		String f = null;
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));
		do {
			System.out
					.println("Please enter a file name, or return to access the default words.txt: ");
			f = bufferedReader.readLine();
			if (f.equals("")) {
				wordsPath = Paths.get(resPath + sep + Constants.WORDS_TXT);
				ok = true;
			} else if (new File(resPath + sep + f).exists()) {
				wordsPath = Paths.get(resPath + sep + f);
				ok = true;
			} else
				System.err.println("Doesn't exist or is not a file.");
		} while (!ok);

		ArrayList<String> urlList = new ArrayList<String>();
		do {
			System.out
					.println("Please enter a URL, or press enter to access the default urlslist.txt: ");
			
			f = bufferedReader.readLine();
			if (f.equals("")) {
				Path urlPath = Paths
						.get(resPath + sep + Constants.URLSLIST_TXT);
				FileReaderObject urls = new FileReaderObject(urlPath);
				urlList = urls.getRawText();
				ok = true;
			} else {
				try {
					URL url = new URL(f);
					urlList.add(f);
					ok = true;
				} catch (MalformedURLException mue) {
					ok = false;
					System.err.println("Bad URL.");
				}
			}
		} while (!ok);
		bufferedReader.close();
		// if statement - if empty, run those. otherwise set urlList equal to
		// input

		// if (args.length == 1) /*
		// * Do we want to allow for more than 1 document
		// * reference?
		// */
		// // do we want to save the file to the package? or does it already
		// have to be in the directory?
		// // add a guard clause in case there isn't a file in the directory
		// {
		// try {
		//
		// }
		// catch (InvalidPathException ipe) {
		// System.err.println("InvalidPathException: " + ipe.getMessage());
		// }

		// }

		FileReaderObject words = new FileReaderObject(wordsPath);
		ArrayList<String> wordList = words.sanitizeText(",\"");

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

			textWordsArray = ArrayOrganizer.createArray(textArray, ".?! ,()\"");

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
