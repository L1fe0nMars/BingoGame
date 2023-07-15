package bingogame;

import java.util.ArrayList;

/**
 * @author Jamal Kamareddine
 *
 * This program performs the actions of the bingo game.
 */
public class BingoCard {
    private int[][] bingoCardArray = new int[5][5];

    /**
     * Adds random numbers onto the bingo card.
     */
    public BingoCard() {
        // Arraylist of random numbers on the bingo card
        ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
        boolean valid = false;
        int temp = 0;

        // Checks whether a number is already on the bingo card
        for (int row = 0; row < bingoCardArray.length; row++) {
            for (int col = 0; col < bingoCardArray[row].length; col++) {
                while (!valid) {
                    // Generates a random number in the specified range of each column
                    temp = (int) (Math.random() * 15) + 1 + 15 * col;

                    if (!cardNumbers.contains(temp)) {
                        valid = true;
                        cardNumbers.add(temp);
                    }
                }

                // Assigns the number at the row and column of the array and restarts the loop to add more numbers
                bingoCardArray[row][col] = temp;
                valid = false;
            }
        }
    }

    /**
     * Checks each number on the bingo card and if the number that was called is on
     * the card, replaces it with a 0.
     *
     * @param randNum The random number that was called out during the bingo game.
     *
     * @return The mathcing number on the card, otherwise -1 for no matches.
     */
    public int checkBingo(int randNum) {
        for (int row = 0; row < bingoCardArray.length; row++) {
            for (int col = 0; col < bingoCardArray[row].length; col++) {
                if (randNum == bingoCardArray[row][col]) {
                    bingoCardArray[row][col] = 0;
                    return randNum;
                }
            }
        }
        
        return -1;
    }

    /**
     * Checks if each row, column, or diagonal has all 0's.
     *
     * @return True if a row, column, or diagonal has all 0's, otherwise false.
     */
    public boolean gotBingo() {
        for (int row = 0; row < bingoCardArray.length; row++) {
            int horizontalMatches = 0;
            int verticalMatches = 0;
            int leftDiagonal = 0;
            int rightDiagonal = 0;

            // Check left corner diagonal
            if (bingoCardArray[row][row] == 0) {
                leftDiagonal++;
            }

            // Check right corner diagonal
            if (bingoCardArray[row][bingoCardArray[row].length - row - 1] == 0) {
                rightDiagonal++;
            }

            if (leftDiagonal == 5 || rightDiagonal == 5) {
                return true;
            }

            for (int col = 0; col < bingoCardArray[row].length; col++) {
                // Check horizontals
                if (bingoCardArray[row][col] == 0) {
                    horizontalMatches++;
                }

                // Check verticals
                if (bingoCardArray[col][row] == 0) {
                    verticalMatches++;
                }
                
                if (horizontalMatches == 5 || verticalMatches == 5) {
                    return true;
                }
            }
        }
       
        return false;
    }

    /**
     * @return The bingo card.
     */
    public String toString() {
        String str = "B" + "\t" + "I" + "\t" + "N" + "\t" + "G" + "\t" + "O" + "\n"
                + bingoCardArray[0][0] + "\t" + bingoCardArray[0][1] + "\t" + bingoCardArray[0][2] + "\t" + bingoCardArray[0][3] + "\t" + bingoCardArray[0][4] + "\n"
                + bingoCardArray[1][0] + "\t" + bingoCardArray[1][1] + "\t" + bingoCardArray[1][2] + "\t" + bingoCardArray[1][3] + "\t" + bingoCardArray[1][4] + "\n"
                + bingoCardArray[2][0] + "\t" + bingoCardArray[2][1] + "\t" + bingoCardArray[2][2] + "\t" + bingoCardArray[2][3] + "\t" + bingoCardArray[2][4] + "\n"
                + bingoCardArray[3][0] + "\t" + bingoCardArray[3][1] + "\t" + bingoCardArray[3][2] + "\t" + bingoCardArray[3][3] + "\t" + bingoCardArray[3][4] + "\n"
                + bingoCardArray[4][0] + "\t" + bingoCardArray[4][1] + "\t" + bingoCardArray[4][2] + "\t" + bingoCardArray[4][3] + "\t" + bingoCardArray[4][4] + "\n";

        return str;
    }
}
