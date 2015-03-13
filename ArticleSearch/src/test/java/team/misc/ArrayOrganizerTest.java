package team.misc;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ArrayOrganizerTest {
	ArrayList<String> expected = new ArrayList<>();
	ArrayList<String> actual = new ArrayList<>();

	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
	}

	@Test
	public void emptyInEmptyOut() {
		ArrayList<String> empty = new ArrayList<>();
		actual = ArrayOrganizer.createArray(empty, " ");
		assertEquals(expected, actual);
	}
	
	@Test
	public void nullDelimiters() {
		ArrayList<String> test = new ArrayList<>();
		test.add("one");
		test.add("two");
		expected.add("one");
		expected.add("two");
		actual = ArrayOrganizer.createArray(test, null);
		assertEquals(expected, actual);
	}

	@Test
	public void oneLineIn() {
		ArrayList<String> test = new ArrayList<>();
		test.add("\"one\", \"two\", \"three\"");
		expected.add("one");
		expected.add("two");
		expected.add("three");
		actual = ArrayOrganizer.createArray(test, " ,\"");
		assertEquals(expected, actual);
	}

	@Test
	public void twoLinesIn() {
		ArrayList<String> test = new ArrayList<>();
		test.add("\"one\", \"two\", \"three\"");
		test.add("\"blue\", \"red\", \"green\"");
		expected.add("one");
		expected.add("two");
		expected.add("three");
		expected.add("blue");
		expected.add("red");
		expected.add("green");
		actual = ArrayOrganizer.createArray(test, " ,\"");
		assertEquals(expected, actual);
	}
}
