package team.misc;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.Test;

public class URLContentExtractorTest extends TestCase {
	static final String TEST_HTML_EXAMPLECOM = "<!doctype html>\n" + 
			"<html>\n" + 
			"<head>\n" + 
			"    <title>Example Domain</title>\n" + 
			"\n" + 
			"    <meta charset=\"utf-8\" />\n" + 
			"    <meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />\n" + 
			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" + 
			"    <style type=\"text/css\">\n" + 
			"    body {\n" + 
			"        background-color: #f0f0f2;\n" + 
			"        margin: 0;\n" + 
			"        padding: 0;\n" + 
			"        font-family: \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;\n" + 
			"        \n" + 
			"    }\n" + 
			"    div {\n" + 
			"        width: 600px;\n" + 
			"        margin: 5em auto;\n" + 
			"        padding: 50px;\n" + 
			"        background-color: #fff;\n" + 
			"        border-radius: 1em;\n" + 
			"    }\n" + 
			"    a:link, a:visited {\n" + 
			"        color: #38488f;\n" + 
			"        text-decoration: none;\n" + 
			"    }\n" + 
			"    @media (max-width: 700px) {\n" + 
			"        body {\n" + 
			"            background-color: #fff;\n" + 
			"        }\n" + 
			"        div {\n" + 
			"            width: auto;\n" + 
			"            margin: 0 auto;\n" + 
			"            border-radius: 0;\n" + 
			"            padding: 1em;\n" + 
			"        }\n" + 
			"    }\n" + 
			"    </style>    \n" + 
			"</head>\n" + 
			"\n" + 
			"<body>\n" + 
			"<div>\n" + 
			"    <h1>Example Domain</h1>\n" + 
			"    <p>This domain is established to be used for illustrative examples in documents. You may use this\n" + 
			"    domain in examples without prior coordination or asking for permission.</p>\n" + 
			"    <p><a href=\"http://www.iana.org/domains/example\">More information...</a></p>\n" + 
			"</div>\n" + 
			"</body>\n" + 
			"</html>\n";
	static final String TEST_HTML_SAMPLE_STRING = "<html>\n" + 
			"	<head>\n" + 
			"		<title>Title</title>\n" + 
			"	</head>\n" + 
			"	<body>\n" + 
			"		<p>This is simple text inside of an HTML document. Simple!</p>\n" + 
			"	</body>\n" + 
			"</html>";
	
	/**
	 * This test feels useless to me, but I'm not sure how else to unit
	 * test an internet call?
	 * @throws IOException
	 */
	@Test
	public void testRead() throws IOException {
		URLContentExtractor mockedExtractor = mock(URLContentExtractor.class);
		URL url = new URL("http://www.test.com");
		//the mock causes read to return our hard coded value when passed url
		when(mockedExtractor.read(url)).thenReturn(TEST_HTML_SAMPLE_STRING);
		String actual = mockedExtractor.read(url);
		assertEquals(TEST_HTML_SAMPLE_STRING, actual);
	}

	
	/**
	 * This test could be dangerous because it is pulling from the internet instead of a mock 
	 * the content of the site could be changed and break our test
	 * @throws IOException
	 */
	@Test
	public void testReadFromExampleDotCom() throws IOException {
		URL url = new URL("http://www.example.com/");
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String actual = contentExtractor.read(url);
		assertEquals(TEST_HTML_EXAMPLECOM, actual);
		
	}
	//making sure sanitize works with a whole bunch of possible inputs
	//could write a helper method or put this in a hashmap 
	public void testSanitize() {
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String html = "<html><body>This is some text.<p>This should be returned</p></body></html>";
		String expected = "<p>This should be returned</p>";
		String actual = contentExtractor.sanitize(html);
		assertEquals(expected, actual);
	}
	
	public void testSanitizeNoBody() {
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String html = "<html></html>";
		String expected = "";
		String actual = contentExtractor.sanitize(html);
		assertEquals(expected, actual);
	}
	
	public void testSanitizeNoPElements() {
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String html = "<html><body>This is some text.This should be returned</body></html>";
		String expected = "";
		String actual = contentExtractor.sanitize(html);
		assertEquals(expected, actual);
	}
	
	public void testSanitizeNull() {
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String html = null;
		String expected = "";
		String actual = contentExtractor.sanitize(html);
		assertEquals(expected, actual);
	}

	public void testSanitizeEmptyString() {
		URLContentExtractor contentExtractor = new URLContentExtractor();
		String html = "";
		String expected = "";
		String actual = contentExtractor.sanitize(html);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testReadAndSanitize() throws IOException {
		// CALLS_REAL_METHODS means that any method that was not stubbed by us uses the real method 
		URLContentExtractor mockedExtractor = mock(URLContentExtractor.class, CALLS_REAL_METHODS);
		URL url = new URL("http://www.test.com");
		when(mockedExtractor.read(url)).thenReturn(TEST_HTML_SAMPLE_STRING);
		String actual = mockedExtractor.readAndSanitize(url);
		assertEquals("<p>This is simple text inside of an HTML document. Simple!</p>", actual);
	}
}
