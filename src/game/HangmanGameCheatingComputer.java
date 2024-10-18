package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 */
public class HangmanGameCheatingComputer extends Executioner{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    

    // word that is being guessed
    private String mySecretWord;
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord; 
    // executioner state
    private List<String> myRemainingWords;



    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGameCheatingComputer (HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	super(dictionary, wordLength, numGuesses);
        mySecretWord = makeSecretWord(dictionary, wordLength);
        myNumGuessesLeft = numGuesses;
        
        myDisplayWord = new DisplayWord(mySecretWord);
        myRemainingWords = dictionary.getWords(wordLength);
    }

    
  public void cheat(char guess) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        myRemainingWords = templatedWords.get(maxKey);
        Collections.shuffle(myRemainingWords);
        //System.out.println("in cheat");
       
        mySecretWord = myRemainingWords.get(0);
        //System.out.println(mySecretWord);
        myDisplayWord = maxKey;
    }
 @Override
  public String getSecretWord() {
      return mySecretWord;
  }
 
   
  @Override 
   public boolean checkGuessInSecret (char guess) {
	   //System.out.println("in guess secret " + mySecretWord);
    	cheat(guess);
        if (mySecretWord.indexOf(guess) >= 0) {
        	//System.out.println(mySecretWord + "in guess in secret");
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
   
    
}
