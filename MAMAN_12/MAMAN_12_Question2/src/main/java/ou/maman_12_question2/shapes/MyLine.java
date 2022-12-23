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
public class MyLine extends MyShape {

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(GraphicsContext ctx) {
        ctx.setStroke(getColor());
        ctx.setLineWidth(2);
        ctx.strokeLine(getX1(), getY1(), getX2(), getY2());
    }
    
    public double length(){
        
        return Math.sqrt(Math.pow(getX1()-getX2(),2)+
                    Math.pow(getY1()-getY2(),2));
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        MyLine otherLine = (MyLine)other;
        return (length() == otherLine.length());
    }

    @Override
    public void shift(int x, int y) {
        setX1(getX1() + x);
        setY1(getY1() + y);
        setX2(getX2() + x);
        setY2(getY2() + y);
    }

}
