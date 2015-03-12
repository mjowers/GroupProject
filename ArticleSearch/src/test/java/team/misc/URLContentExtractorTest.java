package team.misc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

public class URLContentExtractorTest extends TestCase {

	
	
	String TEST_HTML_SAMPLE_STRING = "<html>\n" + 
			"	<head>\n" + 
			"		<title>Title</title>\n" + 
			"	</head>\n" + 
			"	<body>\n" + 
			"		This is simple text inside of an HTML document. Simple!\n" + 
			"		this-simple-should-not-match\n" + 
			"		simple-should-also-not-match\n" + 
			"		simple-\n" + 
			"		-simple\n" + 
			"	</body>\n" + 
			"</html>";
	
	public void testRead() throws IOException {
		
	}

	public void testSanitize() {
		fail("Not yet implemented");
	}

}
