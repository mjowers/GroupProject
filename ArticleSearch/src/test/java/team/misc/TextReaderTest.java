package team.misc;

import static org.junit.Assert.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TextReaderTest {
	ArrayList<String> actual = new ArrayList<String>();
	ArrayList<String> expected = new ArrayList<String>();

	@Before
	public void initialize() {
		expected.clear();
		actual.clear();
	}
	
	@Test
	public void testChecksNoFile() {
		Path fileDummy = FileSystems.getDefault().getPath("nofile.txt"); 
		actual = TextReader.readFile(fileDummy);
		assertEquals(expected, actual);
	}

	@Test
	public void testChecksReading() {
		Path fileDummy = FileSystems.getDefault().getPath("dummy.txt"); 
		actual = TextReader.readFile(fileDummy);
		expected.add("This is");
		expected.add("a test.");
		assertEquals(expected, actual);
	}
}