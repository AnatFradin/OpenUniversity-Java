/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author anatfradin
 */

public class Data_A implements IData {

    private int x = 0;
    private int y = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private boolean readExecuted = false;
    private boolean updateExecuted = false;

    public Data_A(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff() {
        return (Math.abs(x - y));
    }

    public synchronized void update(int dx, int dy) {
        x = x + dx;
        y = y + dy;
        System.out.println("Updated: " + toString());

    }

    @Override
    public String toString() {
        return "x=" + x + " y=" + y + " Diff=" + getDiff();
    }
    
}
