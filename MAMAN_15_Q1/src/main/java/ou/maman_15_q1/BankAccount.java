/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q1;


/**
 *
 * @author anatfradin
 */
public class BankAccount 
{
    
    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public synchronized int getBalance() {
        return balance;
    }

    
    public synchronized void transaction (int sum){
        while(balance + sum < 0){
            try {
                System.out.println("Account < " + accountNumber + " > WAIT !!!" +
                    " orig balance  < " + balance + " >"+
                    " requested transaction  < " + sum + " >");
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        int origBalance = balance;
        balance += sum;
        System.out.println("Account < " + accountNumber + " >" +
                    " EXECUTE transaction < " + sum + " >" + 
                    " orig balance  < " + origBalance + " >"+
                    " new balance  < " + balance + " >");
        notifyAll();
    }
    

    
    
}
