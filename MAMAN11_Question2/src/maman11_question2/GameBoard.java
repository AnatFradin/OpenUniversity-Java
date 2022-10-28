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
        Die,
        Alive,
        NA // if no value set
    }
    
    private int [][] theBoard;
    private int [][] paddedBoard;
    
    private int initiallBoardSize;
    
    public GameBoard(int boardSize) {
        this.theBoard = new int[boardSize][boardSize];
        this.paddedBoard = new int[boardSize+2][boardSize+2];
        initiallBoardSize = boardSize;
        FillTheBoard();
        PrintTheBoard(theBoard);
        PrintPaddedTheBoard();
        MakeNewGeneration();
        PrintTheBoard(theBoard);
        PrintPaddedTheBoard();
    }

    /** 
     * Fill the board with random 1 / 0 values
     */
    private void FillTheBoard() {
        Random rand = new Random(); 
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                theBoard[i][j] = rand.nextInt(2);
                paddedBoard[i+1][j+1] = theBoard[i][j];
            }
        }

    }

    private void PrintTheBoard(int [][] boardToPrint) {
        System.out.println("Real without padding");
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                System.out.print(boardToPrint[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private void PrintPaddedTheBoard() {
        System.out.println("Board with padding");
        for (int i = 0; i < paddedBoard.length; i++) {
            for (int j = 0; j < paddedBoard.length; j++) {
                System.out.print(paddedBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void MakeNewGeneration(){
        int [][] newGenerationBoard = new int [theBoard.length][theBoard.length];
        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard.length; j++) {
                newGenerationBoard[i][j] = MakeDecision(i,j).ordinal();
            }
        }
        theBoard = newGenerationBoard;
        UpdatePaddedBoard();
    }
    
    private void UpdatePaddedBoard(){
        for (int i = 0; i < theBoard.length; i++) {
            System.arraycopy(theBoard[i], 0, paddedBoard[i+1], 1, theBoard.length);
        }
    }
     
    private State MakeDecision(int i, int j) {
        int [] neighbors = new int [8];
        neighbors = FindMyNeighbors(i,j);
        
        int numOfAlives = 0;
        for (int k = 0; k < neighbors.length; k++) {
            if(neighbors[k] == 1)
                numOfAlives++;
        }
        
        if(theBoard[i][j] == 1){ // now alive
            if(numOfAlives == 2 || numOfAlives == 3){
                return State.Alive;
            }
            else
                return State.Die;
        }
        
        if(theBoard[i][j] == 0){ // now die
            if(numOfAlives ==3 ){
                return State.Alive;
            }
        }
        
        return State.Die;
    }
    
    private int[] FindMyNeighbors(int i, int j) {
        int padded_i = i+1;
        int padded_j = j+1;
        int [] neighbors = new int [8];
        int neighborIndex = 0;
        
        neighbors[neighborIndex++] = paddedBoard[padded_i-1][padded_j-1];
        neighbors[neighborIndex++] = paddedBoard[padded_i-1][padded_j];
        neighbors[neighborIndex++] = paddedBoard[padded_i-1][padded_j+1];
        
        neighbors[neighborIndex++] = paddedBoard[padded_i][padded_j-1];
        neighbors[neighborIndex++] = paddedBoard[padded_i][padded_j+1];
        
        
        neighbors[neighborIndex++] = paddedBoard[padded_i+1][padded_j-1];
        neighbors[neighborIndex++] = paddedBoard[padded_i+1][padded_j];
        neighbors[neighborIndex++] = paddedBoard[padded_i+1][padded_j+1];
    
        return neighbors;
    }
}
