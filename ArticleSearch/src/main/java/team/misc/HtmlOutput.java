package team.misc;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlOutput {
	
	public static void htmlOut(String html, Path fileOut) {
		try {
			BufferedWriter htmlOut = Files.newBufferedWriter(fileOut);
			htmlOut.write(html);
			htmlOut.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
