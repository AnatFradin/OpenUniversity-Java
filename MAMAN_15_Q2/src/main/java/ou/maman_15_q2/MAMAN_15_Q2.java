/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ou.maman_15_q2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anatfradin
 */
public class MAMAN_15_Q2 {

    public static void main(String[] args) {
        
        runPart_1();
        
        sleepMsec(15000);
        
        runPart_2();
        
        sleepMsec(15000);
        
        runPart_3();
        
                
    }

    private static void runPart_3() {
    
        System.out.println("\n*** Read / Write conditions, 4 threads");
        
        IData data = new Data_C(1,11);
        UpdateThread update = new UpdateThread(data);
        FindDiffThread diff = new FindDiffThread(data);
        
        UpdateThread update_1 = new UpdateThread(data);
        FindDiffThread diff_1 = new FindDiffThread(data);
        
        update.start();
        diff.start();
        update_1.start();
        diff_1.start();
    }

    private static void runPart_2() {
      
        System.out.println("\n*** Running 2 threads one after another");
        
        IData data = new Data_B(1,11);
        UpdateThread update = new UpdateThread(data);
        FindDiffThread diff = new FindDiffThread(data);
        
        
        update.start();
        diff.start();
    }

    private static void runPart_1() {
    
        System.out.println("\n*** Running 2 threads together ");
        IData data = new Data_A(1,11);
        UpdateThread update = new UpdateThread(data);
        FindDiffThread diff = new FindDiffThread(data);
        
        
        update.start();
        diff.start();
    }

    private static void sleepMsec(int msec) {
    try {
            Thread.sleep(msec);
        } catch (InterruptedException ex) {
            Logger.getLogger(MAMAN_15_Q2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
