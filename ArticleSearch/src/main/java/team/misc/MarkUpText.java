package team.misc;

import java.util.ArrayList;

public class MarkUpText {

	public static String markUp(String text, ArrayList<String> words) {
		if (text == null || words.size() < 1 || text == "") {
			return text;
		} else if (words.size() == 1 && words.get(0) == "") {
			return text;
		}
		for (String word : words) {
			text = text.replaceAll("\\b" + word + "\\b", "<mark>" + word + "</mark>");

		}
		return text;
	}
}
