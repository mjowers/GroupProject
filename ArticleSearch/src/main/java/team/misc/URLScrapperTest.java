package team.misc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

public class URLScrapperTest extends TestCase {

	
	
	String TEST_HTML_SAMPLE_STRING = new String("<html><head><title>Title</title></head><body>This is simple text inside of an HTML document. Simple!this-simple-should-not-matchsimple-should-also-not-matchsimple-
		-simple
	</body>
</html>")
	public void testRead() throws IOException {
		
		
	}

	public void testSanitize() {
		fail("Not yet implemented");
	}

}
