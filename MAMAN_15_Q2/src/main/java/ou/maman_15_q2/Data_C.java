/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anatfradin
 */
public class Data_C implements IData{

    private int x = 0;
    private int y = 0;
    
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock = lock.writeLock();
    Lock readLock = lock.readLock();
    

    public Data_C(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getDiff() {
        try {
            readLock.lock();
            {
                return (Math.abs(x - y));
            }
        } finally {
            readLock.unlock();
        }
    }

    public void update(int dx, int dy) {
        try {
            writeLock.lock();
            {
                x = x + dx;
                y = y + dy;
                System.out.println("Updated: " + toString());
            }
        } finally {
            writeLock.unlock();
        }
    }
    
    @Override
    public String toString() {
        return "x=" + x + " y=" + y + " Diff=" + getDiff();
    }
    
}
