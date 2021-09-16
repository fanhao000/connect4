import java.util.*;

public class Board {

    //rectangular area where the game will be played
    private int[][] board;

    //default length of the board
    private static final int DEFAULT_LENGTH = 7;

    //default height of the board
    private static final int DEFAULT_HEIGHT = 6;

    //creates the game board with the default 7x6 dimentions
    public Board () {
        board = new int [DEFAULT_HEIGHT][DEFAULT_LENGTH];
    }

    //creates the game board with special dimentions set by the client
    public Board (int height, int length) {
        board = new int [height][length];
    }

    //returns the rectangular game board
    public int[][] getBoard(){
        return board;
    }

    //prints out an image of the game board with an "|" on either side of each row 
    //0's representing empty spaces
    //usernames of players located where their tokens are located
    public void displayBoard() {
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++){
                if (j == 0){
                    System.out.print ("|");
                    System.out.print(" ");
                    System.out.print (board[i][j]);
                }
                else if (j!=0 && j == board[0].length-1){
                    System.out.print(" ");
                    System.out.print (board[i][j]);
                    System.out.print (" |");
                }
                else {
                    System.out.print(" ");
                    System.out.print (board[i][j]);
                }
            }
            System.out.print("\n");
        }
    }

    //checks each spot for a token and whether that piece is the beginning of a winner row
    public boolean checkWin (int player, int[][] board1){
        for(int i = 0; i < board1.length; i++){
            for (int j = 0; j < board1[0].length; j++){
                if(board1[i][j] != 0){
                    for(int rplus = -1; rplus <= 1; rplus++){
                        for(int cplus = -1; cplus <= 1; cplus++){
                            if(checkFour(player, i, j, rplus, cplus, board1)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    //checks whether there are 4 consecutive tokens of the same player in 1 direction
    public boolean checkFour(int player, int r, int c, int rchg, int cchg, int [][] board1){
        int count = 0;
        while (r >= 0 && c >= 0 && r < board1.length && c < board1[0].length) {
            if(rchg == 0 && cchg == 0){
                return false;
            }
            if (board1[r][c] != player) {
                return false;
            }
            count++;
            if(count == 4){
                return true;
            }
            r += rchg;
            c += cchg;
        }
        return false;
    }
}