/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_15_q2;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author anatfradin
 */
public class FindDiffThread extends Thread{
    private Random rand = new Random();
    private Data data;

    public FindDiffThread(Data data) {
        this.data = data;
    }
    
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("Diff: " + data.getDiff());
            try {
                sleep(rand.nextInt(100)); // sleep randomly 100 ms
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
