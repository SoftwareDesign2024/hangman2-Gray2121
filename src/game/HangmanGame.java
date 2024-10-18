//Grayson Hargens
package game;

import util.ConsoleReader;
import util.HangmanDictionary;

public class HangmanGame {
    
    private Guesser guesser;
    private Executioner executioner;

 //Creates our two objects with the variables needed for each
    public HangmanGame(Guesser guess, Executioner ex) {
        guesser = guess;
        executioner = ex;
    }
//Plays our game, logic for running the game
    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
            Character guess = guesser.getGuessChar();
                guesser.makeGuess(guess);
                executioner.subtractFromGuesses(guess);
                
                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                else if (executioner.isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        System.out.println("The secret word was " + executioner.getSecretWord());
    }
    
   

 
//Tells us if number of guesses is lost and the game ends
    private boolean isGameLost() {
        return executioner.getNumGuessesLeft() == 0;
    }
    
 //Prints our data to the screen gets our words from getLetters to 
    private void printStatus() {
        System.out.println(executioner.getDisplayWord());
        System.out.println("# misses left = " + executioner.getNumGuessesLeft());
        System.out.println("letters not yet guessed = " + guesser.getLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        System.out.println("*** " + executioner.getSecretWord());
        System.out.println();
    }

}