/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.maman_12_question_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author anatfradin
 */
public class MAMAN_12_Question_1 {

    private static Random rand = new Random();

    // generate numbers in bound (-bound > number < +bound)
    private static int bound = 30;
    private static int bound_double = 100;

    public static void main(String[] args) {
        ArrayList<Expression> array = generateArray(10);

        System.out.println("The array is: ");
        
        for (Expression next : array) {
            System.out.print(next.toString() + " ");
        }

        System.out.println("The result is: ");
        
        for (Expression next : array) {
            System.out.println(next.toString() + " = " + next.calculate());
        }

        System.out.println("compare: ");
        
        for (int i = 0; i < array.size()-1; i++) {
            Expression exp_1 = array.get(i);
            for (int j = i+1; j < array.size(); j++) {
                Expression exp_2 = array.get(j);
                if (exp_1.equals(exp_2)) {
                    System.out.println(exp_1.toString() + " == " + exp_2.toString());
                }
            }
        }
        System.out.println("Done");
        

    }

    private static ArrayList<Expression> generateArray(int size) {
        ArrayList array = new ArrayList<Expression>();

        for (int i = 0; i < size; i++) {
            // 0 - AtomicExpression
            // 1 - pure AdditionExpression -> 3+4
            // 2 - pure SubtractionExpression -> 4-6
            // 3 - AdditionExpression -> (3-2) + 4
            // 4 - pure SubtractionExpression -> 4-6
            int kindOfExpression = rand.nextInt(3);

            switch (kindOfExpression) {
                case 0:
                    array.add(createAtomicExpression());
                    break;

                case 1:
                    array.add(createPureAdditionExpression());
                    break;

                case 2:
                    array.add(createPureSubtractionExpression());
                    break;
                default:
                    throw new AssertionError();
            }
        }

        return array;
    }

    private static AtomicExpression createAtomicExpression() {
        AtomicExpression expression = new AtomicExpression(generateRandomNumber());
        System.out.println("AtomicExpression: " + expression.toString());
        return expression;
    }

    private static AdditionExpression createPureAdditionExpression() {
        Expression exp1 = createAtomicExpression();
        Expression exp2 = createAtomicExpression();
        AdditionExpression expression = new AdditionExpression(exp1, exp2);
        System.out.println("AdditionExpression: " + expression.toString());
        return expression;
    }

    private static AdditionExpression createAdditionExpression() {
        Expression exp1 = createPureSubtractionExpression();
        Expression exp2 = createAtomicExpression();
        AdditionExpression expression = new AdditionExpression(exp1, exp2);
        System.out.println("AdditionExpression: " + expression.toString());
        return expression;
    }

    private static SubtractionExpression createPureSubtractionExpression() {
        Expression exp1 = createAtomicExpression();
        Expression exp2 = createAtomicExpression();
        SubtractionExpression expression = new SubtractionExpression(exp1, exp2);
        System.out.println("SubtractionExpression: " + expression.toString());
        return expression;
    }

    private static SubtractionExpression createSubtractionExpression() {
        Expression exp1 = createPureAdditionExpression();
        Expression exp2 = createAtomicExpression();
        SubtractionExpression expression = new SubtractionExpression(exp1, exp2);
        System.out.println("SubtractionExpression: " + expression.toString());
        return expression;
    }

    private static double generateRandomNumber() {
        return rand.nextDouble() * bound_double - bound;
    }
}
