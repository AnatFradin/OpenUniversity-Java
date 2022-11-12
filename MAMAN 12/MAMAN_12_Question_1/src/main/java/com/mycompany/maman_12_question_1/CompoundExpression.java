/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public class CompoundExpression extends Expression{
    
    private Expression operand_1;
    private Expression operand_2;
    
    public CompoundExpression(Expression operand_1, Expression operand_2){
        this.operand_1 = operand_1;
        this.operand_2 = operand_2;
    }

    @Override
    public double calculate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
