package team.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

public class BinarySearcherTest {

	@Test
	public void testEmptyInEmptyOut() {
		ArrayList<String> empty = new ArrayList <>();
		HashMap <String, Integer> actual;
		actual = BinarySearcher.search(empty,empty); //returns empty HashMap
		HashMap<String, Integer> expected = new HashMap<>();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testOneElementArray(){
		ArrayList<String> oneElement = new ArrayList <>();
		oneElement.add("one");
		HashMap <String, Integer> actual;
		HashMap<String, Integer> expected = new HashMap<>();
		expected.put("one", 1); //word one found once
		ArrayList<String> words = new ArrayList <>();
		words.add("one");
		actual = BinarySearcher.search(words, oneElement); //returns empty HashMap
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultipleElementArray() {
		ArrayList<String> multipleElements = new ArrayList <>();
		multipleElements.add("one");
		multipleElements.add("two");
		multipleElements.add("three");
		HashMap <String, Integer> actual;
		HashMap<String, Integer> expected = new HashMap<>();
		expected.put("one", 1); //word one found once
		expected.put("two", 1);
		expected.put("three", 1);
		ArrayList<String> words = new ArrayList <>();
		words.add("one");
		words.add("two");
		words.add("three");
		Collections.sort(words);
		Collections.sort(multipleElements);
		actual = BinarySearcher.search(words, multipleElements); //returns empty HashMap
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRepeatElementArray() {
		ArrayList<String> repeatElements = new ArrayList <>();
		repeatElements.add("one");
		repeatElements.add("two");
		repeatElements.add("one");
		repeatElements.add("three");
		HashMap <String, Integer> actual;
		HashMap<String, Integer> expected = new HashMap<>();
		expected.put("one", 2); //word one found twice
		expected.put("two", 1);
		ArrayList<String> words = new ArrayList <>();
		words.add("one");
		words.add("two");
		Collections.sort(words);
		Collections.sort(repeatElements);
		actual = BinarySearcher.search(words, repeatElements); //returns empty HashMap
		assertEquals(expected, actual);
	}
}
