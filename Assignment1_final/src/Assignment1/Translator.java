/*
 * Name: Karime Saad
 *EID: ks38728
 *EE 422C lab time: TH 9:30-11am 
 */

package Assignment1; // first assignment of the semester

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Translator {

	public static void main(String args[]) {
		if (args.length != 1) {
			System.err.println("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile(args[0]);

	}

	/******************************************************************************
	 * Method Name: processLinesInFile * Purpose: Opens the file specified in
	 * String filename, reads each line in it * Invokes translate () on each
	 * line in the file, and prints out the * translated piglatin string. *
	 * Returns: None *
	 ******************************************************************************/
	public static void processLinesInFile(String filename) {

		Translator translator = new Translator();
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);

			for (String s = reader.readLine(); s != null; s = reader.readLine()) {
				System.out.println(s); // Before
				String pigLatin = translator.translate(s);
				System.out.println(pigLatin); // After
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}

		// To test user defined lines
		/*
		 * String input = ""; while(true){ System.out.println(
		 * "Please type in a word that you would like for this program to translate, thank you so much and have a great day! :)"
		 * ); Scanner in = new Scanner(System.in); input = in.nextLine();
		 * System.out.println("You entered: " + input); System.out.println(
		 * "But in pig latin...it means: " + translator.translate(input) +
		 * "\n"); }
		 */
	}

	/******************************************************************************
	 * Method Name: translate * Purpose: Converts String inputString into
	 * piglatin based on rules specified * in your assignment write-up. *
	 * Returns: String object containing the piglatin translation of * String
	 * inputString *
	 ******************************************************************************/

	public String translate(String inputString) {

		if (inputString.length() == 0) {
			return "Empty String."; // Base Case
		}

		String result = "";
		String current = "";
		while (inputString.length() > 0) {
			while (inputString.charAt(0) == ' ') {
				inputString = inputString.substring(1, inputString.length()); // get rid of all empty space
			}
			int space = inputString.indexOf(' '); // look for the first space
			if (space == -1) {
				space = inputString.length();
			}

			if (inputString.substring(0, space).indexOf('-') > -1) {	// check if there's a hyphen
				current = hyphenPigLatin(inputString.substring(0, space));
			} else {
				current = convertToPigLatin(inputString.substring(0, space)); // convert first word to pig latin
			}
			result += current;
			result += " ";
			// System.out.println(current);
			inputString = inputString.substring(space, inputString.length()); // rest of string to be converted
		}
		return result;
	}
	
	/* Converts original word with a hyphen in between to piglatin
	 * 
	 * Input: Original string with hypehn
	 * Output: string translated to piglatin
	 */
	String hyphenPigLatin(String str) {
		// str = do-it-yourself2
		String tmpPunct = "";	//tmpPunct will store the punctuation symbol found

		if (!stringIsInAlphabet(str)) {		//check is string has weird symbol
			tmpPunct = removePunctuation(str);
			str = str.substring(0, str.length() - 1 - tmpPunct.length());
			if (!stringIsInAlphabet(str)) {
				return str + tmpPunct; // check if remaining string is valid
			}

		}

		String result = "";
		while (str.indexOf('-') != -1 || (str.length() > 0)) {
			int hyphen = str.indexOf('-');
			if (hyphen == -1) {
				hyphen = str.length();
			}
			String tmpHypStr = str.substring(0, hyphen);
			result = result + convertToPigLatin(tmpHypStr);
			if (hyphen == str.length()) {		
				return result + tmpPunct; // hyphen is at end of string
			} else {
				result = result + '-';
			}

			str = str.substring(hyphen + 1, str.length());

		}
		return result + tmpPunct;
	}

	/*Converts a word to piglatin
 	* 
 	* Input: Original string (word)
	 * Output: String (word) translated to piglatin
	 */
 
	String convertToPigLatin(String str) {
		String tmpPunct = "";
		if (!stringIsInAlphabet(str)) {
			tmpPunct = removePunctuation(str);
			str = str.substring(0, str.length() - 1 - tmpPunct.length());
			if (!stringIsInAlphabet(str)) {
				return str + tmpPunct; // check if remaining string is valid
			}
		}

		int vowel = vowelIndex(str); // returns the first instance of a vowel
		if (vowel == -1) {
			return (str + "ay") + tmpPunct; // if there were no vowels present,
											// then append "ay"
		}
		if (vowel == 0) {
			return str + "yay"; //vowel is first letter in string. Just add "yay" at end of string
		}
		if (str.charAt(vowel - 1) == '\'') { 
			vowel = vowel - 1;
		}

		String result = str.substring(vowel, str.length()); // string starts with a consonant. Rule #2 from PDF
		result = result + str.substring(0, vowel) + "ay";

		return result + tmpPunct;
	}

	/**
	 * Looks to see if character is in the alphabet or is an apostrophe
	 * 
	 * Input: character to be checked
	 * Output: returns true if in alphabet
	 */
	boolean charIsInAlphabet(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == '\'') || (ch == '-')) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Looks to see if string is in the alphabet or is an apostrophe or hyphen. 
	 * Uses the helper mehtod "charIsInAlphabet".
	 * Input: character to be checked
	 * Output: returns true if in alphabet
	 */
	boolean stringIsInAlphabet(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!charIsInAlphabet(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Looks for the index of the Hyphen 
	 * Input: String to be searched 
	 * Output: >0 = index found,  -1 = not found
	 */
	int hyphenIndex(String str) {
		return str.indexOf('-');
	}

	/** Checks if character passed is a vowel (lower-case or upper-case)
	 * Input: character to be checked
	 * Output: returns false if char is not a vowel. Otherwise, returns true. 
	 */

	boolean isVowel(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
				|| ch == 'O' || ch == 'U') {
			return true;
		} else {
			return false;
		}
	}

	/** Looks for index of appareance of vowel in a string
	 * Input: String (word)
	 * Output: index of vowel found. If not found, returns a -1. 
	 */

	int vowelIndex(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (isVowel(str.charAt(i))) {
				return i; //returns index where vowel was found. 
			}
		}
		return -1; // didn't find it, so return a -1
	}

	/** Checks if character passed is a valid punctutation symbol
	 * Input: character to be checked
	 * Output: returns true if symbol is valid. Otherwise, returns false. 
	 */
	 
	boolean isPuncutation(char ch) {
		if (ch == ',' || ch == '.' || ch == ';' || ch == ':' || ch == '!' || ch == '?') {
			return true;
		}
		return false;
	}
	
	/**
	 * Removes punctuation from the end of the string and returns the string with the removed punctuation
	 * @param string to be checked
	 * @return punctuation symbols
	 */
	String removePunctuation(String str){
		String tmpPunct = "";
		for (int i = str.length(); i > 0; i--) {
			if (isPuncutation(str.charAt(i - 1))) {
				// continue
			} else {
				tmpPunct = str.substring(i, str.length());
				str = str.substring(0, i);
				break; // break out of for loop
			}
		}
		return tmpPunct;
	}

}
