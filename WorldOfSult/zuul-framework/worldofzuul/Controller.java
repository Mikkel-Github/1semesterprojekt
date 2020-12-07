package worldofzuul;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.security.PrivateKey;


import static worldofzuul.StageController.currentStage;

public class Controller {
      StageController stageController = new StageController();

    @FXML
    private ImageView startImage;
    @FXML
    private ImageView infoImage;
    @FXML
    private ImageView slutImage;
    @FXML
    private ImageView logoImage;
    @FXML
    private ImageView answerA;
    @FXML
    private ImageView answerB;
    @FXML
    private ImageView answerC;
    @FXML
    private ImageView answerD;
    @FXML
    private ImageView MandTale;
    @FXML
    private ImageView KvindeTale;
    @FXML
    private ImageView BarnTale;
    @FXML
    private Button MandSvarJa;
    @FXML
    private Button MandSvarNej;
    @FXML
    private Button KvindeSvarJa;
    @FXML
    private Button KvindeSvarNej;
    @FXML
    private Button BarnSvarJa;
    @FXML
    private Button BarnSvarNej;




    @FXML
    public void initialize() {
        if(currentStage.equals("Menu")) {
            animateLogo();
        }
        else if(currentStage.equals("Quiz")) {

        }
    }

    ///////////////////// MENU ////////////////////////
    public void startClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("Start");
        stageController.changeScene("Landsby");
    }

    public void infoClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("Info");
        stageController.changeScene("Info");
    }

    public void slutClicked(MouseEvent mouseEvent) {
        System.out.println("Slut");
        System.exit(0);
    }

    // Animations
    @FXML
    public void animationSizeBig(MouseEvent mouseEvent) {
        ImageView target = (ImageView) mouseEvent.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), target);
        st.setToX(1.2);
        st.setToY(1.2);
        st.setCycleCount(1);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();
    }

    @FXML
    public void animationSizeStandard(MouseEvent mouseEvent) {
        ImageView target = (ImageView) mouseEvent.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), target);
        st.setToX(1.0);
        st.setToY(1.0);
        st.setCycleCount(1);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();
    }

    // Menu animation
    public void animateLogo() {
        RotateTransition rt = new RotateTransition(Duration.seconds(4), logoImage);
        rt.setByAngle(30);
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setAutoReverse(true);
        rt.setInterpolator(Interpolator.EASE_BOTH);
        rt.play();
        ScaleTransition st = new ScaleTransition(Duration.seconds(2), logoImage);
        st.setByX(0.2);
        st.setByY(0.2);
        st.setCycleCount(Animation.INDEFINITE);
        st.setAutoReverse(true);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();
    }

    ///////////////////// INFO ////////////////////////
    public void backToMenu(MouseEvent mouseEvent) throws IOException {
        stageController.changeScene("Menu");
    }

    public void chooseAnswer(MouseEvent mouseEvent) {
        if(mouseEvent.getTarget() == answerA) {
            System.out.println("Player chose A");
        }
        else if(mouseEvent.getTarget() == answerB) {
            System.out.println("Player chose B");
        }
        else if(mouseEvent.getTarget() == answerC) {
            System.out.println("Player chose C");
        }
        else if(mouseEvent.getTarget() == answerD) {
            System.out.println("Player chose D");
        }
    }

    public void getMousePosition(MouseEvent mouseEvent) {
        System.out.println("X: " + mouseEvent.getX() + " Y: " + mouseEvent.getY());
    }
    ///////////////////// QUIZ /////////////////////////


@FXML
    public void MandClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("bitch");
    MandTale.setVisible(true);
    MandSvarJa.setVisible(true);
    MandSvarNej.setVisible(true);







    }

    public void KvindeClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("bitch2");
        KvindeTale.setVisible(true);
        KvindeSvarJa.setVisible(true);
        KvindeSvarNej.setVisible(true);

    }

    public void DrengClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("bitch3");
       BarnTale.setVisible(true);
       BarnSvarJa.setVisible(true);
       BarnSvarNej.setVisible(true);
    }

    public void SkiltClicked(MouseEvent mouseEvent) throws Exception{
        stageController.changeScene("Markedsplads");
    }
}
