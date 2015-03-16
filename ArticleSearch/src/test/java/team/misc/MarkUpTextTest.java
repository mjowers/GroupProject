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
	String htmlStart = "<html><head></head><body><p>";
	String htmlEnd = "</p></body></html>";
	String markUpStart = "<html>\n <head></head>\n <body>\n  <p>";
	String markUpEnd = "</p>\n </body>\n</html>";

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
		text = htmlStart + "text" + htmlEnd;
		mark.add("text");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "<mark>text</mark>" + markUpEnd;
		assertEquals(expected, actual);
	}

	@Test
	public void stringMarkUp() {
		text = htmlStart + "this text is longer now" + htmlEnd;
		mark.add("text");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "this <mark>text</mark> is longer now" + markUpEnd;
		assertEquals(expected, actual);
	}

	@Test
	public void multiWordMarkUp() {
		text = htmlStart + "this text is longer now" + htmlEnd;
		mark.add("text");
		mark.add("longer");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "this <mark>text</mark> is <mark>longer</mark> now" + markUpEnd;
		assertEquals(expected, actual);
	}
	
	@Test
	public void wordsInsideWords() {
		text = htmlStart + "quest question" + htmlEnd;
		mark.add("quest");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "<mark>quest</mark> question" + markUpEnd;
		assertEquals(expected, actual);
	}
	
	@Test
	public void hyphenatedWords() {
		text = htmlStart + "here's a-hyphen" + htmlEnd;
		mark.add("a-hyphen");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "here's <mark>a-hyphen</mark>" + markUpEnd;
		assertEquals(expected, actual);
	}
	
	@Test
	public void caseConflict() {
		text = htmlStart + "CApital LEttERS" + htmlEnd;
		mark.add("capital");
		mark.add("letters");
		actual = MarkUpText.markUp(text, mark);
		expected = markUpStart + "<mark>CApital</mark> <mark>LEttERS</mark>" + markUpEnd;
		assertEquals(expected, actual);
	}

}