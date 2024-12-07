
package tictactoeproject;
public class Board {
    private static char[][] board = new char[4][4];
    private static int spacesLeft;
    
    /*
    
    make a public class updateBoard, with three parameters player: char, x: int, y: int
    
    updateBoard should return a char[][] with the particular coordinate provided replaced
    
    */
    
    // Method to check if there is a three-in-a-row
    public boolean checkThreeInARow(Player player) {
        
        char shape = Player.getShape();
        
        
        // Check rows
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 1; j++) { // Only go up to column 1
                if (board[i][j] == shape && board[i][j + 1] == shape && board[i][j + 2] == shape) {
                    return true; // Found a 3-in-a-row horizontally
                }
            }
        }

        // Check columns
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 1; j++) { // Only go up to row 1
                if (board[j][i] == shape && board[j + 1][i] == shape && board[j + 2][i] == shape) {
                    return true; // Found a 3-in-a-row vertically
                }
            }
        }

        // Check diagonals
        // Top-left to bottom-right diagonals
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                if (board[i][j] == shape && board[i + 1][j + 1] == shape && board[i + 2][j + 2] == shape) {
                    return true; // Found a 3-in-a-row diagonally
                }
            }
        }

        // Top-right to bottom-left diagonals
        for (int i = 0; i <= 1; i++) {
            for (int j = 2; j <= 3; j++) {
                if (board[i][j] == shape && board[i + 1][j - 1] == shape && board[i + 2][j - 2] == shape) {
                    return true; // Found a 3-in-a-row diagonally
                }
            }
        }

        return false; // No 3-in-a-row found
    }
    
    // clears the board at the end of the game
    
    public void clearBoard() {
        board = new char[4][4];
    }

    
    public void updateBoard(Player player,int x, int y) {
        board[x][y] = player.getShape();
        
    }

}