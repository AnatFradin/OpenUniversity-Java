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
    private StringBuilder guessesHistory = new StringBuilder();
    
    public GameLogic(){
    }

    public void StartNewGame() {
        number = 0;
        numberOfGuesses = 0;
        guessesHistory = new StringBuilder();
        GenerateNewNumber();
        
    }
    
    private void GenerateNewNumber() {
        int[] randomArray = new int[10];
       
        numberAsArray[0] = RandomDigit(10,false, randomArray);
        for (int i = 1; i < numberAsArray.length; i++) {
            numberAsArray[i] = RandomDigit(10,true, randomArray);
        }
        
        for (int i = 0; i < numberAsArray.length; i++) {
            number = number * 10 + numberAsArray[i];
        }
        
        System.out.println("New number to Guess is " + number);
    }
    
    // Generate random digit, without duplication accordin to ValidationArray
    private int RandomDigit(int max, boolean zeroIncluded, int[] validationArray){
        Random rand = new Random();
        boolean haveNumberToGuess = false;
        // validate we have number to guess
        for (int i = 0; i < validationArray.length; i++) {
            if(validationArray[i] == 0){
                haveNumberToGuess = true;
                break;
            }
        }
        
        if(!haveNumberToGuess)
            System.out.println("We have no numbers to create random integer");
        
        while (haveNumberToGuess) { 
            int num = rand.nextInt(max + 1);
            if(!zeroIncluded && num == 0)
                continue;
            if (validationArray[num] == 0) {
                validationArray[num]++;
                return num;
            }
        }
        return -1;
    }
    
    private boolean ValidateNumber(int number) {
        if (number > 9999 || number < 1000) {
            System.out.println("Number should be between 1000 and 9999");
            return false;
        }
        return true;
    }
    
    private boolean ConvertIntToIntArray(int numberToConvert, int[]array){
        int tmp;
        int[] validationArray = new int[10];
        for (int i = array.length-1; i >= 0; i--) {
            tmp = numberToConvert % 10;
            // check that we dont hava same digit already
            if(validationArray[tmp]++ > 0){
                System.out.println("Digit " + tmp + " appears more than once");
                 return false;
            }
            array[i] = tmp;
            numberToConvert = numberToConvert/10;   
        }
        return true;
    }
    
    public String getNubersAsArray(){
        return Arrays.toString(numberAsArray);
    }
    
    public Result CheckGuess(int number){
        if (!ValidateNumber(number)){
            Result res =  new Result(false, 0,0, "Not valid Number");
            guessesHistory.append("\n").append(res.toString());
            return res;
        }
            
        
        int [] checkNumAsArray = new int[4];
        
        if (!ConvertIntToIntArray(number,checkNumAsArray)){
            Result res =  new Result(false, 0,0, "Not valid Number");
            guessesHistory.append("\n").append(res.toString());
            return res;
        }
        
        int bul = 0;
        int pgia = 0;
        for (int i = 0; i < checkNumAsArray.length; i++) {
            if ( numberAsArray[i] == checkNumAsArray[i]){
                bul++;
                pgia++;
            }
            else{
               for (int j = 0; j < numberAsArray.length; j++) { 
                   if(numberAsArray[j] == checkNumAsArray[i]){
                       pgia++;
                       break;
                   }
               }
            }
            
        }
        Result res;
        if(bul == numberAsArray.length){
            res = new Result(true, bul, pgia);
        }
        else{
            res = new Result(false, bul, pgia);
        }
        
        guessesHistory.append("\n").append(res.toString());
        return res;
            
    }
}
