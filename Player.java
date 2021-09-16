import java.util.*;

public class Player {

    //name of the player
    private String name;

    //token object for the given player object
    private Token piece;

    //basic constructor
    public Player () {
        name = "Default";
    }

    //constructor to assign name
    public Player (String givenName){
        name = givenName;
    }

    //returns name of player
    public String getName () {
        return name;
    }

    //creates a token object for the player 1 instance
    public void makeToken(int digit){
        piece = new Token (digit);
    }

    //creates a token for the player 2 instance
    public void makeToken (int digit, int takenNumber){
        piece = new Token (digit, takenNumber);
    }

    //returns 1 or 2 randomly to imitate the flipping of a coin
    public boolean chooseHeadsTails(int value){
        int coin = (int)(Math.random()*2);
        return value == coin;
    }
    //returns the token number of the player
    public int getToken (){
        return piece.getNumber();
    }

    //places a token on the board at the base of the selected column
    public void placeToken(int c, int[][] board, int token){
        int row = board.length-1;
        boolean full = true;
        while(row >= 0 && token > 0){
            if(board[row][c] == 0){
                board[row][c] = token;
                token = 0;
                full = false;
            }
            row--;
        }
        if (full) {
            throw new Error("Entered column is full!!");
        }
    }

    
}