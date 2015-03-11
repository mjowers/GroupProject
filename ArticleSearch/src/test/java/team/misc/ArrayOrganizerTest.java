package team.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayOrganizerTest {
	ArrayList<String> expected = new ArrayList<>();
	ArrayList<String> actual = new ArrayList<>();

	@Test
	public void testForEmptyInEmptyOut() {
		ArrayList<String> empty = new ArrayList<>();
		actual = ArrayOrganizer.createArray(empty, null);
		assertEquals(expected, actual);
	}

	@Test
	public void testForOneLineInSingleArrayOut() {
		ArrayList<String> test = new ArrayList<>();
		test.add("\"one\", \"two\", \"three\"");
		expected.add("one"); // have to add it one at a time with ArrayList -
								// can't just initialize with =
		expected.add("two");
		expected.add("three");
		actual = ArrayOrganizer.createArray(test, " ,\"");
		assertEquals(expected, actual);
		// create a known sample and then see what comes back
	}
	
	@Test
	public void testForTwoLinesInSingleArrayOut() {
		ArrayList<String> test = new ArrayList<>();
		test.add("\"one\", \"two\", \"three\"");
		test.add("\"blue\", \"red\", \"stephen\"");
		expected.add("one"); // have to add it one at a time with ArrayList -
								// can't just initialize with =
		expected.add("two");
		expected.add("three");
		expected.add("blue");
		expected.add("red");
		expected.add("stephen");
		actual = ArrayOrganizer.createArray(test, " ,\"");
		assertEquals(expected, actual);
}
}
