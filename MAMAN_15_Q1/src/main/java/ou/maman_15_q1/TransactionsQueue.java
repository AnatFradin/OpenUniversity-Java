/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q1;

import java.util.ArrayList;

/**
 *
 * @author anatfradin
 */
public class TransactionsQueue {
    
    private ArrayList <Transaction> transactions;

    public TransactionsQueue(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public synchronized Transaction getTransaction()
    {
        if (transactions == null || transactions.size() == 0)
            return null;
        
       return transactions.remove(0);
    }
    
    
    
}
