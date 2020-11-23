package worldofzuul;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class GUI extends Application {
    // Der skal ikke laves så meget i GUI
    // Hvis i skal kunne gå mellem rummene, skal i bruge Controller
        // Lave en funktion som bliver kaldt når brugeren trykker på en knap
        // Kalde "stageController.changeScene("Navnet på FXML dokumentet");" i funktionen

    static Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        GUI.primaryStage = primaryStage;
        GUI.primaryStage.initStyle(StageStyle.UNDECORATED);
        GUI.primaryStage.setX(0);
        GUI.primaryStage.setY(0);

        StageController stageController = new StageController();
        stageController.changeScene("Menu");
    }
}
