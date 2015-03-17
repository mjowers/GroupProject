package team.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CustomWordListPrompter {
	static String sep = File.separator;
	static String resPath = new File("").getAbsolutePath() + sep + "src" + sep
			+ "main" + sep + "resources";
	static Path wordsPath = null;

	public static ArrayList<String> prompt() throws IOException {
		String userWordInput = null;
		BufferedReader wordsReader = new BufferedReader(new InputStreamReader(
				System.in));
		FileReaderObject words;
		ArrayList<String> wordList = new ArrayList<>();

		System.out
				.println("Please enter a file name, words separated by spaces, or press enter to access the default words.txt: ");
		userWordInput = wordsReader.readLine();
		if (userWordInput.equals("")) {
			wordsPath = Paths.get(resPath + sep + Constants.WORDS_TXT);
			words = new FileReaderObject(wordsPath);
			wordList = words.sanitizeText(" ,\"");
		} else if (new File(userWordInput).exists()) {
			wordsPath = Paths.get(userWordInput);
			words = new FileReaderObject(wordsPath);
			wordList = words.sanitizeText(" ,\"");
		} else {
			ArrayList<String> inputWords = new ArrayList<>();
			inputWords.add(userWordInput.toString());
			wordList = ArrayOrganizer.createArray(inputWords, " ,\"");
		}

		return wordList;
	}
}