package bingogame;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Jamal Kamareddine
 *
 * This program plays the game of bingo.
 */
public class BingoGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BingoCard myCard;
        Scanner keyboard = new Scanner(System.in);
        int totalGamesWon = 0;
        String input;

        System.out.println("Welcome! You're about to play a game of Bingo!");

        do {
            int numTurns = 0;
            myCard = new BingoCard();

            System.out.println("Here is your bingo card. Press ENTER to continue.");
            System.out.print(myCard);
            keyboard.nextLine();

            do {
                playGame(myCard);
                numTurns++;
            } while (numTurns < 50 && !myCard.gotBingo());

            totalGamesWon = determineWinner(myCard, totalGamesWon);
            numTurns = 0;

            System.out.println("Would you like to play again? Type YES or NO.");
            input = keyboard.nextLine();

        } while (input.equalsIgnoreCase("yes"));

        keyboard.close();
        System.out.println("Thanks for playing Bingo!");
    }

    /**
     * Plays the bingo game, calling out random numbers and filling the card
     * when there's a match.
     *
     * @param myCard The bingo card object.
     */
    public static void playGame(BingoCard myCard) {
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        int randNum = random.nextInt(75);
        int checkNum = myCard.checkBingo(randNum);

        System.out.println("The number is: " + randNum);
        System.out.println(myCard);

        if (checkNum == randNum) {
            System.out.println("You got a match!");
        }
        else {
            System.out.println("You didn't get a match.");
        }

        System.out.println("Press ENTER to continue.");
        // Comment out the line below to skip to the game result
        keyboard.nextLine();
    }

    /**
     * Determines if the user has won or lost and updates their win total.
     *
     * @param myCard The bingo card object.
     * @param totalGamesWon The total number of games won by the user.
     * 
     * @return The new total number of games won.
     */
    public static int determineWinner(BingoCard myCard, int totalGamesWon) {
        if (myCard.gotBingo()) {
            totalGamesWon++;
            System.out.println("BINGO! You won!");
        }
        else {
            System.out.println("Sorry you didn't win this time.");
        }

        System.out.println("Total games won: " + totalGamesWon);

        return totalGamesWon;
    }
}
