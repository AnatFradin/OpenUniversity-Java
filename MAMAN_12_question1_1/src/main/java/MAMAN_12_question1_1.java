
import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public class MAMAN_12_question1_1 {

    enum MATH_SIGN{
        PLUS, //0
        MINUS //1
    }
    private static Random rand = new Random();

    private static final int bound_double = 100;

    public static void main(String[] args) {
        ArrayList<Expression> array = generateArray(10);

        System.out.println("Calculate each Expression: ");
        
        for (Expression next : array) {
            System.out.println(next.toString() + " = " + next.calculate());
        }

        System.out.println("compare: ");
        boolean equalFound = false;
        
        for (int i = 0; i < array.size()-1; i++) {
            Expression exp_1 = array.get(i);
            for (int j = i+1; j < array.size(); j++) {
                Expression exp_2 = array.get(j);
                if (exp_1.equals(exp_2)) {
                    equalFound = true;
                    System.out.println(exp_1.toString() + " == " + exp_2.toString());
                }
            }
        }
       
        System.out.println("Done. " + 
                (equalFound ? "Equal expression FOUND" : "Equal expression NOT FOUND" ));

    }

    private static ArrayList<Expression> generateArray(int size) {
        ArrayList array = new ArrayList<Expression>();
        
        for (int i = 0; i < size; i++) {
            
            // 0 - AtomicExpression
            // 1 - CompoundExpression
            int kindOfExpression = generateRandomIntNumber(10);
            int depth = 0;
            
            if (kindOfExpression % 2 == 0){ // even number -> CompoundExpression 
                depth = generateRandomIntNumber(10);
            }
            
            // fill affay with random AtomicExpression objects. Later
            // they will used to freate Compound expressions.
            AtomicExpression [] aExpression = new AtomicExpression[depth +1];
            for (int index=0; index < aExpression.length; index ++){
                aExpression[index] = createAtomicExpression();
            }
            
            Expression aExp = aExpression[0];
                
            for (int j = 1; j < aExpression.length; j++) {
                Expression bExp = aExpression[j];
                aExp = createdRandomCompound(aExp,bExp);
                
            }
            array.add(aExp);
        }
        return array;
    }

    private static AtomicExpression createAtomicExpression() {
        AtomicExpression expression = 
                new AtomicExpression(generateRandomDoubleNumber(bound_double));
        return expression;
    }

    private static Expression createdRandomCompound(Expression aExp, Expression bExp) {
        Expression newExpression;
        int kindOfExpression = rand.nextInt(2);
        
        if(kindOfExpression == MATH_SIGN.PLUS.ordinal()){
            newExpression = new  AdditionExpression(aExp, bExp);
        }else{
            newExpression = new  SubtractionExpression(aExp, bExp);
        }
        
        return newExpression;
    }


    private static double generateRandomDoubleNumber(int bound_double) {
        
        //rand.nextDouble()* 2 - 1 -> generate negative and positive numbers
        // bound_double = number of digits in the number
        
        double num = (rand.nextDouble()* 2 - 1 )* bound_double;
        return  Math.floor(num * 100) / 100;
    }
    
    private static int generateRandomIntNumber(int bound_double) {
        double num = rand.nextDouble() * bound_double;
        return  (int)num;
    }
}
