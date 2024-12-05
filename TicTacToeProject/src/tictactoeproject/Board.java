
package tictactoeproject;
public class Board {
    static char[][] board = new char[4][4];
    
    
    // go to specific square on board matrix and update it
    static void updateBoard(int row, int column, char shape) {
        try {
            board[row][column] = shape;
            
        } catch (Exception ex) {
            System.out.println("Oops");
        }
    }
    
    static void checkRow(char shape) {
        
    }
}
