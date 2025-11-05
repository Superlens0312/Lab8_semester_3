/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class FXMLController {
 @FXML
    private RadioButton blackRadioButton;
    @FXML
    private RadioButton blueRadioButton;
    @FXML
    private Button clearButton;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton greenRadioButton;
    @FXML
    private RadioButton largeRadioButton;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton redRadioButton;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton smallRadioButton;
    @FXML
    private Button undoButton;
    
    private PenSize radius = PenSize.SMALL;
    private Paint brushColor = Color.BLACK;
    
    public void initialize(){
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        blueRadioButton.setUserData(Color.BLUE);
        greenRadioButton.setUserData(Color.GREEN);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }
    
    private enum PenSize {
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {this.radius = radius;}
        
        public int getRadius() {return radius;} 
    };
    
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle pen = new Circle();
        pen.setCenterX(event.getX());
        pen.setCenterY(event.getY());
        pen.setRadius(radius.getRadius());
        pen.setFill(brushColor);
       
        drawingAreaPane.getChildren().add(pen);
    } 
    
    @FXML
    void colorRadioButtonSelected(ActionEvent event) {
        Toggle selectedToggle = colorToggleGroup.getSelectedToggle();
    
        if (selectedToggle != null) {
            // Each color RadioButton has a Color stored as its user data
            brushColor = (Color) selectedToggle.getUserData();
        }
    } 
    
    @FXML
    void sizeRadioButtonSelected(ActionEvent event) {
        // Get the selected toggle (RadioButton) from the size group
        Toggle selectedToggle = sizeToggleGroup.getSelectedToggle();

        if (selectedToggle != null) {
        // Each size RadioButton has a PenSize stored as its user data
        radius = (PenSize) selectedToggle.getUserData();
        }
    }  
   
    @FXML
    void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size(); // how many circles are on the pane

        if (count > 0) {
            // remove the last added circle (the most recent one)
            drawingAreaPane.getChildren().remove(count - 1);
        }
    }  
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
        // Remove all circles from the drawing area
      drawingAreaPane.getChildren().clear();
    }
}


