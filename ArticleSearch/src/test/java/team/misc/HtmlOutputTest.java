package team.misc;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HtmlOutputTest {
	ArrayList<String> actual = new ArrayList<>();
	ArrayList<String> expected = new ArrayList<>();
	String sep = File.separator;
	String path = new File("").getAbsolutePath();

	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
	}

	@Test
	public void emptyInEmptyOut() {
		String pathInString = path + sep + "test1control.htm";
		String pathOutString = path + sep + "test1.htm";
		Path pathIn = Paths.get(pathInString);
		Path pathOut = Paths.get(pathOutString);

		HtmlOutput.htmlOut("", pathOut);
		expected = TextReader.readFile(pathIn);
		actual = TextReader.readFile(pathOut);
		assertEquals(expected, actual);
	}

	@Test
	public void testSingleLine() {
		String pathInString = path + sep + "test2control.htm";
		String pathOutString = path + sep + "test2.htm";
		Path pathIn = Paths.get(pathInString);
		Path pathOut = Paths.get(pathOutString);

		HtmlOutput.htmlOut("ayy lmao", pathOut);
		expected = TextReader.readFile(pathIn);
		actual = TextReader.readFile(pathOut);
		assertEquals(expected, actual);
	}

	@Test
	public void testMultiline() {
		String pathInString = path + sep + "test3control.htm";
		String pathOutString = path + sep + "test3.htm";
		Path pathIn = Paths.get(pathInString);
		Path pathOut = Paths.get(pathOutString);
		HtmlOutput.htmlOut("<html>\rtest\r</html>", pathOut);
		expected = TextReader.readFile(pathIn);
		actual = TextReader.readFile(pathOut);
		assertEquals(expected, actual);
	}
}
