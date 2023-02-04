/**
 * This is the 'DrawingAppGUI.fxml' Controller Class
 */

package Shapes;

//==============================================================================
/* Import only package you need. 
Try to use already made package 
DO NOT WASTE YOUR TIME REINVENT AGAIN 
*/
//==============================================================================

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javafx.scene.control.Tab;


//==============================================================================
/* This is the controller class for DrawingAppGUI fxml
Try your best to keep this file clean and tidy 
the purpose of controller file is to control the fxml, manage the input & output
complex instructions should be located elsewhere
*/
//==============================================================================
public class DrawingAppGUIController {
    
    // =========================================================================
    /*
    private variables needed for our drawing app 
    ElementaryShapeDrawing will serve as container for the elementary shape drawing
    FreeFormDrawing will serve as container for the free form drawing
    tipSizeFreeForm is used in the free form drawing to determine the size of the pen
    */
    // =========================================================================
    private H63ShapeContainer ElementaryShapeDrawing;
    // ADD YOUR VARIABLE HERE IF NEED ANY
    
    // =========================================================================
    /*
    Define the alias of our GUI elements
    */
    // =========================================================================
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    
    @FXML // fx:id="myDrawingCanvas"
    private Canvas myDrawingCanvas;
    
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="SaveButton"
    private Button SaveButton; // Value injected by FXMLLoader

    @FXML // fx:id="LoadButton"
    private Button LoadButton; // Value injected by FXMLLoader

    @FXML // fx:id="ClearAllButton"
    private Button ClearAllButton; // Value injected by FXMLLoader

    @FXML // fx:id="UndoButton"
    private Button UndoButton; // Value injected by FXMLLoader

    @FXML // fx:id="ShapeOptionChooseList"
    private ComboBox<String> ShapeOptionChooseList; // Value injected by FXMLLoader

    @FXML // fx:id="ShapeOptionInputArea"
    private TextArea ShapeOptionInputArea; // Value injected by FXMLLoader
    
    @FXML // fx:id="shapeInfoArea"
    private TextArea shapeInfoArea; // Value injected by FXMLLoader

    @FXML // fx:id="AddShapeButton"
    private Button AddShapeButton; // Value injected by FXMLLoader

    @FXML // fx:id="ShapeObjectListDisplay"
    private TextArea ShapeObjectListDisplay; // Value injected by FXMLLoader
    
    @FXML // fx:id="ElemntaryShapeTab"
    private Tab ElementaryShapeTab; // Value injected by FXMLLoader
    
  

    // =========================================================================
    /*
    This is the constructor of our drawing app... 
    we need constructor here to initialise our member variable
    if there is no member variable... we don't need constructor
    */
    // =========================================================================
    public DrawingAppGUIController(){
        ElementaryShapeDrawing = new H63ShapeContainer(); 
        
    }
    
    // =========================================================================
    /*
    The initialize() method is called to initialise our GUI... 
    Also used in defining change listener... 
    We use change listener in our app for chosing the shape in the elementary drawing
    */
    // =========================================================================
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        
        assert ElementaryShapeTab != null : "fx:id=\"ElemntaryShapeTab\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        
        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert LoadButton != null : "fx:id=\"LoadButton\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert ClearAllButton != null : "fx:id=\"ClearAllButton\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert UndoButton != null : "fx:id=\"UndoButton\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert ShapeOptionChooseList != null : "fx:id=\"ShapeOptionChooseList\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert ShapeOptionInputArea != null : "fx:id=\"ShapeOptionInputArea\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert AddShapeButton != null : "fx:id=\"AddShapeButton\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert ShapeObjectListDisplay != null : "fx:id=\"ShapeObjectListDisplay\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert shapeInfoArea != null : "fx:id=\"shapeInfoArea\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        assert myDrawingCanvas != null : "fx:id=\"myDrawingCanvas\" was not injected: check your FXML file 'DrawingAppGUI.fxml'.";
        
        // make border for canvas
        GraphicsContext myDrawingCanvas_gc = myDrawingCanvas.getGraphicsContext2D(); 
        makeBorderOnCanvas(myDrawingCanvas_gc);
        
        // initialise some information 
        String notes = "Canvas size " + String.valueOf(myDrawingCanvas.getWidth()) + " x " + String.valueOf(myDrawingCanvas.getHeight()); 
        ShapeObjectListDisplay.appendText(notes+"\n");
        
        // Add options to the ShapeOptionChooseList
        H63Shapes.shapeStyle[] allShapes = H63Shapes.shapeStyle.class.getEnumConstants(); // get all shape styles 
        ObservableList shapeList = FXCollections.observableArrayList( allShapes[0].toString() );
        
        ShapeOptionChooseList.setItems(shapeList); // add the 1st shape
        // add the rest of shape
        for(int i=1; i<allShapes.length; i++){
            ShapeOptionChooseList.getItems().addAll(allShapes[i].toString());
        }
        
