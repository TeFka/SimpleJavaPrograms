/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabapp;

/**
 *
 * @author Dr Sendy Phang
 */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//
public class JavaLabApp extends Application{
    
    // start GUI function 
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DrawingAppGUI.fxml")); // load the fxml file
        primaryStage.setTitle("H63EEE - Lab 2 - Drawing App");
        
        // 
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    //    
    public static void main(String[] args) {
        launch(args);
    }
}


