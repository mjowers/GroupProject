package team.misc;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TextReaderTest {
	ArrayList<String> actual = new ArrayList<String>();
	ArrayList<String> expected = new ArrayList<String>();
	String sep = File.separator;
	String path = new File("").getAbsolutePath() + sep + "src" + sep + "test"
			+ sep + "resources";

	@Before
	public void initialize() {
		expected.clear();
		actual.clear();
	}

	@Test
	public void testChecksNoFile() {
		Path noFile = Paths.get(path + sep + "nofile.txt");
		actual = TextReader.readFile(noFile);
		assertEquals(expected, actual);
	}

	@Test
	public void testChecksReading() {
		Path dummyPath = Paths.get(path + sep + "dummy.txt");
		actual = TextReader.readFile(dummyPath);
		expected.add("This is");
		expected.add("a test.");
		assertEquals(expected, actual);
	}

	@Test
	public void constructorTest() {
		new TextReader();
	}
}