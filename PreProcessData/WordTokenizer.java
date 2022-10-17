package PreProcessData;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is for INFSCI-2140 in 2022*
 * TextTokenizer can split a sequence of text into individual word tokens.*
 * Please add comments along with your code.
 */
public class WordTokenizer {
	// you can add essential private methods or variables
	private ArrayList<String> parsedTokenArr;
	private int index = 0;
	public WordTokenizer(char[] texts) {
		// Tokenize the input texts
		parsedTokenArr = new ArrayList<>();
		// Replace unnecessary character.
		String parsedText = new String(texts)
				.replaceAll("([-,.?:;'\"!`()]|(-{2})|(\\/.{3})|(\\/(\\/))|(\\/[/]))", " ")
				.replaceAll("( )+", " ");
		// System.out.println(parsedText);
		String[] parsedToken = parsedText.split(" ");
		parsedTokenArr.addAll(Arrays.asList(parsedToken));
	}

	public char[] nextWord() {
		// read and return the next word of the document
		// or return null if it is the end of the document
		if (index >= parsedTokenArr.size())
			return null;
		else {
			return parsedTokenArr.get(index++).toCharArray();
		}
	}

}