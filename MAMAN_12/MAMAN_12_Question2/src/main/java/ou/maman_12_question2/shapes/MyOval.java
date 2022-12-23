/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ou.maman_12_question2.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author anatfradin
 */
public class MyOval extends MyBoundedShape {
    
    public MyOval(int x1, int y1, int x2, int y2,Color color, boolean fill) {
        super(x1, y1, x2, y2, color, fill);
    }

    @Override
    public void draw(GraphicsContext ctx) {
        if(isFull()){
            ctx.setFill(getColor());
            ctx.fillOval(getX1(), getY1(), getX2(), getY2()); 
        }
        else{
            ctx.setStroke(getColor());
            ctx.strokeOval(getX1(), getY1(), getX2(), getY2()); 
        }
               
    }
    
}
