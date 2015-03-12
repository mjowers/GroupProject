package team.misc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayOrganizerTest {
	ArrayList<String> expected = new ArrayList<>();
	ArrayList<String> actual = new ArrayList<>();

	
	// Tests for ArrayList<String> version
	@Test
	public void testForEmptyInEmptyOut() {
		ArrayList<String> empty = new ArrayList<>();
		actual = ArrayOrganizer.createArrayFromArrayList(empty, null);
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
		actual = ArrayOrganizer.createArrayFromArrayList(test, " ,\"");
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
		actual = ArrayOrganizer.createArrayFromArrayList(test, " ,\"");
		assertEquals(expected, actual);
}
	
	// Tests for String Version
	@Test
	public void testStringVersionForEmptyInEmptyOut() {
		String empty = new String();
		actual = ArrayOrganizer.createArrayFromString(empty, null);
		assertEquals(expected, actual);
	}

	@Test
	public void testStringVersionForOneLineInSingleArrayOut() {
		String test = new String("one two three blue red stephen");
		expected.add("one"); 
		expected.add("two");
		expected.add("three");
		expected.add("blue");
		expected.add("red");
		expected.add("stephen");
		actual = ArrayOrganizer.createArrayFromString(test, " ");
		assertEquals(expected, actual);
	}
}
