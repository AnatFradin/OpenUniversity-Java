/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anatfradin
 */
public class UpdateThread extends Thread {
    private Random rand = new Random();
    private Data data;

    public UpdateThread(Data data) {
        this.data = data;
    }
    
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            int newX = rand.nextInt(100);
            int newY = rand.nextInt(100);
            data.update(newX, newY);
            System.out.println("After update: " + data.toString());
            try {
                sleep(rand.nextInt(100)); // sleep randomly 100 ms
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
     
}
