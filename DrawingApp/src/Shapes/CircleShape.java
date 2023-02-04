/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import Shapes.TwoDimensionalShape;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author pmzsp1
 */
public class CircleShape extends EllipseShape{
    
     public CircleShape(double[] userInputs){
        
        super(userInputs);
        setHeight(userInputs[3]);
    }
    
    @Override
    public String printShapeDetail( ){
        
        String info = "LineShape\n\tID " + String.valueOf(this.getID());
        info = info + "\n\1x= " + String.valueOf(getX1());
        info = info + "\n\1y = " + String.valueOf(getY1());
        info = info + "\n\r = " + String.valueOf(getWidth());
        
        return info;
        
    }

}
