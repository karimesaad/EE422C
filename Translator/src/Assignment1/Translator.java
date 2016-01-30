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
				//System.out.println(s); // Before
				String pigLatin = translator.translate(s);
				System.out.print('\n');
				//System.out.println(pigLatin); // After
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
//		if (inputString.length() == 0){
//			inputString = "Empty String.";
//			return inputString;
//		}
//		char ch = 0;
//		int index1 = 0;
//		int index2 = 0;
//		for (int i = 0; i < inputString.length(); i++){
//			ch = inputString.charAt(i);
//			while(ch != ' ' || '-'){
//				i++;
//				ch = inputString.charAt(i);
//			}
//			int j = 0;
//			char ch_j;
//			for(j = index2; j < i; j++){
//				ch_j = inputString.charAt(j);
//				if ((ch_j <= 'a' || ch >= 'z') || (ch <= 'A' && ch >= 'Z') || (ch_j != 39)){
//					index2 = i;
//				} else {
//					//add "yay" at the end
//				
//			}
//			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
//				index1 = i;
//				do { 
//					i++;
//					ch = inputString.charAt(i);
//				} while ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch == 39));
//				index2 = i;
//			}
//			char beginLetter = inputString.charAt(index1);
//			char lastLetter = inputString.charAt(index2 - 1);
//			if(beginLetter >= 'a' && beginLetter <= 'z'){
//				//
//			}
//		}
//		
//		// modify the following code. Add/delete anything after this point.
//		String outputString = new String(inputString); // Copies input to output and prints it. 
//		return outputString;
		System.out.print(stringIsInAlphabet("&#*"));
		return "Hello";
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
		return str.matches(".*(?i)[aeiou]") || str.contains("'") || str.contains("-");
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
	
}
