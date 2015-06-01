/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dynamicequilibrium;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author David
 */
public class Launcher extends Application {

    int fps = 60;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        int period = 1000 / fps;
        Game newGame = new Game(period);
        FXMLController controller = loader.<FXMLController>getController();
        controller.initData(newGame);
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Launcher.class, (java.lang.String[]) null);
    }

}
