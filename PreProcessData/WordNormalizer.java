package PreProcessData;
import Classes.Stemmer;

/**
 * This is for INFSCI-2140 in 2022
 *
 * Please add comments along with your code.
 */
public class WordNormalizer {
	// you can add essential private methods or variables

	// YOU MUST IMPLEMENT THIS METHOD
	public char[] lowercase(char[] chars) {
		// transform the uppercase characters in the word to lowercase
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Character.toLowerCase(chars[i]);
		}
		return chars;
	}

	public String stem(char[] chars) {
		// use the stemmer in Classes package to do the stemming on input word.
		Stemmer stemmer = new Stemmer();
		stemmer.add(chars, chars.length);
		stemmer.stem();
		return stemmer.toString();
	}

}