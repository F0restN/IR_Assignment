package PreProcessData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import Classes.Path;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This is for INFSCI-2140 in 2022
 * Please add comments along with your code.
 */
public class TrectextCollection implements DocumentCollection {
	public BufferedReader bfReader;
	public TrectextCollection() throws IOException {
		// Open the file existing in Path.DataTextDir, and also made preparation for function nextDocument()
		bfReader = new BufferedReader(new InputStreamReader(new FileInputStream(Path.DataTextDir)));
	}

	public Map<String, Object> nextDocument() throws IOException {
		// Load one document from the corpus, and return this document's number and content.
		// the returned document should never be returned again.
		// when no document left, return null
		// NTT: remember to close the file that you opened, when you do not use it anymore

		// Init
		Map<String, Object> docMap = new HashMap<>();
		String line;
		String id = "";
		StringBuilder content = new StringBuilder();

		while ((line = bfReader.readLine()) != null){
			// Each single doc
			while (!line.equals("</DOC>")){
				// 1. Doc ID
				if (line.startsWith("<DOCNO>")){
					id = line.substring(8, 24);
				}
				// 2. Text
				if (line.startsWith("<TEXT>")){
					line = bfReader.readLine();
					while (!line.equals("</TEXT>")){
						content.append(line);
						line = bfReader.readLine();
					}
				}
				// Next line
				line = bfReader.readLine();
			}
			docMap.put(id, content.toString().toCharArray());
			return docMap;
		}

		// Close
		System.out.println("File reading end, close file");
		bfReader.close();
		return null;
	}

}
