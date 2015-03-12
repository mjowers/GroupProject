package team.misc;

import java.nio.file.Path;
import java.util.ArrayList;

public class FileReaderObject {
	Path filePath;
	ArrayList<String> rawText = new ArrayList<>();
	ArrayList<String> sanitizedText = new ArrayList<>();

	public FileReaderObject(Path filePath) {
		this.filePath = filePath;
		rawText = TextReader.readFile(filePath);
	}
	
	public ArrayList<String> getRawText() {
		return rawText;
	}
	
	public ArrayList<String> sanitizeText(String delims) {
		sanitizedText = ArrayOrganizer.createArray(rawText, delims);
		return sanitizedText;
	}
}