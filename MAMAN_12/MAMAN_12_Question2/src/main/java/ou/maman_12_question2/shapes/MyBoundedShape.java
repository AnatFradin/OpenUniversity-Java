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
public abstract class MyBoundedShape extends MyShape{
    
    
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean fill) {
        super(x1, y1, x2, y2, color,fill);
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        MyShape otherShape = (MyShape)other;
        return (getX2() == otherShape.getX2() && getY2() == otherShape.getY2());
    }
    
    @Override
    public void shift(int x, int y) {
        setX1(getX1() + x);
        setY1(getY1() + y);
    }
    
}
