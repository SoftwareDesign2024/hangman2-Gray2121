import game.Executioner;
import game.Guesser;
import game.HangmanGame;
import game.HangmanGameAutoGuesser;
import game.HangmanGameCheatingComputer;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    


    public static void main (String[] args) {
    	Executioner noCheat = new Executioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES);
    	Executioner cheat = new HangmanGameCheatingComputer(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES);
    	
    	Guesser regular = new Guesser(ALPHABET, NUM_MISSES);
    	Guesser auto = new HangmanGameAutoGuesser( ALPHABET, NUM_MISSES);
    	
        //new HangmanGame(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
        //new HangmanGameAutoGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
    	new HangmanGame(regular, cheat).play();
    }
}
