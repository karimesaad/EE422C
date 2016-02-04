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

public class Translator 
{

	public static void main (String args[]) 
	{ 
		if (args.length != 1) 
		{
			System.err.println ("Error: Incorrect number of command line arguments");
			System.exit(-1);
		}
		processLinesInFile (args[0]);

	}

	/******************************************************************************
	 * Method Name: processLinesInFile                                             *
	 * Purpose: Opens the file specified in String filename, reads each line in it *
	 *          Invokes translate () on each line in the file, and prints out the  *
	 *          translated piglatin string.                                        *
	 * Returns: None                                                               *
	 ******************************************************************************/
	public static void processLinesInFile (String filename) 
	{ 

		Translator translator = new Translator(); 
		try 
		{
			FileReader freader = new FileReader(filename);
			BufferedReader reader = new BufferedReader(freader);

			for (String s = reader.readLine(); s != null; s = reader.readLine()) 
			{
				System.out.println(s); // Before
				String pigLatin = translator.translate(s);
				System.out.print('\n');
				System.out.println(pigLatin); // After
			}

			
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println ("Error: File not found. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) 
		{
			System.err.println ("Error: IO exception. Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/******************************************************************************
	 * Method Name: translate                                                      *
	 * Purpose: Converts String inputString into piglatin based on rules specified *
	 *          in your assignment write-up.                                       *
	 * Returns: String object containing the piglatin translation of               *
	 *          String inputString                                                 *
	 ******************************************************************************/

	public String translate (String inputString) 
	{ 
		System.out.println(convertToPigLatin(inputString));
		if(inputString.length() == 0){
			return "Empty String."; // Base Case
		}
		
		String result = "";
		while(inputString.length() != 0){
			
			int space = inputString.indexOf(' ');  // 12
			int hyphen = inputString.indexOf('-');  //4

			//TODO: finish this! ok! awesome!
			
		}
		return result;
	}
	
	
	// example:
	// well-thought
	// do-it-yourself
	String hyphenPigLatin(String str) {
		//str = do-it-yourself2
		
		if(!stringIsInAlphabet(str)){	
			return str;	//check if string doesn't have weird punctuation symbols
		}
		
		
		String result = "";
		while(str.indexOf('-') != -1 || (str.length() > 0)){
			int hyphen = str.indexOf('-');
			if (hyphen == -1){
				hyphen = str.length();
			}
			String tmpHypStr = str.substring(0, hyphen);
			result = result + convertToPigLatin(tmpHypStr);
			if (hyphen == str.length()){
				return result;
			} else {
				result = result + '-';
			}
	
			str = str.substring(hyphen + 1, str.length());
			
		}	
		return result;
	}

	
	// well -> ellway
	String convertToPigLatin(String str){
		String tmpPunct = "";
		if(!stringIsInAlphabet(str)){
			
			for(int i = str.length(); i > 0; i--){
				if(isPuncutation(str.charAt(i-1))){
					// continue
				} else{
					tmpPunct = str.substring(i, str.length());
					str = str.substring(0, i);
					break; // break out of for loop
				}
			}
			if(!stringIsInAlphabet(str)){
				return str + tmpPunct; // check if remaining string is valid
			}
		}
		
		int vowel = vowelIndex(str);	//returns the first instance of a vowel
		if(vowel == -1){	
			return (str + "ay") + tmpPunct;	//if there were no vowels present, then append "ay"
		}
		if(vowel == 0){ 	
			String result = str.substring(vowel+1, str.length());	//vowel was the first character
			result = result + str.charAt(vowel) + "yay";	//extract first letter and place at the end of the string followed by a "yay"
			return result + tmpPunct; 
		}
		if(str.charAt(vowel-1) == '\''){
			vowel = vowel - 1;
		}
		
		String result = str.substring(vowel, str.length());	//string starts with a consonant. Rule #2 from PDF
		result = result + str.substring(0, vowel) + "ay";
		
		return result + tmpPunct;
	}

	/**
	 * Looks to see if character is in the alphabet or is an apostrophe
	 * 
	 * @param ch - character to be checked
	 * @return returns true if in alphabet
	 */
	boolean charIsInAlphabet(char ch){
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || ( ch == '\'') || ( ch == '-')){
			return true;
		}else{
			return false;
		}
	}

	boolean stringIsInAlphabet(String str){
		for(int i=0; i < str.length(); i++){
			if(!charIsInAlphabet(str.charAt(i))){
				return false;
			}
		} 
		return true;
	}

	
	
	/*
	 * Looks for the index of the Hyphen 
	 * Input: String to be searched
	 * Output: >0 : index found
	 * 		   -1 : not found
	 */
	int hyphenIndex(String str){
		return str.indexOf('-');
	}

	boolean isVowel(char ch){
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
			return true;
		} else {
			return false;
		}
	}

	int vowelIndex(String str){
		for(int i=0; i< str.length(); i++){
			if (isVowel(str.charAt(i))){
				return i;
			}
		}
		return -1; // didn't find it, so return a -1
	}
	
	boolean isPuncutation(char ch){
		if(ch == ',' || ch == '.' || ch == ';' || ch == ':' || ch == '!' || ch == '?'){
			return true;
		}
		return false;
	}

}
