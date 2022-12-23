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
    private int numberOfExactHit = 0;
    private int numberOfHit = 0;
    private String errorString = null;

    public String getErrorString() {
        return errorString;
    }
    
    public Result(boolean result, int exactHit, int hit, String error){
        guessOK = result;
        numberOfExactHit = exactHit;
        numberOfHit = hit;
        errorString = error;
    }
    
    public Result(boolean result, int exactHit, int hit){
        guessOK = result;
        numberOfExactHit = exactHit;
        numberOfHit = hit;
    }

    public boolean isGuessOK() {
        return guessOK;
    }

    public int getNumberOfExactHit() {
        return numberOfExactHit;
    }

    public int getNumberOfHit() {
        return numberOfHit;
    }
    
    @Override
    public String toString(){
        return this.errorString!= null?"ERROR ":"" + "ExactHit: " + this.numberOfExactHit + " Hit: " + this.numberOfHit;
    } 
    
    
}
