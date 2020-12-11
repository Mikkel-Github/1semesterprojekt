package worldofzuul;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;


public class GUI extends Application {
    static Stage primaryStage = null;
    Game game = new Game();

    @Override
    public void start(Stage primaryStage) throws Exception{
        game.writeHarOpgave("");
        GUI.primaryStage = primaryStage;

        StageController stageController = new StageController();
        stageController.changeScene("Menu");
    }
}
