/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

/**
 *
 * @author anatfradin
 */
public class Data {

    private int x = 0;
    private int y = 0;

    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getDiff() {
        return (Math.abs(x - y));
    }

    public synchronized void update(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
    
    @Override
    public String toString() {
        return "x=" + x + " y=" + y + " Diff=" + getDiff();
    }
    
}
