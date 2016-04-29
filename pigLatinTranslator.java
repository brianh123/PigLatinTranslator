import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.io.*;

public class pigLatinTranslator
{
	public void pigLatinTranslatorFunction()
	{
		Scanner scan = new Scanner(System.in);

		ArrayList<String> inputWordList = new ArrayList<String>();

		
		
		String userStringInput; 

		String pigLatinEnding = "ay", userExit = "QUIT"; 

		String userInputStringFirstLetterRevised, userStringInputLastLetterRevised;

		String userInputStringBuilderDeleteRevised, userInputStringBuilderDeleteRevisedPunctuationRevised;
		
		String userStringConcatOne, userStringConcatWithPigLatinOne, userStringConcatWithPunctuationPlusPigLatinOne, userStringConcatTwo, userStringConcatWithPigLatinTwo;

		String userStringInputNumber;
		
		char userStringInputFirstLetter, userStringInputLastLetter;

		int userStringInputWordSize, userStringInputNumberLength;

		
		System.out.println("\n" + "Hello welcome to the Pig Latin translation program! " +"\n");

		System.out.println("Type a word, then press enter to process each word into Pig Latin." + "\n");
		
		System.out.println("When finished type 'QUIT' to see your translated phrase and exit the program." + "\n");

		System.out.println("Note: The program can handle the following puntuations correctly." + "\n");

		System.out.println(" .  !    ?    :    ; ");



		

		
		while (true)
		{


		System.out.println();
		userStringInput = scan.nextLine();

			
	    if (userStringInput.equals(userExit))
		{
			System.out.println();
			break;
		}
		

			
			//  Deletes the first letter off the user input.
		  
	    	userStringInputFirstLetter = userStringInput.charAt(0); 
	    	userInputStringFirstLetterRevised = Character.toString(userStringInputFirstLetter); 

			StringBuilder userInputStringBuilderDelete = new StringBuilder(userStringInput); 
			userInputStringBuilderDelete.deleteCharAt(0);
		
			userInputStringBuilderDeleteRevised = userInputStringBuilderDelete.toString();
			
			//----------------------------------------------------------------------------------------------------------------------
		
			// Checks the user input for punctuation. If true assigns the punctuation to a String variable and deletes it off the word.  
		 	
		 	if (userInputStringBuilderDeleteRevised.matches(".*\\p{Punct}"))
	   		{
	   	
	   		 userStringInputWordSize = userInputStringBuilderDeleteRevised.length(); 
	   		 userStringInputLastLetter = userStringInput.charAt(userStringInputWordSize); 
	   		
	   		 userStringInputLastLetterRevised = Character.toString(userStringInputLastLetter); 
	   		
	   		
	   
	   		
	   		
	   		StringBuilder userInputStringBuilderDeleteRevisedPunctuation = new StringBuilder(userInputStringBuilderDeleteRevised);
	   		userInputStringBuilderDeleteRevisedPunctuation.deleteCharAt(userStringInputWordSize - 1);
	   		
	   		userInputStringBuilderDeleteRevisedPunctuationRevised = userInputStringBuilderDeleteRevisedPunctuation.toString(); 

	   		//---------------------------------------------------------------------------------------------------------------------------
	   		
	   		
	   		// Adds the last letter, the pig latin ending, and the punctuation onto the user input. Adds the word to the array list. 
	   		
	   		 userStringConcatOne = userInputStringBuilderDeleteRevisedPunctuationRevised.concat(userInputStringFirstLetterRevised);
	   		
	   		
	   		userStringConcatWithPigLatinOne = userStringConcatOne + pigLatinEnding;
	   		
	   		 userStringConcatWithPunctuationPlusPigLatinOne = userStringConcatWithPigLatinOne + userStringInputLastLetterRevised;
	   		

	   		inputWordList.add(userStringConcatWithPunctuationPlusPigLatinOne);
	   		
	   		//----------------------------------------------------------------------------------------------------------------------------


	   		}

	   		// Checks if user input is a number. If true ignores all concatenation functions and adds number to the array list.

	   		else if (userStringInput.matches("\\d+"))
			{
				userStringInputNumber = String.valueOf(userStringInput); // make String builder delete last two letters
				userStringInputNumberLength = userStringInputNumber.length();

				
				inputWordList.add(userStringInputNumber);
					
			}
			//------------------------------------------------------------------------------------------------------------------
			
			// User input did not have punctuation or was not a number. Concatenation forumulas are initiated. Word is added to the array list.
	   		else 
	   		{
	   		

			userStringConcatTwo = userInputStringBuilderDeleteRevised.concat(userInputStringFirstLetterRevised); // adds the last letter to the end of the word
			userStringConcatWithPigLatinTwo = userStringConcatTwo + pigLatinEnding; // ads "ay" to the end of the word

		
		
			inputWordList.add(userStringConcatWithPigLatinTwo);

			//-----------------------------------------------------------------------------------------------------------------

			
	
		}
	}
		
		// Prints out the array list. 
		
		for (String inputWordListDisplay : inputWordList)
			{
			
			System.out.print(inputWordListDisplay + " ");
			}
		
	}
}