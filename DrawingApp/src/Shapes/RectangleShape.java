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
public class RectangleShape extends TwoDimensionalShape{
    
    // constructor
    public RectangleShape(double[] userInputs){
        
        // the input must be ordered the following way
        super(userInputs);   
    }
    
    // 
    @Override
    public String printShapeDetail() {
        
        String info = "RectangleShape\n\tID " + String.valueOf(this.getID());
        info = info + "\n\tx0 = " + String.valueOf(super.getX1());
        info = info + "\n\ty0 = " + String.valueOf(super.getY1());
        info = info + "\n\tWidth = " + String.valueOf(super.getWidth());
        info = info + "\n\tHeight = " + String.valueOf(super.getHeight());
        
        if(super.getisFilled()){
            info = info + "\n\tRed = " + String.valueOf(super.getColorRed());
            info = info + "\n\tGreen = " + String.valueOf(super.getColorGreen());
            info = info + "\n\tBlue = " + String.valueOf(super.getColorBlue());
            info = info + "\n\tAlpha = " + String.valueOf(super.getColorAlpha());
        }
        
        return info;
    }
    // and some other functions to be developed next week . . . 
    
    public void draw(GraphicsContext gc){
        
        double y1Temp = -super.getY1() + gc.getCanvas().getHeight();
        
        gc.strokeRect(super.getX1(), y1Temp, super.getWidth(), super.getHeight());
        
    }
    
}
