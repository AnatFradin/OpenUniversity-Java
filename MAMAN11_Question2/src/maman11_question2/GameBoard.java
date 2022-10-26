/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman11_question2;

import java.util.Random;

/**
 *
 * @author anatfradin
 */
public class GameBoard {

    private enum State{
        Alive,
        Die,
        NA // if no value set
    }
    
    private int [][] theBoard;
    
    public GameBoard(int boardSize) {
        this.theBoard = new int[boardSize][boardSize];
        FillTheBoard();
        PrintTheBoard();
    }

    /** 
     * Fill the board with random 1 / 0 values
     */
    private void FillTheBoard() {
        Random rand = new Random(); 
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                theBoard[i][j] = rand.nextInt(2);
            }
        }

    }

    private void PrintTheBoard() {
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                System.out.print(theBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void MakeNewGeneration(){
        int [][] newGenerationBoard = new int [theBoard.length][theBoard.length];
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                Check(newGenerationBoard, i,j)
            }
            System.out.println();
        }
    }

    private void Check(int[][] newGenerationBoard, int i, int j) {

        int[] testBoard = new int[8];
        testBoard = fillTestBoard(i, j);
        newGenerationBoard[i][j] = MakeDecision(i, j);
    }
    
     private int[] fillTestBoard(int i, int j) {
        // Find new generation for cell in top row;
        if (i == 0) {

        } 
        
// Find new generation for cell in last row;
        else if (i == newGenerationBoard.length) {

        } // calculate new generation for cell in first Column
        else if (j == 0) {

        } // calculate new generation for cell in last Column
        else if (j == newGenerationBoard.length) {

        }

        // calculate new generation for middle cell
    }
}
