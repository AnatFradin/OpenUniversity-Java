

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public abstract class Expression {
    
    
  public abstract double calculate();  
  
  @Override
  public boolean equals(Object other){
      if (other ==null || other.getClass() != this.getClass()){
          return false;
      }
      return calculate() == ((Expression)other).calculate();
  }
}
