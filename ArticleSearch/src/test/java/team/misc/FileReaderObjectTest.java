package team.misc;

import static org.junit.Assert.*;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FileReaderObjectTest {

	ArrayList<String> actual = new ArrayList<>();
	ArrayList<String> expected = new ArrayList<>();
	Path fileDummy = FileSystems.getDefault().getPath("dummy.txt");
	FileReaderObject dummyObject = new FileReaderObject(fileDummy);
	
	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
	}

	@Test
	public void dummyFileRawText() {
		actual = dummyObject.getRawText();
		expected.add("This is");
		expected.add("a test.");
		assertEquals(expected, actual);
	}

	@Test
	public void dummyFileTextSanitizer() {
		actual = dummyObject.sanitizeText(" .\r");
		expected.add("This");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		assertEquals(expected, actual);
	}

}
