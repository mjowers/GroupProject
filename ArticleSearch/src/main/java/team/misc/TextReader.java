package team.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class TextReader {
	public static ArrayList<String> readFile (Path filePath) {
		ArrayList<String> textFromFile = new ArrayList<String> ();
		try {
<<<<<<< Updated upstream
			BufferedReader reader = Files.newBufferedReader(filePath,StandardCharsets.UTF_8);
=======
			BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
>>>>>>> Stashed changes
			String lines;
			while ((lines = reader.readLine()) != null) {
				textFromFile.add(lines);
			}
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		System.out.println(textFromFile);
		return textFromFile;
	}
}

//read text from file and return it