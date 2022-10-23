/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman_11_question_1;

/**
 *
 * @author anatfradin
 */
public class Result {
    private boolean guessOK = false;
    private int numberOfBool = 0;
    private int numberOfPgia = 0;
    private String errorString = null;

    public String getErrorString() {
        return errorString;
    }
    
    public Result(boolean result, int bool, int pgia, String error){
        guessOK = result;
        numberOfBool = bool;
        numberOfPgia = pgia;
        errorString = error;
    }
    
    public Result(boolean result, int bool, int pgia){
        guessOK = result;
        numberOfBool = bool;
        numberOfPgia = pgia;
    }

    public boolean isGuessOK() {
        return guessOK;
    }

    public int getNumberOfBool() {
        return numberOfBool;
    }

    public int getNumberOfPgia() {
        return numberOfPgia;
    }
    
    @Override
    public String toString(){
        return this.errorString!= null?"ERROR ":"" + "Bul: " + this.numberOfBool + " Pgia: " + this.numberOfPgia;
    } 
    
    
}
