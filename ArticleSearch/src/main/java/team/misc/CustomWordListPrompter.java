package team.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomWordListPrompter {
	static String sep = File.separator;
	static String resPath = new File("").getAbsolutePath() + sep + "src" + sep
			+ "main" + sep + "resources";
	static Path wordsPath = null;

	public static Path prompt() throws IOException {
		boolean ok = false;
		String filePath = null;
		BufferedReader wordsReader = new BufferedReader(new InputStreamReader(
				System.in));

		do {
			System.out
					.println("Please enter a file name, or press enter to access the default words.txt: ");
			filePath = wordsReader.readLine();
			if (filePath.equals("")) {
				wordsPath = Paths.get(resPath + sep + Constants.WORDS_TXT);
				ok = true;
			} else if (new File(filePath).exists()) {
				wordsPath = Paths.get(filePath);
				ok = true;
			} else
				System.err.println("Doesn't exist or is not a file.");
		} while (!ok);

		return wordsPath;
	}
}