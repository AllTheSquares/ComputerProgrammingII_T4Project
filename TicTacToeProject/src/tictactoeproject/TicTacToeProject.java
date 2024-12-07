/*
Wail Chaqour, Isai Rojas, Ryan Ruiz
Tic Tac Toe Project 2024
December 7, 2024
*/

package tictactoeproject;

import java.util.Scanner;


public class TicTacToeProject  {
    public static void main(String[] args) {
        char activeShape;
        boolean keepPlaying = true;
        
        Player player1 = new Player(1, 'X');
        Player player2 = new Player(2, 'O');
        Computer computer = new Computer();
        Board board = new Board(); 
        board.displayBoard();
        
        computer.setShape('X');
        
        
        while (keepPlaying) { 
        computer.playTurn(board);
        board.displayBoard();
        
        player2.playTurn(board);
        board.displayBoard();
        
        }

    }
}