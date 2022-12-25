package ou.maman14_q2_1;


import javafx.collections.ObservableList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anatfradin
 */
public class Helper {
    
    public static void createOptionsView(ObservableList options, int start, int end) {
        for (int s_item = start; s_item < end; s_item++) {
            options.add(s_item);
        }
    }
    
}
