/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anatfradin
 */
public class Bank {
    
    private HashMap<Integer,BankAccount> accounts;
    private TransactionsQueue transactionsQueue;
    private Random rand = new Random();
    
    public Bank() {
        this.accounts = new HashMap<>();
        fillAccounts();
        createTransactions();
    }
    
    public void ExecuteWork(){
        BankTeller[] bt = new BankTeller[10];
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new BankTeller(i, transactionsQueue, accounts);
        }
        for (int i = bt.length - 1; i >= 0; i--) {
            bt[i].start();
        }
    }

    private void fillAccounts() {
        for (int i = 0; i < 5; i++) {
            accounts.put(i, new BankAccount(i,0));
        }
 
        
    }

    private void createTransactions() {
        ArrayList <Transaction> transactions = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            transactions.add(new Transaction(
                    rand.nextInt(5),
                    generateRandomIntNumber(1000)));
            
        }
        System.out.println("All Transactions:");
        for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
            Transaction next = iterator.next();
            System.out.println(next.toString());
            
        }
        transactionsQueue = new TransactionsQueue(transactions);
        
    }
    
    private int generateRandomIntNumber(int bound_double) {
        boolean sign = rand.nextBoolean();
        int num = rand.nextInt(bound_double) * (sign ? 1 : -1);
        return num;
    }
    
    
    
}
