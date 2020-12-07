package worldofzuul;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;

import static worldofzuul.StageController.currentStage;

public class Controller {
    StageController stageController = new StageController();
    boolean tekstfelt = false;
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
    private Pane fiskTekst;
    @FXML
    private Pane kyllingTekst;
    @FXML
    private Pane bøfTekst;
    @FXML
    private Pane bananTekst;
    @FXML
    private Pane yamsTekst;
    @FXML
    private Pane risTekst;
    @FXML
    private Pane kassavaTekst;


    @FXML
    public void initialize() {
        if (currentStage.equals("Menu")) {
            animateLogo();
        } else if (currentStage.equals("Quiz")) {

        }
    }

    ///////////////////// MENU ////////////////////////
    public void startClicked(MouseEvent mouseEvent) throws Exception {
        System.out.println("Start");
        stageController.changeScene("Markedsplads");
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
        if (mouseEvent.getTarget() == answerA) {
            System.out.println("Player chose A");
        } else if (mouseEvent.getTarget() == answerB) {
            System.out.println("Player chose B");
        } else if (mouseEvent.getTarget() == answerC) {
            System.out.println("Player chose C");
        } else if (mouseEvent.getTarget() == answerD) {
            System.out.println("Player chose D");
        }
    }

    public void MarkedspladsClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("kødmarked klikket");
        stageController.changeScene("Markedsplads");
    }

    public void Skilt_kødmarkedClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("123");
        stageController.changeScene("kødMarked");
    }

    public void Skilt_frugtoggrøntClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("frugtoggrønt klikket");
        stageController.changeScene("frugtOgGrønt");
    }

    public void Skilt_MarkedspladsClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("markedspladsskilt klikket");
        stageController.changeScene("Markedsplads");
    }

    public void markedsplads_venstreClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("markedsplads klikket");
        stageController.changeScene("Markedsplads");
    }
    public void Skilt_LandsbyClicked(MouseEvent mouseEvent) throws IOException {
        System.out.println("Landsby klikket");
        stageController.changeScene("Landsby");
    }

    public void FiskClicked(MouseEvent mouseEvent) {

        if (tekstfelt == false) {
            fiskTekst.setVisible(true);
            tekstfelt = true;
        } else {
            fiskTekst.setVisible(false);
            tekstfelt = false;
        }

    }

    public void KyllingClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            kyllingTekst.setVisible(true);
            tekstfelt = true;
        } else {
            kyllingTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    public void BøfClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            bøfTekst.setVisible(true);
            tekstfelt = true;
        } else {
            bøfTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    public void bananClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            bananTekst.setVisible(true);
            tekstfelt = true;
        } else {
            bananTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    public void YamsClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            yamsTekst.setVisible(true);
            tekstfelt = true;
        } else {
            yamsTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    public void RisClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            risTekst.setVisible(true);
            tekstfelt = true;
        } else {
            risTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    public void KassavaClicked(MouseEvent mouseEvent) {
        if (tekstfelt == false) {
            kassavaTekst.setVisible(true);
            tekstfelt = true;
        } else {
            kassavaTekst.setVisible(false);
            tekstfelt = false;
        }
    }

    ///////////////////// QUIZ /////////////////////////







}
