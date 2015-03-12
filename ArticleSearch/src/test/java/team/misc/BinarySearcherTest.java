package team.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class BinarySearcherTest {

	HashMap<String, Integer> actual = new HashMap<>();
	HashMap<String, Integer> expected = new HashMap<>();

	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
	}

	@Test
	public void testEmptyInEmptyOut() {
		ArrayList<String> empty = new ArrayList<>();
		actual = BinarySearcher.search(empty, empty); // returns empty HashMap
		HashMap<String, Integer> expected = new HashMap<>();
		assertEquals(expected, actual);
	}

	@Test
	public void testOneElementArray() {
		ArrayList<String> oneElement = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		oneElement.add("one");
		words.add("one");
		expected.put("one", 1); // word one found once
		actual = BinarySearcher.search(words, oneElement); // returns empty
															// HashMap
		assertEquals(expected, actual);
	}

	@Test
	public void testMultipleElementArray() {
		ArrayList<String> multipleElements = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		multipleElements.add("one");
		multipleElements.add("two");
		multipleElements.add("three");
		expected.put("one", 1); // word one found once
		expected.put("two", 1);
		expected.put("three", 1);
		words.add("one");
		words.add("two");
		words.add("three");
		actual = BinarySearcher.search(words, multipleElements); // returns
																	// empty
																	// HashMap
		assertEquals(expected, actual);
	}

	@Test
	public void testRepeatedElementsArray() {
		ArrayList<String> repeatElements = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		repeatElements.add("one");
		repeatElements.add("two");
		repeatElements.add("one");
		repeatElements.add("three");
		expected.put("one", 2); // word one found twice
		expected.put("two", 1);
		words.add("one");
		words.add("two");
		actual = BinarySearcher.search(words, repeatElements); // returns empty
																// HashMap
		assertEquals(expected, actual);
	}
}
