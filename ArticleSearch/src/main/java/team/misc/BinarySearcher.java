package team.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BinarySearcher {

	public static HashMap<String, Integer> search(ArrayList<String> wordArray,
			ArrayList<String> articleArray) {
		HashMap<String, Integer> articleContains = new HashMap<>();
		int frequency;
		for (String word : wordArray) {
			if (Collections.binarySearch(articleArray,word) > -1) {
				frequency=Collections.frequency(articleArray, word); //use collections for searching list. uses frequency method
				articleContains.put(word, frequency);
			}
		}
		return articleContains;
	}

}
// Binary searches need to be in alphabetical or numerical order
//Collections.sort(wordArray);
//Collections.sort(articleArray);