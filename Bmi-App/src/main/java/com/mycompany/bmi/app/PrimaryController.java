package com.mycompany.bmi.app;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class PrimaryController {

    @FXML private TextField txtWeight;
    @FXML private TextField txtHeight;
    @FXML private Label lblResult;
    // Continue...
    
    public void bmiHandler(ActionEvent event) {
        double height = Double.parseDouble(this.txtHeight.getText());
        double weight = Double.parseDouble(this.txtWeight.getText());
        double bmi = weight / Math.pow(height, 2);
        
        this.lblResult.setTextFill(Color.DARKBLUE);
        if (bmi < 18.5) {
            this.lblResult.setText("Gầy độ I");
        } else if (bmi < 25) {
            this.lblResult.setText("Bình thường");
        } else {
            this.lblResult.setTextFill(Color.RED);
            this.lblResult.setText("Thừa cân");
        }
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
