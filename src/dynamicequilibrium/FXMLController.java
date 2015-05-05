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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class FXMLController implements Initializable {
    public Game game;
    @FXML
    private TextField addHTextBox;
    @FXML
    private Label addH;
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
    private Button pauseBtn;
    @FXML
    private ScatterChart<?, ?> graph;
    @FXML
    private TextField hTotal;
    @FXML
    private TextField hRemaining;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void initData(Game game){
        this.game = game;
    }

    @FXML
    private void addH(ActionEvent event) {
        game.addParticles("H", Integer.parseInt(addHTextBox.getText()));
    }

    @FXML
    private void addHCl(ActionEvent event) {
         game.addParticles("HCl", Integer.parseInt(addHClTextBox.getText()));
    }

    @FXML
    private void addNaHCO3(ActionEvent event) {
         game.addParticles("NaHCO3", Integer.parseInt(addNaHCO3TextBox.getText()));
    }

    @FXML
    private void addC6H5O7(ActionEvent event) {
         game.addParticles("C6H5O7", Integer.parseInt(addC6H5O7TextBox.getText()));
    }

    @FXML
    private void addHCO3(ActionEvent event) {
         game.addParticles("H", Integer.parseInt(addHTextBox.getText()));
    }

    @FXML
    private void addC6H8O7(ActionEvent event) {
         game.addParticles("C6H8O7", Integer.parseInt(addC6H8O7TextBox.getText()));
    }

    @FXML
    private void pauseSim(ActionEvent event) {
         game.pause();
    }
    
}
