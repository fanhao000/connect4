import java.util.Scanner;
import java.util.*;

public class Runner {

    public static void main (String args[]){
        Scanner scan = new Scanner(System.in);

        //make the board to be played on
        Board board = new Board();

        //stores the username of the person whose turn it is
        int turn = 0;

        //stores the name of the person whose turn it is
        String turnName = "";

        //stores the column coordinate (x)
        int c = 0;

        //stores the row coordinate (y)
        int r = 0;

        //make object for first player
        System.out.println ("Enter name of Player 1: ");
        Player p1 = new Player(scan.next());

        //make object for second player
        System.out.println ("Enter name of Player 2: ");
        Player p2 = new Player(scan.next());

        //make username for first player
        System.out.println ("Enter 1 digit username of " + p1.getName() + "\n** usename must be 1-9 inclusive **");
        p1.makeToken(scan.nextInt());

        //make username for second player
        System.out.println ("Enter 1 letter username of " + p1.getName() + "\n** username must be 1-9 inclusive and cannot equal " + p1.getToken() + "**");
        p2.makeToken(scan.nextInt(), p1.getToken());

        //decide who's going to go first
        System.out.println (p1.getName() + ", choose heads by typing 1 or tails by typing 2: ");
        if(p1.chooseHeadsTails (scan.nextInt())){
            System.out.println (p1.getName() + " has guessed correctly and will go first: ");
            turn = p2.getToken();
            turnName = p1.getName();
        }
        else {
            System.out.println (p1.getName() + " has guessed incorrectly and " + p2.getName() + " will go first: ");
            turn = p1.getToken();
            turnName = p2.getName();
        }

        //actually run the game by going back and forth until someone has 4 tokens in a row
        System.out.println ("Place a token down by entering the column when prompted. ");
        board.displayBoard();
        while (!board.checkWin(turn, board.getBoard())){
            if(turn == p1.getToken()){
                turn = p2.getToken();
                System.out.print (p2.getName() + "'s Turn: ");
            }
            else {
                turn = p1.getToken();
                System.out.print (p1.getName() + "'s Turn: ");
            }
            System.out.println ("Enter the column coordinate: starting from 1 and counting forwards: ");
            c = scan.nextInt() - 1;
            if(turn == p1.getToken()){
                p1.placeToken(c, board.getBoard(), p1.getToken());
            }
            else {
                p2.placeToken(c, board.getBoard(), p2.getToken());
            }
            board.displayBoard();
        }

        //prints out the winner after one player places 4 tokens in consecutive order
        if(turn == p1.getToken()){
            System.out.println ("CONGRATULATIONS " + p1.getName().toUpperCase() + " ON DESTROYING " + p2.getName().toUpperCase() + "!!");
        }
        else {
            System.out.println ("CONGRATULATIONS " + p2.getName().toUpperCase() + " ON DESTROYING " + p1.getName().toUpperCase() + "!!");
        }
    }
}