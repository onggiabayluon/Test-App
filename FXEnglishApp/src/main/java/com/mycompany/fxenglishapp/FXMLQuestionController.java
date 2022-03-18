/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxenglishapp;

import com.mycompany.conf.Utils;
import com.mycompany.pojo.Category;
import com.mycompany.pojo.Choice;
import com.mycompany.pojo.Question;
import com.mycompany.services.CategoryService;
import com.mycompany.services.QuestionService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class FXMLQuestionController implements Initializable {
    @FXML private ComboBox<Category> cbCategories;
    @FXML private TextField txtContent;
    @FXML private TextField txtA;
    @FXML private TextField txtB;
    @FXML private TextField txtC;
    @FXML private TextField txtD;
    @FXML private RadioButton rdoA;
    @FXML private RadioButton rdoB;
    @FXML private RadioButton rdoC;
    @FXML private RadioButton rdoD;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryService s = new CategoryService();
        try {
            this.cbCategories.setItems(FXCollections.observableList(s.getCategories()));
        } catch (SQLException ex) {
            Logger.getLogger(FXMLQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void addQuestionHandler(ActionEvent event) throws SQLException {
        Question q = new Question(
                UUID.randomUUID().toString()
                , this.txtContent.getText()
                , this.cbCategories.getSelectionModel().getSelectedItem().getId()
        );
        
        Choice choice_a = new Choice(
                UUID.randomUUID().toString()
                , this.txtA.getText()
                , this.rdoA.isSelected()
                , q.getId()
        );
        
        Choice choice_b = new Choice(
                UUID.randomUUID().toString()
                , this.txtB.getText()
                , this.rdoB.isSelected()
                , q.getId()
        );
        
        Choice choice_c = new Choice(
                UUID.randomUUID().toString()
                , this.txtC.getText()
                , this.rdoC.isSelected()
                , q.getId()
        );
        
        Choice choice_d = new Choice(
                UUID.randomUUID().toString()
                , this.txtD.getText()
                , this.rdoD.isSelected()
                , q.getId()
        );
        
        List<Choice> choices = new ArrayList<>();
        choices.add(choice_a);
        choices.add(choice_b);
        choices.add(choice_c);
        choices.add(choice_d);
        
        
        QuestionService s = new QuestionService();
        
        try {
            s.addQuestion(q, choices);
            
            Utils.getBox("Add Question successfully", Alert.AlertType.CONFIRMATION).show();
        } catch (SQLException ex) {
            Utils.getBox("Add Question failed", Alert.AlertType.WARNING).show();
        }
        
        
        
    }
}
