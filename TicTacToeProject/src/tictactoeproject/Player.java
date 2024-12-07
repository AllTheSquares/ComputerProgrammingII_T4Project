
package tictactoeproject;
import java.util.Scanner;

public class Player {
    private static int ties;
    private static int matchesPlayed;
    
    private char shape;
    private boolean winner;
    private int wins;
    private int playerNumber;
    private double score;
    
    
    Player() {
        wins = 0;
        score = 0;
        playerNumber = 1;
        shape = 'x';
    }
    
    Player(int playerNumber, char shape) {
        wins = 0;
        score = 0;
        this.shape = shape;
        this.playerNumber = playerNumber;      
    }
    
    
    int getWins() {
        return wins;
    }
    
    void addWin() {
        wins += 1;
    }
    
    char getShape() {
        return shape;
    }
    
    void setShape(char shape) {
        this.shape = shape;
    }
    
    void playTurn(Board board) {
        System.out.printf("(%s) : It's player %d's turn!%n", this.shape, this.playerNumber);
        // set row and column to a value that is 100% out of range
        int row = -1;
        int column = -1;      
        
        // set false once appropriate coordinates are given :)
        boolean getCoordinates = true;
        
        // create a scanner for player to input coordinates
        Scanner input = new Scanner(System.in);

        // code will always execute once
        do { 
            // error-handling: in the event player puts a value that is NOT an integer
            try {
                // inputs collected in one line
                System.out.print("Enter desired row and column (from 0 - 3 inclusive): ");
                row = input.nextInt();
                column = input.nextInt();
                    
                // display message if row and column value is not within [0, 3]
                if (!(row >= 0 && row <= 3 && column >= 0 && column <=3)) {
                    System.out.println("Index out of range! Try again!");
                } else {
                    // allow loop to terminate once row and colum are within [0, 3]
                    if (board.updateBoard(this.shape, row, column)) {
                        getCoordinates = false;
                    } else { 
                        System.out.println("No cheating :) | Space already taken!");
                    }
                    
                }
                    
            // error-handling - display "bad input" if human player mistakenly puts non-integer
            } catch (Exception ex) {
                System.out.println("Bad input, try again!");
            }
        } while (getCoordinates);
        
    } 
}
    
    /*
    should call updateBoard
    create public method "setShape", takes variable shape: char
    static function should increment ties if no win is possible;
    create public static function getTies, retunrs ties: int
    
    */
    
    


