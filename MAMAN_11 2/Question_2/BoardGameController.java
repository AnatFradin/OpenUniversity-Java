package maman11_question2;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author anatfradin
 */
public class BoardGameController implements Initializable {

    @FXML
    private Canvas canvas;
    private GameBoard gameBoard;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameBoard = new GameBoard(10);
        drawBoard();
        // TODO
    }    

    @FXML
    private void onPressNewGeneration(ActionEvent event) {
        gameBoard.makeNewGeneration();
        drawBoard();
    }

    private void drawBoard() {
        int [][] board = gameBoard.getBoard();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        DoubleProperty height = canvas.heightProperty();
        DoubleProperty wigth = canvas.widthProperty();
        int row_wight = wigth.intValue()/board.length;
        int row_height = height.intValue()/board.length;
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            x = 0;
            y = i*row_height;
            for (int j = 0; j < board[i].length; j++) {
                gc.setFill(Color.BLACK);
                gc.fillRect(x, 
                            y, 
                            row_wight,
                            row_height);
                if(board[i][j] == 0)
                    gc.setFill(Color.WHITE);
                else
                    gc.setFill(Color.CADETBLUE);
                gc.fillRect(x+1, 
                            y+1, 
                            row_wight-2,
                            row_height-2);
                x+=row_wight;
                
            }
            
        }
    }
    
}
