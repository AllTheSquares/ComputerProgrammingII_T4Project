
package tictactoeproject;
import java.util.ArrayList;

class Computer extends Player {
    public void playTurn(Board board) {
        System.out.printf("(%s) : It's the computer's turn!%n", this.getShape());
        char myShape = this.getShape();
        char oppShape = ' ';
        
        if (myShape == 'X') {
            oppShape = 'O';
        } else {
            oppShape = 'X';
        }
        
        if (board.getSpacesLeft() < 14) {
            checkForWin(board, myShape);
            checkForWin(board, oppShape);
        }
        
        if (board.getSpacesLeft() > 12) {
            int eventSelect = (int)(3* Math.random());
            
            switch (eventSelect){
                case (0):
                    randomCenter(board, myShape);
                    break;
                case (1):
                    randomOuter(board, myShape);
                    break;
                case (2): 
                    randomSpace(board, myShape);
                    break;
            }
        } else {
            randomSpace(board, myShape);
        }
        
        

    }
    // In charge of automatically winning if detected or blocking a potential win
    public boolean checkForWin(Board board, char shape) {
        char[][] gameBoard = board.getBoard();
        
        // Check rows
        for (int i = 0; i < 4; i++) {
            char[] boardRow = gameBoard[i];
            int row = i;
            int count = 0;
            int indexToPlace = -1;
            
            for (int j = 0; j < 4; j++) {
                if (boardRow[j] == ' ') {
                    indexToPlace = j;
                    boardRow[j] = shape;
                    count++;
                } else if (boardRow[j] == shape) {
                    count++;
                } else {
                    count = 0;
                }
            }
            
            if (count == 3) {
                board.updateBoard(shape, row, indexToPlace);
                break;
            }
            
            
        }
        

        // Check columns
        for (int i = 0; i < 4; i++) {
            int column = 0;
            int indexToPlace = -1;
            int count = 0;

            char[] boardColumn = new char[4];
            
            for (int j = 0; j < 4; j++) {
                boardColumn[j] = gameBoard[j][i];
                System.out.println(boardColumn[j]);
                if (boardColumn[j] == ' ') {
                    indexToPlace = j;
                    boardColumn[j] = shape;
                    count++;
                } else if (boardColumn[j] == shape) {
                    count++;
                } else {
                    count = 0;
                }
                
            if (count == 3) {
                    board.updateBoard(shape, indexToPlace, column);
                    break;
            }
            }

        }

        // Check diagonals
        // Top-left to bottom-right diagonals (4)
        for (int i = 0; i <= 1; i++) {
            int count = 0;
            boolean finished = false;
            int indexToPlace = -1;
            
            char[] diagonalCheck = new char[3];
            
            for (int j = 0; j <= 1; j++) {
                for(int k = 0; k<=2; k++) {
                    diagonalCheck[i+k] = gameBoard[i+k][j+k];
                } 
                
                for (int l = 0; l < 3; l++) {
                    if (diagonalCheck[l] == ' ') {
                        diagonalCheck[l] = shape;
                        count++;
                    } else if (diagonalCheck[l] == shape) {
                        count++;
                    } else {
                        count = 0;
                    }

                if (count == 3) {
                        board.updateBoard(shape, l, l);
                        finished = true;
                        break;
                }                
                }
            if (finished) {
                break;
            }
                
            }
            
            
        }

        // Top-right to bottom-left diagonals (4)
//        for (int i = 0; i <= 1; i++) {
//            for (int j = 2; j <= 3; j++) {
//                if (board[i][j] == shape && board[i + 1][j - 1] == shape && board[i + 2][j - 2] == shape) {
//                }
//            }
//        }
        return false;
    }
    
    public boolean finishRow(Board board, char shape) {
        return false;
    }
    
    public boolean randomCenter(Board board, char shape) {
        boolean keepChoosing = true;
                    System.out.println("Running center");

        do {
            int row = (int)(1+2 * Math.random());
            int column = (int)(1+2 * Math.random());
            
            keepChoosing = !(board.updateBoard(shape, row, column));
            
        } while (keepChoosing);
        
        return !keepChoosing;
    }
    
    public boolean randomOuter(Board board, char shape) {         
        boolean keepChoosing = true;
                    System.out.println("Running outer");

        do {
            int row = (int)(4 * Math.random());
            int column = (int)(4 * Math.random());
            
            
            boolean rowColumnOK = !((row == 1 || row == 2)&&(column==1||column==2));
            
            if (rowColumnOK) { 
                keepChoosing = !(board.updateBoard(shape, row, column));
            }
            
        } while (keepChoosing);
        
        return !keepChoosing;
    }

    
    public boolean randomSpace(Board board, char shape) {
        boolean keepChoosing = true;
        do {
            int row = (int)(4 * Math.random());
            int column = (int)(4 * Math.random());
            keepChoosing = !(board.updateBoard(shape, row, column));
            
        } while (keepChoosing);
        
        return !keepChoosing;
    }
    
}


