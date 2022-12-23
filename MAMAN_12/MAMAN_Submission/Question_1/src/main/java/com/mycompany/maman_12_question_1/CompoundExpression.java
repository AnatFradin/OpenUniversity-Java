package com.mycompany.maman_12_question_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
abstract public class CompoundExpression extends Expression{
    
    private final Expression operand_1;
    private final Expression operand_2;
    
    public CompoundExpression(Expression operand_1, Expression operand_2){
        this.operand_1 = operand_1;
        this.operand_2 = operand_2;
    }

    public Expression getOperand_1() {
        return operand_1;
    }

    public Expression getOperand_2() {
        return operand_2;
    }

    
    
}
