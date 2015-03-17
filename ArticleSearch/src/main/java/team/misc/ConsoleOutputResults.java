package team.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class ConsoleOutputResults {
	static int wordCount = 0;
	static HashMap<String, Integer> wordTotal = new HashMap<>();
	static MapValueSorter mvs = new MapValueSorter(wordTotal);
	static TreeMap<String, Integer> sortedWordTotal = new TreeMap<String, Integer>(
			mvs);

	public static void printArticleResults(int i,
			HashMap<String, Integer> articleContains) {
		wordCount = 0;
		Set<String> keySet = articleContains.keySet();
		System.out.println("Article " + (i + 1) + " contains...");
		for (String key : keySet) {
			System.out.println(key + " " + articleContains.get(key)
					+ " time(s).");
			wordCount += (int) articleContains.get(key);
		}
		System.out.println();
		wordTotal.put("Article " + (i + 1), wordCount);
	}

	public static void printOverallResults() {
		ArrayList<String> keySet = new ArrayList<String>();
		sortedWordTotal.putAll(wordTotal);
		keySet.addAll(sortedWordTotal.keySet());

		for (String key : keySet) {
			System.out.println(key + " contains " + wordTotal.get(key)
					+ " total matches from words list.");
		}
	}
}
