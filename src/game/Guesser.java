//Grayson Hargens
package game;

import util.ConsoleReader;

public class Guesser  {
    protected StringBuilder myLettersLeftToGuess;
    

 //Constructs our Guesser with the alphabet from Hangman and int numGuessLeft from hangman
    public Guesser(String alphabet, int numGuesses) {
        myLettersLeftToGuess = new StringBuilder(alphabet);
        
    }
    
 // Process a guess by updating the necessary internal state.
    public void makeGuess(char guess) {
        int index = getLettersLeftToGuess().indexOf("" + guess);
        if (index >= 0) {
            recordGuess(guess);
           
        }
    }
 // Record that a specific letter was guessed
    protected void recordGuess(char guess) {
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            myLettersLeftToGuess.deleteCharAt(index);
        }
    }
    
    public Character getGuessChar() {
    	String guess = ConsoleReader.promptString("Make a guess: ");
    	
    	if(Character.isAlphabetic(guess.toLowerCase().charAt(0))) {
    	
    	return guess.toLowerCase().charAt(0);
    	
    	}
    	System.out.println("Please Enter a Valid Letter");
    	return null;
    }
    
    

   
//returns our letters left to guess
    public StringBuilder getLettersLeftToGuess() {
        return myLettersLeftToGuess;
    }
}
