/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author pmzsp1
 */
public abstract class H63Shapes {
    
    // enum for different type of shapes 
    public static enum shapeStyle{LineShape,RectangleShape};
    
    private int id; // to tag the shape 
    
    // get and sets
    public int getID(){return id;}
    public final void setID(int _id){ 
        id = _id;
    }
    
    
    // constructor
    public H63Shapes(int _id){
        setID(_id);
    }
    
    
    // abstract method 
    // YOU CAN'T IMPLEMENT THIS METHOD HERE
    // IT MUST BE OVERRIDE BY CHILD
    public abstract String printShapeDetail( );  // to get the detail
    public abstract void draw(GraphicsContext gc); // to draw the shape

}
