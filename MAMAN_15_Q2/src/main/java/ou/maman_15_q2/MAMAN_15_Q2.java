/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ou.maman_15_q2;

/**
 *
 * @author anatfradin
 */
public class MAMAN_15_Q2 {

    public static void main(String[] args) {
        System.out.println("Running MAMAN_15_Q2");
        Data data = new Data(1,11);
        UpdateThread update = new UpdateThread(data);
        FindDiffThread diff = new FindDiffThread(data);
        
        update.start();
        diff.start();
                
    }
}
