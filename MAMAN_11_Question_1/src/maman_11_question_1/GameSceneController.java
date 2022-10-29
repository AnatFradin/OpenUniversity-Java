/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package maman_11_question_1;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class GameSceneController implements Initializable {

    @FXML
    private TextArea GameFlowMessages;
    
    private boolean gameIsOnRun = false;
    @FXML
    private TextField inputFromUser;
    
    private final GameLogic game = new GameLogic();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onStartNewGame() {
        GameFlowMessages.clear();
        gameIsOnRun = true;
        showDetails("Starting New Game. Good Luck !");
        game.startNewGame();
    }
    
    private void showDetails(String details){
        GameFlowMessages.appendText( details);
        GameFlowMessages.appendText( "\n");
    }
    
    private void checkTheGuess(int number) {
        Result res = game.checkGuess(number);
        if (res.getErrorString() != null) {
            showDetails("Error ! " + res.getErrorString());
            return;
        }
        if (res.isGuessOK()) {
            showDetails("BINGO ! " + number + " Is correct! Took you "
                    + game.getNumberOfGuesses() + " steps to find it out");
            gameIsOnRun = false;

        } else {
            showDetails(number + " : " + res.toString());
        }
    }

    @FXML
    private void onPressedNewGuess(ActionEvent event) {
        if(gameIsOnRun){
            String input = inputFromUser.getText();
            int intInput;
            try{
             intInput = Integer.parseInt(input);
             checkTheGuess(intInput);
             inputFromUser.clear();
            }
            catch(NumberFormatException e){
                showDetails("Error! " +input+ " Number should be Numeric. Please try again in correct format.");
            }
        }
        else{
            showDetails("No Game started");
        }
    }
   
}
