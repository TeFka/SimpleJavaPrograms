/*
 * Container for shapes of drawing app
 */
package Shapes;

import java.util.ArrayList; // import the ArrayList class
import javafx.scene.canvas.GraphicsContext;

import Utilities.DrawUtils;

/**
 * @author Dr Sendy Phang
 */
public class H63ShapeContainer {
    
    // use of abstract class H63Shapes makes this possible
    private ArrayList<H63Shapes> myShapeList;
    
    // to get the number of shape stored in the container
    public int getNoShapes(){
        return myShapeList.size() ;
    }
    
    // to wrap the printShapeDetail() as myShapeList is private
    public String getShapeInfo(int ID){
        return myShapeList.get(ID).printShapeDetail();
    }
    
    // to clear the container as myShapeList is private
    public void clearContainer(){
        myShapeList.clear();
    }
    
    // to remove the last shape -- for undo button
    public void removeLastShape(){
        myShapeList.remove(getNoShapes()-1);
    }
    
    // just to wrap the draw method as myShapeList is private
    public void drawWrapper(int indexInContainer, 
                                   GraphicsContext gc){
        myShapeList.get(indexInContainer).draw(gc);
    }
    
    // constructor
    public H63ShapeContainer(){
         myShapeList = new ArrayList<>();
    }
    

    // to make, save it in the container and draw a new shape
    public void make(String shapeStyle,
                            String userInputData,
                            GraphicsContext gc)   {
        
        // convert UserInputData from string to array
        double[] userInputDataDouble = DrawUtils.readStringInfo(userInputData);
        
         // add the ID to the input array
        double[] userInputDataDoublewithID = new double[userInputDataDouble.length+1];
        int sizenow = myShapeList.size();
        userInputDataDoublewithID[0] = myShapeList.size() + 1;

        // copy the content of the each array to the new array
        for(int i=0;i<userInputDataDouble.length;i++){
            userInputDataDoublewithID[i+1] = userInputDataDouble[i];
        }
        
        // if line shape
        if(shapeStyle.equals(H63Shapes.shapeStyle.LineShape.toString())){
            // use UPCATING to make and draw the new line shape
            myShapeList.add(new LineShape(userInputDataDoublewithID));
            myShapeList.get(myShapeList.size()-1).draw(gc);
        }
        
        // if rectangle shape
        if(shapeStyle.equals(H63Shapes.shapeStyle.RectangleShape.toString())){
            // DO SOMETHING HERE IF IT IS RECTANGLE SHAPE
        }
        
                
        
        // For future development
        
    }
    
}
