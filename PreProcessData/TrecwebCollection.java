package PreProcessData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import Classes.Path;
import java.io.IOException;

/**
 * This is for INFSCI-2224 in 2022*
 * Please add comments along with your code.
 */
public class TrecwebCollection implements DocumentCollection {
	private final BufferedReader bfReader;
	private String removeHTMLTag(String str) {
		String reg = "(<[^>]*>)";
		return str.replaceAll(reg, "");
	}

	public TrecwebCollection() throws IOException {
		// Open the file existing in Path.DataWebDir, made preparation for function nextDocument()
		bfReader = new BufferedReader(new InputStreamReader(new FileInputStream(Path.DataWebDir)));
	}

	public Map<String, Object> nextDocument() throws IOException {
		// this method should load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NT: the returned content of the document should be cleaned, all html tags should be removed.
		// NTT: remember to close the file that you opened, when you do not use it anymore

		Map<String, Object> webMap = new HashMap<>();
		String line;
		String id = "";
		StringBuilder content = new StringBuilder();
		while ((line = bfReader.readLine()) != null){
			// Single DOC process
			while (!line.equals("</DOC>")){
				// 1. Doc ID
				if (line.startsWith("<DOCNO>")){
					id = line.substring(7, 23);
				}
				// 2. Content
				if (line.startsWith("</DOCHDR>")){
					line = bfReader.readLine();
					while (!(line = bfReader.readLine()).equals("</DOC>")){
						content.append(removeHTMLTag(line));
					}
					webMap.put(id, content.toString().toCharArray());
					return webMap;
				}
				line = bfReader.readLine();
			}

		}

		// Close
		System.out.println("Web reading end, close file");
		bfReader.close();
		return null;
	}

}
