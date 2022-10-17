package Indexing;

import Classes.Path;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Please add comments along with your code.
 */
public class PreProcessedCorpusReader {

	private BufferedReader br;
	
	public PreProcessedCorpusReader(String type) throws IOException {
		// This constructor opens the pre-processed corpus file, Path.ResultHM1 + type
		// You can use your own version, or download from http://crystal.exp.sis.pitt.edu:8080/iris/resource.jsp
		// Close the file when you do not use it anymore
		InputStream fis;
		switch (type) {
			case "trecweb":
				fis = new FileInputStream(Path.ResultHM1Web);
				br = new BufferedReader(new InputStreamReader(fis));
				break;
			case "trectext":
				fis = new FileInputStream(Path.ResultHM1Text);
				br = new BufferedReader(new InputStreamReader(fis));
				break;
		}
	}

	public Map<String, Object> NextDocument() throws IOException {
		// read a line for docNo and a line for content, put into the map with <docNo, content>
		Map<String, Object> mapDoc = new HashMap<>();
		String docId;
		String content;

		if ((docId = br.readLine()) != null) {
			content = br.readLine();
			mapDoc.put(docId, content);
			return mapDoc;
		}
		if (br != null) br.close();
		return null;
	}

}
