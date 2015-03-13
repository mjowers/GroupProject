package team.misc;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FileReaderObjectTest {

	ArrayList<String> actual = new ArrayList<>();
	ArrayList<String> expected = new ArrayList<>();
	String sep = File.separator;
	String path = new File("").getAbsolutePath() + sep + "src" + sep + "test";
	Path dummyPath = Paths.get(path + sep + "dummy.txt");
	FileReaderObject dummyObject = new FileReaderObject(dummyPath);
	Path noFilePath = Paths.get(path + sep + "nofile.txt");
	FileReaderObject noObject = new FileReaderObject(noFilePath);
	
	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
	}

	@Test
	public void noFileNoRawText() {
		actual = noObject.getRawText();
		assertEquals(expected, actual);
	}
	
	@Test
	public void noFileNoSanitizedText() {
		actual = noObject.sanitizeText(" ");
		assertEquals(expected, actual);
	}
	
	@Test
	public void dummyFileRawText() {
		actual = dummyObject.getRawText();
		expected.add("This is");
		expected.add("a test.");
		assertEquals(expected, actual);
	}

	@Test
	public void dummyFileNoDelimiters() {
		actual = dummyObject.sanitizeText(null);
		expected.add("This is");
		expected.add("a test.");
		assertEquals(expected, actual);
	}
	
	@Test
	public void dummyFileSanitizedText() {
		actual = dummyObject.sanitizeText(" .\r");
		expected.add("This");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		assertEquals(expected, actual);
	}

}
