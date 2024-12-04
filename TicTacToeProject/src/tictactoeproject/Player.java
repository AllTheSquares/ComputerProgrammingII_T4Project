
package tictactoeproject;

public class Player {
    private static int ties;
    
    private char shape;
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
    
}

class Computer extends Player {
    
}


