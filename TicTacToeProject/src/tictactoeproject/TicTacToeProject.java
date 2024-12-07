/*
Wail Chaqour, Isai Rojas, Ryan Ruiz
Tic Tac Toe Project 2024
December 7, 2024
*/

package tictactoeproject;

import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TicTacToeProject extends Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        
        Player player1 = new Player();
        Player player2 = new Player();
        
        Application.launch(args);
    }
    
    @Override public void start(Stage stage) {
        Pane pane = new Pane();
        
        
        
        
        Font font = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        Text text1 = new Text(20, 20, "Hello 1");
        text1.setFont(font);
        text1.setFill(Color.GREEN);
                
        pane.getChildren().add(text1);

        
        Scene scene = new Scene(pane, 600, 600);
        stage.setTitle("Tic Tac Toe 4");
        
        stage.setScene(scene);
        stage.show();
    }    
}