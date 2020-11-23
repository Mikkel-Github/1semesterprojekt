package worldofzuul;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class StageController {

    public static String currentStage;

    // Funktion til at skifte i mellem FXML dokumenter (scener)
    // bare kald "stageController.changeScene("Navnet på FXML dokumentet");" i Controller
    public void changeScene(String sceneName) throws IOException {
        currentStage = sceneName;
        GUI.primaryStage.setTitle("World of Zuul - " + sceneName);
        Parent root = FXMLLoader.load(getClass().getResource( "windows/" + sceneName + ".fxml" ));
        GUI.primaryStage.setScene(new Scene(root, 1920, 1080));
        GUI.primaryStage.show();
    }
}
