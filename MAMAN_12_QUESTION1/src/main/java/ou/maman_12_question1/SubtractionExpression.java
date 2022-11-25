package com.mycompany.maman_12_question_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public class SubtractionExpression extends CompoundExpression {
    
    public SubtractionExpression(Expression operand_1, Expression operand_2) {
        super(operand_1, operand_2);
    }
   
    @Override
    public double calculate() {
        return getOperand_1().calculate() - getOperand_2().calculate();
    }
    
    @Override
    public String toString() {
        return getOperand_1().toString() + " - " + getOperand_2().toString();
    }
}
