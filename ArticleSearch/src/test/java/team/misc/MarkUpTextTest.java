package team.misc;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MarkUpTextTest {
	String text;
	ArrayList<String> mark = new ArrayList<>();
	String expected;
	String actual;

	@Before
	// before it runs each test, it'll do these things
	public void initialize() {
		text = null;
		mark.clear();
		expected = null;
		actual = null;
	}

	@Test
	public void textAndMarkNull() {
		actual = MarkUpText.markUp(text, mark);
		expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void textNull() {
		mark.add("mark");
		actual = MarkUpText.markUp(text, mark);
		expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void markNull() {
		text = "text";
		actual = MarkUpText.markUp(text, mark);
		expected = "text";
		assertEquals(expected, actual);
	}

	@Test
	public void markNoString() {
		mark.add("");
		text = "text";
		actual = MarkUpText.markUp(text, mark);
		expected = "text";
		assertEquals(expected, actual);
	}

	@Test
	public void oneWordMarkUp() {
		text = "text";
		mark.add("text");
		actual = MarkUpText.markUp(text, mark);
		expected = "<mark>text</mark>";
		assertEquals(expected, actual);
	}

	@Test
	public void stringMarkUp() {
		text = "this text is longer now";
		mark.add("text");
		actual = MarkUpText.markUp(text, mark);
		expected = "this <mark>text</mark> is longer now";
		assertEquals(expected, actual);
	}

	@Test
	public void multiWordMarkUp() {
		text = "this text is longer now";
		mark.add("text");
		mark.add("longer");
		actual = MarkUpText.markUp(text, mark);
		expected = "this <mark>text</mark> is <mark>longer</mark> now";
		assertEquals(expected, actual);
	}
	
	@Test
	public void wordsInsideWords() {
		text = "quest question";
		mark.add("quest");
		actual = MarkUpText.markUp(text, mark);
		expected = "<mark>quest</mark> question";
		assertEquals(expected, actual);
	}
	
	@Test
	public void hyphenatedWords() {
		text = "here's a-hyphen";
		mark.add("a-hyphen");
		actual = MarkUpText.markUp(text, mark);
		expected = "here's <mark>a-hyphen</mark>";
		assertEquals(expected, actual);
	}
	
	@Test
	public void caseConflict() {
		text = "CApital LEttERS";
		mark.add("capital");
		mark.add("letters");
		actual = MarkUpText.markUp(text, mark);
		expected = "<mark>CApital</mark> <mark>LEttERS</mark>";
		assertEquals(expected, actual);
	}

}