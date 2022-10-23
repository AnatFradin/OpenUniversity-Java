/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package maman_11_question_1;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author anatfradin
 */
public class MAMAN_11_Question_1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("GameScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("The Game");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            Logger.getLogger(MAMAN_11_Question_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        GameLogic gl = new GameLogic();
//        gl.StartNewGame();
//        System.out.println( "1235-> " + gl.CheckGuess(1235));
//        System.out.println("7963-> " + gl.CheckGuess(7963));
//        
//        System.out.println("2435-> " + gl.CheckGuess(2435));
//        
//        Scanner sc= new Scanner(System.in);
//        System.out.print("Enter a string: ");  
//        String str= sc.next(); 
        
        launch(args);
    }
    
}
