package com.mycompany.test.app;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    private void btnCong_Click(object sender, EventArgs e)
    {
     if (txtA.Text != String.Empty)
     {
     double a = double.Parse(txtA.Text);
     double b = double.Parse(txtB.Text);
     double c = a + b;
     txtKetQua.Text = c.ToString();
     }
    }
}
