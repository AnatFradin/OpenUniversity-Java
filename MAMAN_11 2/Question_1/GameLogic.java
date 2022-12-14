/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maman_11_question_1;


import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author anatfradin
 */
public class GameLogic {
    private int[] numberAsArray = new int[4];
    private int number = -1;
    private int numberOfGuesses = 0;

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }
    
    public GameLogic(){
    }

    public void startNewGame() {
        number = 0;
        numberOfGuesses = 0;
        generateNewNumber();
        
    }
    
    private void generateNewNumber() {
        int[] randomArray = new int[10];
       
        numberAsArray[0] = randomDigit(10,false, randomArray);
        for (int i = 1; i < numberAsArray.length; i++) {
            numberAsArray[i] = randomDigit(10,true, randomArray);
        }
        
        for (int i = 0; i < numberAsArray.length; i++) {
            number = number * 10 + numberAsArray[i];
        }
    }
    
    // Generate random digit, without duplication accordin to ValidationArray
    private int randomDigit(int max, boolean zeroIncluded, int[] validationArray){
        Random rand = new Random();
        boolean haveNumberToGuess = false;
        // validate we have number to guess
        for (int i = 0; i < validationArray.length; i++) {
            if(validationArray[i] == 0){
                haveNumberToGuess = true;
                break;
            }
        }
        
        if(!haveNumberToGuess){
            System.out.println("We have no numbers to create random integer");
            return -1;
        }
        
        while (haveNumberToGuess) { 
            int num = rand.nextInt(max);
            if(!zeroIncluded && num == 0)
                continue;
            if (validationArray[num] == 0) {
                validationArray[num]++;
                return num;
            }
        }
        return -1;
    }
    
    private String validateNumber(int number) {
        if (number > 9999 || number < 1000) {
            return ("Number should be between 1000 and 9999");
        }
        return null;
    }
    
    private String convertIntToIntArray(int numberToConvert, int[]array){
        int tmp;
        int[] validationArray = new int[10];
        for (int i = array.length-1; i >= 0; i--) {
            tmp = numberToConvert % 10;
            // check that we dont hava same digit already
            if(validationArray[tmp]++ > 0){
                return("Digit " + tmp + " appears more than once");
            }
            array[i] = tmp;
            numberToConvert = numberToConvert/10;   
        }
        return null;
    }
   
    
    public Result checkGuess(int number){
        String validationResult = validateNumber(number);
        if (validationResult!= null){
            return new Result(false, 0,0, number + " is not a valid Number. " + validationResult);
        }
        
        int [] checkNumAsArray = new int[4];
        validationResult = convertIntToIntArray(number,checkNumAsArray);
        if (validationResult!= null){
            return new Result(false, 0,0, number + " is not a valid Number. " + validationResult);
        }
        
        int exactHit = 0;
        int hit = 0;
        for (int i = 0; i < checkNumAsArray.length; i++) {
            if ( numberAsArray[i] == checkNumAsArray[i]){
                exactHit++;
                hit++;
            }
            else{
               for (int j = 0; j < numberAsArray.length; j++) { 
                   if(numberAsArray[j] == checkNumAsArray[i]){
                       hit++;
                       break;
                   }
               }
            }
            
        }
        numberOfGuesses++;
        Result res;
        if(exactHit == numberAsArray.length){
            res = new Result(true, exactHit, hit);
        }
        else{
            res = new Result(false, exactHit, hit);
        }
        
        return res;
    }
}
