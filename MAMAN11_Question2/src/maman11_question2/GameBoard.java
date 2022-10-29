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
        Alive
    }
    
    private int [][] gameBoard;
    
    /* same borad as gameBoard, but has additional padding lines & columns of zero
               00000
    101        01010
    011    --> 00110
    111        01110
               00000
    */
    private final int [][] paddedBoard;
 
    private final int boardSize;
    
    public GameBoard(int boardSize) {
        this.gameBoard = new int[boardSize][boardSize];
        this.paddedBoard = new int[boardSize+2][boardSize+2];
        this.boardSize = boardSize;
        fllTheBoard();
        printBoard();
    }

    /** 
     * Fill the board with random 1 / 0 values
     */
    private void fllTheBoard() {
        Random rand = new Random(); 
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = rand.nextInt(2);
                paddedBoard[i+1][j+1] = gameBoard[i][j];
            }
        }
    }

    private void printBoard() {
        System.out.println("Real without padding");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void makeNewGeneration(){
        int [][] newGenerationBoard = new int [gameBoard.length][gameBoard.length];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                newGenerationBoard[i][j] = makeDecision(i,j).ordinal();
            }
        }
        gameBoard = newGenerationBoard;
        updatePaddedBoard();
        printBoard();
    }
    
    private void updatePaddedBoard(){
        for (int i = 0; i < gameBoard.length; i++) {
            System.arraycopy(gameBoard[i], 0, paddedBoard[i+1], 1, gameBoard.length);
        }
    }
     
    /**
     * This method decides if in next generation specific
     * cell will reBorn / remain / die
     * @param i
     * @param j
     * @return 
     */
    private State makeDecision(int i, int j) {
        int [] neighbors = new int [8];
        neighbors = findMyNeighbors(i,j);
        
        int numOfAlives = 0;
        for (int k = 0; k < neighbors.length; k++) {
            if(neighbors[k] == 1)
                numOfAlives++;
        }
        
        if(gameBoard[i][j] == 1){ // now alive
            if(numOfAlives == 2 || numOfAlives == 3){
                return State.Alive;
            }
            else
                return State.Die;
        }
        
        if(gameBoard[i][j] == 0){ // now die
            if(numOfAlives ==3 ){
                return State.Alive;
            }
        }
        
        return State.Die;
    }
    
    /**
     * This method will return array of all 8 neighbors of the cell.
     * Because we have PaddedBoard , we never need to check the edges 
     * @param i
     * @param j
     * @return 
     */
    private int[] findMyNeighbors(int i, int j) {
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
    
    public int[][] getBoard() {
        return gameBoard;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
