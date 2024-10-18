package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * where the computer guesses letters based on a predictable pattern.
 *
 * @author Robert C. Duvall
 */
public class HangmanGameAutoGuesser extends Guesser {
    
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";

   
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord;
    // tracks letters guessed
    private StringBuilder myLettersLeftToGuess;
    // guesser state
    private String myLetters;
    private int myIndex;


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGameAutoGuesser ( String alphabet, int numGuesses) {
    	super(alphabet, numGuesses);
        
        myNumGuessesLeft = numGuesses;
        myLettersLeftToGuess = new StringBuilder(alphabet);
        
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
    }

    @Override
    public Character getGuessChar() {
    	Character guess = myLetters.charAt(myIndex++);
    	
    	if(Character.isAlphabetic(guess)) {
    	
    	return guess;
    	
    	}
    	System.out.println("Please Enter a Valid Letter");
    	return null;
    }

    
    }
    

    
    

    

   

    
    

