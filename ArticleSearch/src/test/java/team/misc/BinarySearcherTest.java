package team.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class BinarySearcherTest {

	HashMap<String, Integer> actual = new HashMap<>();
	HashMap<String, Integer> expected = new HashMap<>();
	ArrayList<String> words = new ArrayList<>();

	@Before
	public void initialize() {
		actual.clear();
		expected.clear();
		words.clear();
	}

	@Test
	public void emptyArraysToSearchAndSearchFrom() {
		ArrayList<String> empty = new ArrayList<>();
		actual = BinarySearcher.search(empty, empty);
		assertEquals(expected, actual);
	}

	@Test
	public void emptyArrayToSearch() {
		ArrayList<String> empty = new ArrayList<>();
		words.add("alpha");
		actual = BinarySearcher.search(words, empty);
		assertEquals(expected, actual);
	}

	@Test
	public void emptyArrayToSearchFrom() {
		ArrayList<String> array = new ArrayList<>();
		array.add("alpha");
		actual = BinarySearcher.search(words, array);
		assertEquals(expected, actual);
	}

	@Test
	public void singleElementArray() {
		ArrayList<String> oneElement = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		oneElement.add("alpha");
		words.add("alpha");
		expected.put("alpha", 1);
		actual = BinarySearcher.search(words, oneElement);
		assertEquals(expected, actual);
	}
	
	@Test
	public void caseConflict() {
		ArrayList<String> capitalizeElement = new ArrayList<>();
		ArrayList<String> words = new ArrayList<>();
		capitalizeElement.add("ALPHA");
		capitalizeElement.add("beta");
		words.add("alpha");
		expected.put("ALPHA", 1);
		actual = BinarySearcher.search(words, capitalizeElement);
		assertEquals(expected, actual);
	}

	@Test
	public void multipleElementArray() {
		ArrayList<String> multipleElements = new ArrayList<>();
		multipleElements.add("alpha");
		multipleElements.add("beta");
		multipleElements.add("gamma");
		expected.put("alpha", 1);
		expected.put("beta", 1);
		expected.put("gamma", 1);
		words.add("alpha");
		words.add("beta");
		words.add("gamma");
		actual = BinarySearcher.search(words, multipleElements);
		assertEquals(expected, actual);
	}

	@Test
	public void repeatedElementsArray() {
		ArrayList<String> repeatElements = new ArrayList<>();
		repeatElements.add("alpha");
		repeatElements.add("alpha");
		repeatElements.add("beta");
		repeatElements.add("gamma");
		expected.put("alpha", 2);
		expected.put("beta", 1);
		words.add("alpha");
		words.add("beta");
		actual = BinarySearcher.search(words, repeatElements);
		assertEquals(expected, actual);
	}

	@Test
	public void initallyUnsortedArray() {
		ArrayList<String> unsortedElements = new ArrayList<>();
		unsortedElements.add("zeta");
		unsortedElements.add("alpha");
		unsortedElements.add("beta");
		unsortedElements.add("alpha");
		expected.put("alpha", 2); // word one found twice
		expected.put("zeta", 1);
		words.add("alpha");
		words.add("zeta");
		actual = BinarySearcher.search(words, unsortedElements);
		assertEquals(expected, actual);
	}
	
	@Test
	public void constructorTest() {
		BinarySearcher bs = new BinarySearcher();
	}
}
