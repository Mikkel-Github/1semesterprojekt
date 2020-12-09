package worldofzuul;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;


import static worldofzuul.StageController.currentStage;

public class Controller {
    StageController stageController = new StageController();

    Game game = new Game();
    Player playerController = new Player();


    boolean tekstfelt = false;

    boolean HarOpgave = false;

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
    private AnchorPane MandTale;
    @FXML
    private AnchorPane KvindeTale;
    @FXML
    private AnchorPane BarnTale;
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
    private Button bøfKnap;
    @FXML
    private Button fiskKnap;
    @FXML
    private Button kyllingKnap;
    @FXML
    private Button yamsKnap;
    @FXML
    private Button bananKnap;
    @FXML
    private Button kassavaKnap;
    @FXML
    private Button risKnap;



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

    @FXML
    public void animationOpacity() {
        FadeTransition ft = new FadeTransition(Duration.seconds(0.2));
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setInterpolator(Interpolator.EASE_BOTH);
        ft.play();
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

    public void Køb(MouseEvent mouseEvent) {
        if (mouseEvent.getTarget() == bøfKnap) {
            if (playerController.canPlayerBuy(50)) {
                playerController.subtractMoneyFromPlayer(50);
                playerController.addItemToInventory("Bøf");
            }
        } else if (mouseEvent.getTarget() == kyllingKnap) {
            if (playerController.canPlayerBuy(30)) {
                playerController.subtractMoneyFromPlayer(30);
                playerController.addItemToInventory("Kylling");
            }
        } else if (mouseEvent.getTarget() == fiskKnap) {
            if (playerController.canPlayerBuy(20)) {
                playerController.subtractMoneyFromPlayer(20);
                playerController.addItemToInventory("Fisk");
            }
        } else if (mouseEvent.getTarget() == yamsKnap) {
            if (playerController.canPlayerBuy(30)) {
                playerController.subtractMoneyFromPlayer(30);
                playerController.addItemToInventory("Yams");
            }
        } else if (mouseEvent.getTarget() == kassavaKnap) {
            if (playerController.canPlayerBuy(20)) {
                playerController.subtractMoneyFromPlayer(20);
                playerController.addItemToInventory("Kassava");
            }
        } else if (mouseEvent.getTarget() == risKnap) {
            if (playerController.canPlayerBuy(40)) {
                playerController.subtractMoneyFromPlayer(40);
                playerController.addItemToInventory("Ris");
            }
        } else if (mouseEvent.getTarget() == bananKnap) {
            if (playerController.canPlayerBuy(30)) {
                playerController.subtractMoneyFromPlayer(30);
                playerController.addItemToInventory("Banan");
            }
        }
    }

    ///////////////////// QUIZ /////////////////////////
    public void MandClicked(MouseEvent mouseEvent) throws Exception {
        if(HarOpgave==false){
            SkjulTale();
            MandTale.setVisible(true);
        }
    }

    public void KvindeClicked(MouseEvent mouseEvent) throws Exception {
        if(HarOpgave==false) {
            SkjulTale();
            KvindeTale.setVisible(true);
        }
    }

    public void DrengClicked(MouseEvent mouseEvent) throws Exception {
        if(HarOpgave==false) {
            SkjulTale();
            BarnTale.setVisible(true);
        }
    }

    public void SkiltClicked(MouseEvent mouseEvent) throws Exception{
        stageController.changeScene("Markedsplads");
    }


    public void SvarJaClicked(MouseEvent mouseEvent)throws Exception {
        HarOpgave=true;
        if(mouseEvent.getTarget()==MandSvarJa){
           playerController.addMoneyToPlayer(100);
        }
        else if(mouseEvent.getTarget()==KvindeSvarJa) {
            playerController.addMoneyToPlayer(0);
        }
        else if(mouseEvent.getTarget()==BarnSvarJa) {
            playerController.addMoneyToPlayer(1);
        }
        SkjulTale();
    }

    public void SkjulTale(){
        MandTale.setVisible(false);

        KvindeTale.setVisible(false);

        BarnTale.setVisible(false);
    }

    public boolean startQuiz(){
        boolean canLoadFile = false;
        Path fileName = Path.of("antalKlaredeOpgaver.txt");
        String actual = null;
        try{
            actual = Files.readString(fileName);
            canLoadFile = true;
        }
        catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }
        if(actual.equals("3")) {
            return true;
        }
        else {
            return false;
        }

    }
    public void afleverGenstande() throws IOException {
        //kode til at aflevere
        if(startQuiz() == true) {
            stageController.changeScene("Quiz");
        }
    }
}
