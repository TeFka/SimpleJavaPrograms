/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import Shapes.H63Shapes;
/**
 *
 * @author Admin
 */
public abstract class TwoDimensionalShape extends H63Shapes {
    
    private double x1,y1,w,h;
    
    private double red, green, blue, alpha;
    
    private boolean isFilled;
    
    public TwoDimensionalShape(double[] userInputs){
        
        super((int)userInputs[0]);
        
        x1 = userInputs[1];
        y1 = userInputs[2];
        w = userInputs[3];
        h = userInputs[4];
        
        if(userInputs.length>5){
            
            red = userInputs[5];
            green = userInputs[6];
            blue = userInputs[7];
            alpha = userInputs[8];
            
        }
        else{
            
            red = 220;
            green = 220;
            blue = 220;
            alpha = 1;
            
        }
        
    }
    
    public boolean getisFilled(){
        
        return isFilled;
        
    }
    
    public double getX1(){
        
        return x1;
        
    }
    
    public double getY1(){
        
        return y1;
        
    }
    
    public double getWidth(){
        
        return w;
        
    }
    
    public double getHeight(){
        
        return h;
        
    }
    
    public double getColorRed(){
        
        return red;
        
    }
    
    public double getColorGreen(){
        
        return green;
        
    }
    
    public double getColorBlue(){
        
        return blue;
        
    }
    
    public double getColorAlpha(){
        
        return alpha;
        
    }
    
    public void setisFilled(boolean newVAlue){
        
        isFilled = newVAlue;
        
    }
    
    public void setX1(double newValue){
        
        x1 = newValue;
        
    }
    
    public void setY1(double newValue){
        
        y1 = newValue;
        
    }
    
    public void setWidth(double newValue){
        
        w = newValue;
        
    }
    
    public void setHeight(double newValue){
        
        h = newValue;
        
    }
    
    public void setColorRed(double newValue){
        
        red = newValue;
        
    }
    
    public void setColorGreen(double newValue){
        
        green = newValue;
        
    }
    
    public void setColorBlue(double newValue){
        
        blue = newValue;
        
    }
    
    public void setColorAlpha(double newValue){
        
        alpha = newValue;
        
    }
}
