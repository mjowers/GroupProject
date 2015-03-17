package team.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CustomUrlPrompter {
	static String sep = File.separator;
	static String resPath = new File("").getAbsolutePath() + sep + "src" + sep
			+ "main" + sep + "resources";

	public static ArrayList<String> prompt() throws IOException {
		ArrayList<String> urlList = new ArrayList<String>();
		boolean ok = false;
		String urlString = null;
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(
				System.in));

		do {
			System.out
					.println("Please enter a URL, or press enter to access the default urlslist.txt: ");

			urlString = urlReader.readLine();
			if (urlString.equals("")) {
				Path urlPath = Paths
						.get(resPath + sep + Constants.URLSLIST_TXT);
				FileReaderObject urls = new FileReaderObject(urlPath);
				urlList = urls.getRawText();
				ok = true;
			} else {
				try {
					new URL(urlString);
					urlList.add(urlString);
					ok = true;
				} catch (MalformedURLException mue) {
					System.err.println("Bad URL.");
					ok = false;
				}
			}
		} while (!ok);

		urlReader.close();
		return urlList;
	}
}