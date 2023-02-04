import java.util.*;
import java.util.ArrayList; // import the ArrayList class
import Shapes.H63Shapes;    // to use the class defined in the h63eeedrawingapp package 
import Shapes.LineShape;
import Shapes.RectangleShape;
import Shapes.EllipseShape;

public class driver_lab2 {
    public static void main(String args[]){

        ArrayList<H63Shapes> myShapeList = new ArrayList<>();

        // add line to myShapeList
        double[] lineParam = {1,100,200,300,500};
        myShapeList.add(new LineShape(lineParam));  // this line will have ID 1
                                                    // starting coordinate (100,200)
                                                    // end coordinate (300,500)   

        // add rectangle to myShapeList
        double[] rectParam1 = {2,300,150,400,100};
        myShapeList.add(new RectangleShape(rectParam1)); // this rect will have ID 2
                                                         // centre coordinate (300,150)
                                                         // width: 400   
                                                         // height: 100
   
        // add coloured rectangle to myShapeList
        double[] rectParam2 = {3,300,50,400,100,220,0,220,1};
        myShapeList.add(new RectangleShape(rectParam2)); // this rect will have ID 3
                                                         // centre coordinate (300,100)
                                                         // width: 400   
                                                         // height: 100
                                                         // red colour: 220
                                                         // green colour: 0
                                                         // blue colour: 220
                                                         // alpha: 1

        // add coloured ellipse to myShapeList
        double[] ellParam = {4,600,500,100,200,0,220,0,0.5};
        myShapeList.add(new EllipseShape (ellParam));    // this ellipse will have ID 4
                                                         // centre coordinate (600,500)
                                                         // width: 100   
                                                         // height: 200
                                                         // red colour: 0
                                                         // green colour: 220
                                                         // blue colour: 0
                                                         // alpha: 0.5 (semi-transparent)

        // add circle to myShapeList
        // I believe you can come up with an example . . .  

        // print out information 
        Iterator<H63Shapes> myIter = myShapeList.iterator();
        while(myIter.hasNext()){
             System.out.print (myIter.next().printShapeDetail());
        }

    }
}
