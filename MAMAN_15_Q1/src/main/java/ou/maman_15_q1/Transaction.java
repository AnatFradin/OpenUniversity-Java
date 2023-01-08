/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q1;

/**
 *
 * @author anatfradin
 */
public class Transaction {
    
    private int accountNumber;
    private int transaction; // positive = add money, negative = get money

    public Transaction(int accountNumber, int transaction) {
        this.accountNumber = accountNumber;
        this.transaction = transaction;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getTransaction() {
        return transaction;
    }

    @Override
    public String toString() {
        return " Account < " + accountNumber + " > transaction < " + transaction + " >";
    }
    
    
    
    
    
    
}
