/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;
import Shapes.H63Shapes;

import javafx.scene.canvas.GraphicsContext;


/**
 *
 * @author pmzsp1
 */
public class LineShape extends H63Shapes {
    
    private double x1,x2,y1,y2;
    
    // constructor
    public LineShape(double[] userInputs){
        
        // the input must be ordered the following way
        super((int)userInputs[0]);
        
        x1 = userInputs[1];
        y1 = userInputs[2];
        x2 = userInputs[3];
        y2 = userInputs[4];
    }
    
    // 
    @Override
    public void draw(GraphicsContext gc){
        
        double y1Temp = -y1 + gc.getCanvas().getHeight();
        double y2Temp = -y2 + gc.getCanvas().getHeight();
        
        gc.strokeLine(x1, y1Temp, x2, y2Temp);
    }
    
    // 
    @Override
    public String printShapeDetail() {
        
        String info = "LineShape\n\tID " + String.valueOf(this.getID());
        info = info + "\n\tx1 = " + String.valueOf(x1);
        info = info + "\n\ty1 = " + String.valueOf(y1);
        info = info + "\n\tx2 = " + String.valueOf(x2);
        info = info + "\n\ty2 = " + String.valueOf(y2);
        
        return info;
    }

}
