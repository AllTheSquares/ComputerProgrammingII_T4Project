
package tictactoeproject;

public class Player {
    private static int ties;
    
    private char shape;
    private boolean winner;
    private int wins;
    
    
    Player() {
        wins = 0;
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
    
    /*
    should call updateBoard
    create public method "setShape", takes variable shape: char
    static function should increment ties if no win is possible;
    create public static function getTies, retunrs ties: int
    
    */
    
    
}

