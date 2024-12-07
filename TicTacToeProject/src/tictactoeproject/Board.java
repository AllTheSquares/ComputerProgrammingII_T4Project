
package tictactoeproject;
public class Board {
    private static char[][] board = new char[4][4];
    private static int spacesLeft;
    
    Board() {
        initialize();
    }
    
    /*
    
    make a public class updateBoard, with three parameters player: char, x: int, y: int
    
    updateBoard should return a char[][] with the particular coordinate provided replaced
    
    */
    
    // Method to check if there is a three-in-a-row
    public boolean checkThreeInARow(char shape) {
        
        // Check rows
        for (char[] row: board) {
            for (int j = 0; j <= 1; j++) { // Only go up to column 1
                if (row[j] == shape && row[j + 1] == shape && row[j + 2] == shape) {
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

        // Method to clear the screen by printing blank lines (simulated clearing)
    public static void clearScreen() {
        // Display a message that we're clearing the screen

        // Print 30 blank lines to simulate clearing the console
        for (int i = 0; i < 30; i++) {
            System.out.println();  // Each iteration prints an empty line
        }
    }

    // Method to initialize the 4x4 board with empty spaces (' ')
    public static void initialize() {
        spacesLeft = 16;
        // Loop through each row in the 4x4 matrix (board)
        for (int i = 0; i < 4; i++) {
            // Loop through each column in the row
            for (int j = 0; j < 4; j++) {
                // Set each cell on the board to be an empty space (' ')
                // This ensures the board starts with no X or O in any spot
                board[i][j] = ' ';  // Empty space character to represent unoccupied spaces
            }
        }
    }
    
    // Method to print the board on the screen
    public void displayBoard() {
        clearScreen();
        
        // Loop through each row of the board
        for (int i = 0; i < 4; i++) {
            // Loop through each column of the current row
            for (int j = 0; j < 4; j++) {
                // Print each cell on the board, surrounded by brackets for better readability
                // The %c is used to format the character at each board position
                System.out.printf(" %c ", board[i][j]);
                
                if (j < 3) {
                    System.out.print("|");
                }
                
                }
                
            // After printing one row, move to the next line to print the next row
            if (i < 3) {
                System.out.println("\n---------------");
            }
        }
        
        System.out.println("\n");
//        // Check if the current player is human
//        if (!(currentPlayer instanceof Computer)) {
//            // If it's a human player's turn, clear the screen before printing the board
//            clearScreen();
//
//
//
//            // Print a prompt for the human player's turn, asking for the next move
//            System.out.println("\nIt’s your move! Make your choice.");
//        }
//        // If it's the computer's turn, clear the screen and display the computer's move
    }

    public boolean updateBoard(char shape ,int x, int y) {
        
        if (board[x][y] != ('X') && board[x][y] != 'O') {
            board[x][y] = shape;
            spacesLeft -= 1;
            return true;
        } else {
            // return this only if a space is not occupied
            return false;
        }
        
    }
   
    public char[][] getBoard() {
        return this.board;
    }
    
    public char[] getRow(int index) {
        return board[index];
    }
    
    public char[] getColumn(int index) {
        char[] column = new char[4];
        int rowIndex = 0;
        
        for (char[] row : board) {
            column[rowIndex] = row[index];
            rowIndex++;
        }
        
        return column;
    }
    
    public int getSpacesLeft() {
        return spacesLeft;
    }
}