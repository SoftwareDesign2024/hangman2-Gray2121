//Grayson Hargens
package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {
	// word that is being guessed
    protected String mySecretWord;
 // what is shown to the user
    private DisplayWord myDisplayWord;
    
    protected int myNumGuessesLeft;

    public Executioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
        mySecretWord = makeSecretWord(dictionary, wordLength);
        myDisplayWord = new DisplayWord(mySecretWord);
        myNumGuessesLeft = numGuesses;
    }
    
 // Returns a secret word.
    protected String makeSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret(char guess) {
    	
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
//Returns secretWord for use in print statements
    public String getSecretWord() {
        return mySecretWord;
    }
//Returns displayword for use in printStatements
    public DisplayWord getDisplayWord() {
        return myDisplayWord;
    }
 
    //Tell us if the displayWord equals the secret word and then the game is over
    public boolean isGameWon() {
        return myDisplayWord.equals(mySecretWord);
    }
    public void subtractFromGuesses(Character guess)
    {
    	if (!checkGuessInSecret(guess)) {
            	myNumGuessesLeft -= 1;
        }
    	
    }
    
  //Returns our number of guesses left
    public int getNumGuessesLeft() {
        return myNumGuessesLeft;
    }

	public String getMySecretWord() {
		// TODO Auto-generated method stub
		return mySecretWord;
	}
}


