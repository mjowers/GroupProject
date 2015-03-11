package team.misc;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class TextReaderTest {
	ArrayList<String> testControl = new ArrayList<String>();
	ArrayList<String> testDummy = new ArrayList<String>();

	@Test
	public void testChecksNoFile() {
		Path fileDummy = FileSystems.getDefault().getPath("nofile.txt"); 
		testDummy = TextReader.readFile(fileDummy);
		assertEquals(testControl, testDummy);
	}

	@Test
	public void testChecksReading() {
		Path fileDummy = FileSystems.getDefault().getPath("dummy.txt"); 
		testDummy = TextReader.readFile(fileDummy);
		testControl.add("This is");
		testControl.add("a test");
		assertEquals(testControl, testDummy);
	}
}

// first test - see if there's a file to read, and test that it actually throws
// If ArrayList empty
// see if there's text to read
//
