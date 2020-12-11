package worldofzuul;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;


public class GUI extends Application {
    // Der skal ikke laves så meget i GUI
    // Hvis i skal kunne gå mellem rummene, skal i bruge Controller
        // Lave en funktion som bliver kaldt når brugeren trykker på en knap
        // Kalde "stageController.changeScene("Navnet på FXML dokumentet");" i funktionen

    static Stage primaryStage = null;
    Player playerController = new Player();

    @Override
    public void start(Stage primaryStage) throws Exception{
        playerController.resetTasks();

        GUI.primaryStage = primaryStage;

        StageController stageController = new StageController();
        stageController.changeScene("Menu");
    }
}
