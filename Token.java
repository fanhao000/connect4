import java.util.*;

public class Token {

    //username number picked by the player and assigned to the token
    private int num;

    //sets the piece to 0 as default
    public Token(){
        num = 0;
    }

    //sets the piece to the number given by the client (1-9)
    public Token (int digit){
        if(digit < 1 || digit > 9){
            throw new IllegalArgumentException ("1 digit username must be within the bounds 1-9 inclusive");
        }
        num = digit;
    }

    //sets the piece to the number given by the client (1-9 and not the same as player 1)
    public Token (int digit, int takenNumber){
        if (digit <1 || digit > 9 || digit == takenNumber) {
            throw new IllegalArgumentException ("1 digit username must be within the bounds 1-9 inclusive and cannot equal " + takenNumber);
        }
        num = digit;
    }

    //returns the username number picked by the player
    public int getNumber (){
        return num;
    }
}