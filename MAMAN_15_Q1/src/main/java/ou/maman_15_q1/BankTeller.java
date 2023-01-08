/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q1;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author anatfradin
 */
public class BankTeller extends Thread{

    private TransactionsQueue transactionsQueue;
    private HashMap<Integer,BankAccount> accounts;
    private final int TIME = 100;

    private int tellerID; 
    
    public BankTeller(int tellerID,
                        TransactionsQueue transactionsQueue, 
                        HashMap<Integer, BankAccount> accounts) {
        this.transactionsQueue = transactionsQueue;
        this.accounts = accounts;
        this.tellerID = tellerID;
    }
    
    
    
    @Override
    public void run() {
        super.run();
        Transaction t = transactionsQueue.getTransaction();
        while(t != null){
            System.out.println("Teller < " + tellerID + " >" +
                    " Wants to run transaction < " + t.getTransaction() + 
                    " > on Account < " + t.getAccountNumber() + " >");
            BankAccount ba = accounts.get(t.getAccountNumber());
            ba.transaction(t.getTransaction());
            waitRandomTime();
            t = transactionsQueue.getTransaction();
        }
        
    }
    
    public void waitRandomTime(){
        Random r = new Random();
        try {
            int waitTime = r.nextInt(TIME);
            System.out.println("Teller < " + tellerID + " >" +
                                " Resting " + waitTime + " ms");
            sleep(waitTime);
            System.out.println("Teller < " + tellerID + " > is back to work");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