        //======================================================================
        /*
        Listen for combobox value changes
        Here, we have used Anonymous Inner Class for Event Handling 
        ChangeListener is a generic type that's specialised with the property's type. 
        This particular section will return String which is the value of the ChoiseList
        */
        //======================================================================
        ShapeOptionChooseList.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, 
                                String newValue) {

                //shapeInfoArea.setText(newValue + "\n");
                if(newValue.equals("LineShape")){
                    shapeInfoArea.setText("x1;y1;x2;y2;\n");
                }
                if(newValue.equals("RectangleShape")){
                    String textGuide = "x0;y0;Width;Height;\nor \n"; 
                    textGuide = textGuide + "x0;y0;Width;Height;Red;Green;Blue;Alpha;\n"; 
                    textGuide = textGuide + "where (x0;y0) is the centre";
                    shapeInfoArea.setText(textGuide);
                }
                
            }
        });
        

    }
    
    //==========================================================================
    /**
     * if ElementaryShapeTabClicked DO NOTHING AT THE MOMENT 
     */
    //==========================================================================
    @FXML
    void ElementaryShapeTabClicked( ) {
        // DO NOTHING
    }
    
    //==========================================================================
    /**
     * if FreeFormTabClicked DO NOTHING AT THE MOMENT 
     */
    //==========================================================================
    @FXML
    void FreeFormTabClicked( ) {
        // DO NOTHING
    }
    
    //==========================================================================
    /**
     * use this method to make border on canvas
       it will need graphic context argument
     * @param gc is the graphic context to a particular canvas
     */
    //==========================================================================
    void makeBorderOnCanvas(GraphicsContext gc){
        
        //
        gc.strokeLine(0, 0, gc.getCanvas().getWidth(), 0);
        gc.strokeLine(0, 0, 0, gc.getCanvas().getHeight());
        gc.strokeLine(0, gc.getCanvas().getHeight(), gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.strokeLine(gc.getCanvas().getWidth(), gc.getCanvas().getHeight(), gc.getCanvas().getWidth(), 0);
        
    }
    
    //==========================================================================
    /**
     * if add shape button is clicked
     */
    //==========================================================================
    @FXML
    void addShapeButtonClicked() {
        
        // get the canvas handler
        GraphicsContext gc = myDrawingCanvas.getGraphicsContext2D(); 
        
        //
        String userShapeStyleInput = ShapeOptionChooseList.getValue(); // retrieve the sytle of shape
        String userShapeInput = ShapeOptionInputArea.getText(); // retrieve the user data input reg. shape
         
        // send this information to H63ShapeContainer
        ElementaryShapeDrawing.make(userShapeStyleInput,userShapeInput,gc);
        
        //
        int currentShapeIndex = ElementaryShapeDrawing.getNoShapes()-1;
        ShapeObjectListDisplay.appendText(ElementaryShapeDrawing.getShapeInfo(currentShapeIndex) + "\n");
        
    }
             
    //==========================================================================
    /**
     * if clear button in elementary shape is clicked
     */
    //==========================================================================
    @FXML
    void clearAllButtonClicked() {
        
        // get the canvas handler 
        GraphicsContext gc = myDrawingCanvas.getGraphicsContext2D();
        
        // clear canvas
        clearAllAction (gc);
        
        // clear text in object list and add the initial info
        ShapeObjectListDisplay.clear();
        
        String notes = "Canvas size " + String.valueOf(myDrawingCanvas.getWidth()) + " x " + String.valueOf(myDrawingCanvas.getHeight()); 
        ShapeObjectListDisplay.appendText(notes+"\n");
        
        makeBorderOnCanvas(gc);// also reborder
        
        // also have to clear the container 
        ElementaryShapeDrawing.clearContainer();
        
    }
    
    //==========================================================================
    /**
     * clear button general action 
     * @param gc this particular canvas will be cleared
     */
    //==========================================================================
    void clearAllAction (GraphicsContext gc){
        
        // clear canvas
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        
    }
    
    //==========================================================================
    /**
     * if undo button in the elementary shape is clicked
     */
    //==========================================================================
    @FXML
    void undoButtonClicked() {
        
        if(ElementaryShapeDrawing.getNoShapes()>0) {
            // delete the last shape in the container 
            ElementaryShapeDrawing.removeLastShape();

            // clear text in object list and add the initial info
            ShapeObjectListDisplay.clear();

            String notes = "Canvas size " + String.valueOf(myDrawingCanvas.getWidth()) + " x " + String.valueOf(myDrawingCanvas.getHeight()); 
            ShapeObjectListDisplay.appendText(notes+"\n"); 

            // draw again from top
            GraphicsContext gc = myDrawingCanvas.getGraphicsContext2D(); // get the canvas handler
            gc.clearRect(0, 0,myDrawingCanvas.getWidth(), myDrawingCanvas.getHeight());// clear canvas
            makeBorderOnCanvas(gc);// also reborder

            for(int eShape=0; eShape < ElementaryShapeDrawing.getNoShapes(); eShape++){
                ElementaryShapeDrawing.drawWrapper(eShape, gc);
                ShapeObjectListDisplay.appendText(ElementaryShapeDrawing.getShapeInfo(eShape) + "\n");
            }
        }
    }
    
    //==========================================================================
    /**
     * if save button is clicked
     * @throws Exception if file is not chosen correctly
     */
    //==========================================================================
     @FXML
    void SaveButtonClicked() throws Exception {
        
        // WRITE HERE FOR SAVE BUTTON EVENT HANDLER
        
    }
    
    //==========================================================================
    /**
     * if load button is clicked
     */
    //==========================================================================
    @FXML
    void LoadButtonClicked() {
        
        // WRITE HERE FOR LOAD BUTTON EVENT HANDLER
        
    }
    
    
   // USE AREA BELOW FOR FUTURE DEVELOPMENT
   // .........

    
    
    
    
    
}
