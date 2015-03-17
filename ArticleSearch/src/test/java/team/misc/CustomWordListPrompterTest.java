package team.misc;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CustomWordListPrompterTest {
	static String sep = File.separator;
	static String resPath = new File("").getAbsolutePath() + sep + "src" + sep
			+ "main" + sep + "resources";
	static String testPath = new File("").getAbsolutePath() + sep + "src" + sep
			+ "test" + sep + "resources";
	static ArrayList<String> expected = new ArrayList<>();
	static ArrayList<String> actual = new ArrayList<>();
	static ByteArrayInputStream input;
	FileReaderObject words;

	@Before
	public void initialize() {
		expected.clear();
		actual.clear();
	}

	@Test
	public void useDefaultWords() throws IOException {
		input = new ByteArrayInputStream("\n".getBytes());
		System.setIn(input);
		actual = CustomWordListPrompter.prompt();
		words = new FileReaderObject(Paths.get(resPath + sep + "words.txt"));
		expected = words.sanitizeText(" ,\"");
		assertEquals(expected, actual);
	}

	@Test
	public void useCustomFile() throws IOException {
		input = new ByteArrayInputStream(
				(testPath + sep + "customwords.txt").getBytes());
		System.setIn(input);
		actual = CustomWordListPrompter.prompt();
		words = new FileReaderObject(Paths.get(testPath + sep
				+ "customwords.txt"));
		expected = words.sanitizeText(" ,\"");
		assertEquals(expected, actual);
	}

	@Test
	public void useInputWords() throws IOException {
		input = new ByteArrayInputStream(
				("custom   words,\"input\"").getBytes());
		System.setIn(input);
		actual = CustomWordListPrompter.prompt();
		expected.add("custom");
		expected.add("words");
		expected.add("input");
		assertEquals(expected, actual);
	}

	@Test
	public void constructorTest() throws IOException {
		new CustomWordListPrompter();
	}
}
