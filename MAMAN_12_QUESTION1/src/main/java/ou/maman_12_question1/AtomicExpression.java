package ou.maman_12_question1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author anatfradin
 */
public class AtomicExpression extends Expression {

    private double number;

    public AtomicExpression(double number) {
        this.number = number;
    }

    @Override
    public double calculate() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
