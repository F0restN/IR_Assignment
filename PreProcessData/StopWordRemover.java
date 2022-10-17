package PreProcessData;
import Classes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This is for INFSCI-2140 in 2022
 *
 * Please add comments along with your code.
 */

public class StopWordRemover {
	//you can add essential private methods or variables.
	public BufferedReader bfReader;
	ArrayList<String> stopWords = new ArrayList<>();

	public StopWordRemover( ) throws IOException {
		// load and store the stop words from the fileinputstream with appropriate data structure
		// that you believe is suitable for matching stop words.
		// address of stopword.txt should be Path.StopwordDir
		bfReader = new BufferedReader(new InputStreamReader(new FileInputStream(Path.StopwordDir)));
		String line;
		while ((line = bfReader.readLine()) != null){
			stopWords.add(line);
		}
	}

	// YOU MUST IMPLEMENT THIS METHOD
	public boolean isStopword( char[] word ) {
		// return true if the input word is a stopword, or false if not
		String formatWord = String.valueOf(word);
		return stopWords.contains(formatWord);
	}
}
