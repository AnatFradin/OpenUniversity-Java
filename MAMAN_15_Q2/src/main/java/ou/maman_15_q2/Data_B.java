/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anatfradin
 */
public class Data_B implements IData{

    private int x = 0;
    private int y = 0;
    
    ReentrantLock lock = new ReentrantLock();
    Condition updatedCondition = lock.newCondition();
    Condition readFinishedCondition = lock.newCondition();
    private boolean waitForRead = true;

    public Data_B(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff() {
        try {
            lock.lock();
            {
                try {
                    if(!waitForRead){
                        updatedCondition.await();
                   }
                    
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                readFinishedCondition.signalAll();
                waitForRead = false;
                return (Math.abs(x - y));
            }
        } finally {
            lock.unlock();
        }
    }

    public void update(int dx, int dy) {
        try {
            lock.lock();
            {
                if (waitForRead) {
                    updatedCondition.signalAll();

                    try {
                        readFinishedCondition.await();
                        
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                x = x + dx;
                y = y + dy;
                System.out.println("Updated: " + toString());
                waitForRead = true;
                updatedCondition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
    
    @Override
    public String toString() {
        return "x=" + x + " y=" + y + " Diff=" + Math.abs(x - y);
    }
    
}
