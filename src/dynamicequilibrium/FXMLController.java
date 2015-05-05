/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class FXMLController implements Initializable {
    Game game
    @FXML
    private TableView<?> dataTable;
    @FXML
    private TextField addHTextBox;
    @FXML
    private TextField addHClTextBox;
    @FXML
    private TextField addNaHCO3TextBox;
    @FXML
    private TextField addC6H5O7TextBox;
    @FXML
    private TextField addHCO3TextBox;
    @FXML
    private TextField addC6H8O7TextBox;
    @FXML
    private Canvas particleCanvas;
    @FXML
    private ScatterChart<?, ?> graph;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addH(ActionEvent event) {
        
    }

    @FXML
    private void addHCl(ActionEvent event) {
    }

    @FXML
    private void addNaHCO3(ActionEvent event) {
    }

    @FXML
    private void addC6H5O7(ActionEvent event) {
    }

    @FXML
    private void addHCO3(ActionEvent event) {
    }

    @FXML
    private void addC6H8O7(ActionEvent event) {
    }
    
}
