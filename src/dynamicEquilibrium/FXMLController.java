         /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicequilibrium;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
    private Button pauseBtn;
    @FXML
    private Label hTotal;
    @FXML
    private Label hRemaining;
    @FXML
    private Label hclTotal;
    @FXML
    private Label hclRemaining;
    @FXML
    private Label nahco3Total;
    @FXML
    private Label nahco3Remaining;
    @FXML
    private Label c6h5o7Total;
    @FXML
    private Label c6h5o7Remaining;
    @FXML
    private Label c6h8o7Total;
    @FXML
    private Label c6h8o7Remaining;
    @FXML
    private Label pHandCl;
    @FXML
    private Slider pHandClSlider;
    @FXML
    private Slider pHClSlider;
    @FXML
    private Label pHCl;
    @FXML
    private Slider pHandHCO3Slider;
    @FXML
    private Slider pNaHCO3Slider;
    @FXML
    private Slider pNaandHCO3Slider;
    @FXML
    private Label pHandHCO3;
    @FXML
    private Label pNaandHCO3;
    @FXML
    private Label pNaHCO3;
    @FXML
    private Button clearBtn;
    @FXML
    private Button helpBtn;
    @FXML
    private Label H2OTotal;
    @FXML
    private Label H2ORemaining;
    @FXML
    private Label c6h7o7Total;
    @FXML
    private Label c6h7o7Remaining;
    @FXML
    private Label c6h6o7Total;
    @FXML
    private Label c6h6o7Remaining;
    @FXML
    private Label pHandC6HxO7;
    @FXML
    private Slider pHandC6HxO7Slider;
    @FXML
    private Slider pC6HxO7Slider;
    @FXML
    private Label pC6HxO7;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    public void initData(Game game){
        this.game = game;
        hTotal.textProperty().bind(game.engine.substanceTotals.get("H"));
        hclTotal.textProperty().bind(game.engine.substanceTotals.get("HCl")); 
        nahco3Total.textProperty().bind(game.engine.substanceTotals.get("NaHCO3")); 
        //c6h5o7Total.textProperty().bind(game.engine.substanceTotals.get("C6H5O7")); 
        c6h8o7Total.textProperty().bind(game.engine.substanceTotals.get("C6H8O7")); 
        c6h5o7Total.textProperty().bind(game.engine.substanceTotals.get("C6H5O7")); 
        c6h6o7Total.textProperty().bind(game.engine.substanceTotals.get("C6H6O7")); 
        c6h7o7Total.textProperty().bind(game.engine.substanceTotals.get("C6H7O7")); 
        hRemaining.textProperty().bind(game.engine.substanceCounts.get("H")); 
        hclRemaining.textProperty().bind(game.engine.substanceCounts.get("HCl")); 
        nahco3Remaining.textProperty().bind(game.engine.substanceCounts.get("NaHCO3")); 
        //c6h5o7Remaining.textProperty().bind(game.engine.substanceCounts.get("C6H5O7")); 
        c6h8o7Remaining.textProperty().bind(game.engine.substanceCounts.get("C6H8O7")); 
        c6h7o7Remaining.textProperty().bind(game.engine.substanceCounts.get("C6H7O7")); 
        c6h6o7Remaining.textProperty().bind(game.engine.substanceCounts.get("C6H6O7")); 
        c6h5o7Remaining.textProperty().bind(game.engine.substanceCounts.get("C6H5O7")); 
        H2ORemaining.textProperty().bind(game.engine.substanceCounts.get("H2O")); 
        H2OTotal.textProperty().bind(game.engine.substanceTotals.get("H2O"));
        
        //Initial values for sliders were set in Scene Builder
        //Initial values for labels showing slider values are copied from corresponding slider valueProperties.
        pHCl.setText(String.format("%.4f", pHClSlider.valueProperty().get()/1000));
        pHClSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pHCl.setText(String.format("%.4f", p));
                    HCl.pHCl = p;
            }
        });
        
       // pHCl.textProperty().bind(pHClSlider.valueProperty().divide(1000).asString()); 
        
        pHandCl.setText(String.format("%.4f", pHandClSlider.valueProperty().get()/1000));
        pHandClSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pHandCl.setText(String.format("%.4f", p));
                    H.pHandCl = p;
            }
        });
        
        pHandHCO3.setText(String.format("%.4f", pHandHCO3Slider.valueProperty().get()/1000));
        pHandHCO3Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pHandHCO3.setText(String.format("%.4f", p));
                    H.pHandHCO3 = p;
            }
        });
        
        pNaHCO3.setText(String.format("%.4f", pNaHCO3Slider.valueProperty().get()/1000));
        pNaHCO3Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pNaHCO3.setText(String.format("%.4f", p));
                    NaHCO3.pNaHCO3 = p;
            }
        });
        
        pNaandHCO3.setText(String.format("%.4f", pNaandHCO3Slider.valueProperty().get()/1000));
        pNaandHCO3Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pNaandHCO3.setText(String.format("%.4f", p));
                    Na.pNaandHCO3 = p;
            }
        });
        
        pHandC6HxO7.setText(String.format("%.4f", pHandC6HxO7Slider.valueProperty().get()/1000));
        pHandC6HxO7Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pHandC6HxO7.setText(String.format("%.4f", p));
                    H.pHandC6HxO7 = p;
            }
        });
        
        pC6HxO7.setText(String.format("%.4f", pC6HxO7Slider.valueProperty().get()/1000));
        pC6HxO7Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                double p = new_val.doubleValue()/1000;
                    pC6HxO7.setText(String.format("%.4f", p));
                    C6H8O7.pC6H8O7 = p;
                    C6H7O7.pC6H7O7 = p;
                    C6H6O7.pC6H6O7 = p;
            }
        });
        
        
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
         System.out.println("pause btn");
    }
    
    @FXML
    private void clearSim(ActionEvent event) {
         game.engine.clearParticles();
         System.out.println("clear btn");
    }

    @FXML
    private void displayHelp(ActionEvent event) {
        System.out.println("Help!");
    }
    
}
