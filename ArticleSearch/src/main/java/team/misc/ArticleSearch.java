package team.misc;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ArticleSearch 
{
    public static void main( String[] args ) throws IOException
    {
    Path wordsPath = FileSystems.getDefault().getPath("words.txt");
    FileReaderObject words = new FileReaderObject(wordsPath);
    
    Path urlPath = FileSystems.getDefault().getPath("urlslist.txt");
    FileReaderObject urls = new FileReaderObject(urlPath);
    
    ArrayList<String> wordList = words.sanitizeText(",\"");
    ArrayList<String> urlList = urls.getRawText();

    URL url = new URL(urlList.get(0));
    String text = URLContentExtractor.readAndSanitize(url);
    
    ArrayList<String> stringList = new ArrayList();
    stringList.add(text);
    
    ArrayList<String> stringArray = ArrayOrganizer.createArray(stringList, " ");
    
    HashMap<String, Integer> articleContains = BinarySearcher.search(wordList, stringArray);
    
    Set<String> keySet = articleContains.keySet();
    for (String key: keySet){
    	System.out.println(key + " " + articleContains.get(key));
    }
    
    
    
    }
}
