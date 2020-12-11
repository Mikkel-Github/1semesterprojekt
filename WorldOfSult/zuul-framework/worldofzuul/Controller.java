package worldofzuul;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;
import java.util.ArrayList;


import static worldofzuul.StageController.currentStage;

public class Controller {
    StageController stageController = new StageController();

    Game game = new Game();
    Player playerController = new Player();

    boolean inventoryOpen = false;

    String inventoryMarkedItem;

    ImageView shownMarker = null;

    @FXML
    private ImageView logoImage;
    @FXML
    private AnchorPane MandTale;
    @FXML
    private AnchorPane KvindeTale;
    @FXML
    private AnchorPane BarnTale;
    @FXML
    private ImageView MandSvarJa;
    @FXML
    private ImageView MandSvarNej;
    @FXML
    private ImageView KvindeSvarJa;
    @FXML
    private ImageView KvindeSvarNej;
    @FXML
    private ImageView BarnSvarJa;
    @FXML
    private ImageView BarnSvarNej;
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
    private ImageView bøfKnap;
    @FXML
    private ImageView fiskKnap;
    @FXML
    private ImageView kyllingKnap;
    @FXML
    private ImageView yamsKnap;
    @FXML
    private ImageView bananKnap;
    @FXML
    private ImageView kassavaKnap;
    @FXML
    private ImageView risKnap;
    @FXML
    private Pane inventoryBox;
    @FXML
    private Text playerBalance;
    @FXML
    private Text playerBalanceKødMarked;
    @FXML
    private Text priceText;
    @FXML
    private Text informationText;
    @FXML
    private ImageView c0r0Marker;
    @FXML
    private ImageView c1r0Marker;
    @FXML
    private ImageView c2r0Marker;
    @FXML
    private ImageView c0r1Marker;
    @FXML
    private ImageView c1r1Marker;
    @FXML
    private ImageView c2r1Marker;
    @FXML
    private ImageView c0r2Marker;
    @FXML
    private ImageView c1r2Marker;
    @FXML
    private ImageView c2r2Marker;
    @FXML
    private ImageView c0r0Item;
    @FXML
    private ImageView c1r0Item;
    @FXML
    private ImageView c2r0Item;
    @FXML
    private ImageView c0r1Item;
    @FXML
    private ImageView c1r1Item;
    @FXML
    private ImageView c2r1Item;
    @FXML
    private ImageView c0r2Item;
    @FXML
    private ImageView c1r2Item;
    @FXML
    private ImageView c2r2Item;
    @FXML
    private Button mandAflever;
    @FXML
    private Button kvindeAflever;
    @FXML
    private Button barnAflever;
    @FXML
    private Text mandTekst;
    @FXML
    private Text kvindeTekst;
    @FXML
    private Text barnTekst;

    @FXML
    public void initialize() {
        if(currentStage.equals("Menu")) {
            animateLogo();
            playerController.resetTasks();
        }
        else if(currentStage.equals("kødMarked") || currentStage.equals("frugtOgGrønt")) {
            playerBalanceKødMarked.setText("Penge: " + playerController.getPlayerBalance());
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
        hideFoodBox();
        fiskTekst.setVisible(true);
    }

    public void KyllingClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        kyllingTekst.setVisible(true);
    }

    public void BøfClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        bøfTekst.setVisible(true);
    }

    public void bananClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        bananTekst.setVisible(true);
    }

    public void YamsClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        yamsTekst.setVisible(true);
    }

    public void RisClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        risTekst.setVisible(true);
    }

    public void KassavaClicked(MouseEvent mouseEvent) {
        hideFoodBox();
        kassavaTekst.setVisible(true);
    }

    public void hideFoodBox() {
        informationText.setVisible(false);
        if(fiskTekst != null) {
            if(fiskTekst.isVisible()) {
                fiskTekst.setVisible(false);
            }
            if(kyllingTekst.isVisible()) {
                kyllingTekst.setVisible(false);
            }
            if(bøfTekst.isVisible()) {
                bøfTekst.setVisible(false);
            }
        }
        if(bananTekst != null) {
            if(bananTekst.isVisible()) {
                bananTekst.setVisible(false);
            }
            if(yamsTekst.isVisible()) {
                yamsTekst.setVisible(false);
            }
            if(risTekst.isVisible()) {
                risTekst.setVisible(false);
            }
            if(kassavaTekst.isVisible()) {
                kassavaTekst.setVisible(false);
            }
        }
    }

    public void Køb(MouseEvent mouseEvent) {
        informationText.setVisible(false);
        String amount = "";
        if (mouseEvent.getTarget() == bøfKnap) {
            if (playerController.canPlayerBuy(50)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(50);
                    playerController.addItemToInventory("Bøf");
                    amount = "50";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == kyllingKnap) {
            if (playerController.canPlayerBuy(30)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(30);
                    playerController.addItemToInventory("Kylling");
                    amount = "30";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == fiskKnap) {
            if (playerController.canPlayerBuy(20)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(20);
                    playerController.addItemToInventory("Fisk");
                    amount = "20";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == yamsKnap) {
            if (playerController.canPlayerBuy(30)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(30);
                    playerController.addItemToInventory("Yams");
                    amount = "30";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == kassavaKnap) {
            if (playerController.canPlayerBuy(20)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(20);
                    playerController.addItemToInventory("Kassava");
                    amount = "20";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == risKnap) {
            if (playerController.canPlayerBuy(40)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(40);
                    playerController.addItemToInventory("Ris");
                    amount = "40";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        } if (mouseEvent.getTarget() == bananKnap) {
            if (playerController.canPlayerBuy(30)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(30);
                    playerController.addItemToInventory("Banan");
                    amount = "30";
                    opdaterInventory();
                }
                else{
                    informationText.setText("Du har ikke plads til mere");
                    informationText.setVisible(true);
                }
            }
            else {
                informationText.setText("Du har ikke råd");
                informationText.setVisible(true);
            }
        }
        playerBalanceKødMarked.setText("Penge: " + playerController.getPlayerBalance());
        priceText.setText(amount);
        // Animation af prisen som bliver trukket fra
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), priceText);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setAutoReverse(true);
        ft.setCycleCount(2);
        ft.setInterpolator(Interpolator.EASE_BOTH);

        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), priceText);
        tt.setFromY(0.0);
        tt.setToY(-50.0);
        tt.setInterpolator(Interpolator.EASE_OUT);

        tt.play();
        ft.play();
    }

    ///////////////////// QUIZ /////////////////////////
    public void MandClicked(MouseEvent mouseEvent) throws Exception {
        boolean isDone = false;
        for(String s : getKlaredeOpgaver()) {
            if(s.equals("mand")) {
                isDone = true;
            }
        }
        if(!isDone) {
            if(game.checkHarOpgave().equals("mand")) {
                SkjulTale();
                MandTale.setVisible(true);
                MandSvarJa.setVisible(false);
                MandSvarNej.setVisible(false);
                mandAflever.setVisible(true);
                mandTekst.setText("Har du købt det?");
            }
            else if(game.checkHarOpgave().equals("")){
                SkjulTale();
                MandTale.setVisible(true);
                MandSvarJa.setVisible(true);
                MandSvarNej.setVisible(true);
                mandAflever.setVisible(false);
                mandTekst.setText("Jeg mangler en fisk. Vil du hjælpe mig?");
            }
        }
    }

    public void KvindeClicked(MouseEvent mouseEvent) throws Exception {
        boolean isDone = false;
        for(String s : getKlaredeOpgaver()) {
            if(s.equals("kvinde")) {
                isDone = true;
            }
        }
        if(!isDone) {
            if(game.checkHarOpgave().equals("kvinde")) {
                SkjulTale();
                KvindeTale.setVisible(true);
                KvindeSvarJa.setVisible(false);
                KvindeSvarNej.setVisible(false);
                kvindeAflever.setVisible(true);
                kvindeTekst.setText("Har du købt det?");
            }
            else if(game.checkHarOpgave().equals("")){
                SkjulTale();
                KvindeTale.setVisible(true);
                KvindeSvarJa.setVisible(true);
                KvindeSvarNej.setVisible(true);
                kvindeAflever.setVisible(false);
                kvindeTekst.setText("Jeg mangler en banan. Vil du hjælpe mig?");
            }
        }
    }

    public void DrengClicked(MouseEvent mouseEvent) throws Exception {
        boolean isDone = false;
        for(String s : getKlaredeOpgaver()) {
            if(s.equals("barn")) {
                isDone = true;
            }
        }
        if(!isDone) {
            if(game.checkHarOpgave().equals("dreng")) {
                SkjulTale();
                BarnTale.setVisible(true);
                BarnSvarJa.setVisible(false);
                BarnSvarNej.setVisible(false);
                barnAflever.setVisible(true);
                barnTekst.setText("Har du købt det?");
            }
            else if(game.checkHarOpgave().equals("")){
                SkjulTale();
                BarnTale.setVisible(true);
                BarnSvarJa.setVisible(true);
                BarnSvarNej.setVisible(true);
                barnAflever.setVisible(false);
                barnTekst.setText("Jeg mangler en pose ris. Vil du hjælpe mig?");
            }
        }
    }

    public void SkiltClicked(MouseEvent mouseEvent) throws Exception{
        stageController.changeScene("Markedsplads");
    }


    public void SvarJaClicked(MouseEvent mouseEvent)throws Exception {
        if(mouseEvent.getTarget()==MandSvarJa){
           playerController.addMoneyToPlayer(100);
           game.writeHarOpgave("mand");
           MandSvarJa.setVisible(false);
           MandSvarNej.setVisible(false);
        }
        else if(mouseEvent.getTarget()==KvindeSvarJa) {
            playerController.addMoneyToPlayer(100);
            game.writeHarOpgave("kvinde");
            KvindeSvarJa.setVisible(false);
            KvindeSvarNej.setVisible(false);
        }
        else if(mouseEvent.getTarget()==BarnSvarJa) {
            playerController.addMoneyToPlayer(100);
            game.writeHarOpgave("dreng");
            BarnSvarJa.setVisible(false);
            BarnSvarNej.setVisible(false);
        }
        SkjulTale();
    }

    public void SkjulTale(){
        MandTale.setVisible(false);

        KvindeTale.setVisible(false);

        BarnTale.setVisible(false);
    }

    public ArrayList<String> getKlaredeOpgaver() {
        Path fileName = Path.of("antalKlaredeOpgaver.txt");
        String actual = null;
        try {
            actual = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't load file");
        }
        System.out.println("Opgaver lavet: " + actual);

        ArrayList<String> tasksDone = new ArrayList<String>();
        // Set Questions and Answers up in a list
        String[] tasksDoneList = actual.split(",");
        for (String s : tasksDoneList) {
            System.out.println(s);
            tasksDone.add(s);
        }

        return tasksDone;
    }

    public void afleverGenstande(MouseEvent mouseEvent) throws IOException {
        if(!inventoryOpen) {
            toggleInventory();
        }
        if(inventoryMarkedItem != null){
            // Tjek for maden man aflevere
            if(inventoryMarkedItem.equals("Fisk") && mouseEvent.getTarget() == mandAflever){
                mandTekst.setText("Tak for mad");
                SkjulTale();
                mandAflever.setVisible(false);
                playerController.removeItemFromInventory("Fisk");
                opdaterInventory();
                saveState("mand");
                game.writeHarOpgave("");
                if(getKlaredeOpgaver().size() == 3) {
                    stageController.changeScene("Quiz");
                }
            }
            else if(inventoryMarkedItem.equals("Banan") && mouseEvent.getTarget() == kvindeAflever){
                kvindeTekst.setText("Tak for mad");
                SkjulTale();
                kvindeAflever.setVisible(false);
                playerController.removeItemFromInventory("Banan");
                opdaterInventory();
                saveState("kvinde");
                game.writeHarOpgave("");
                if(getKlaredeOpgaver().size() == 3) {
                    stageController.changeScene("Quiz");
                }
            }
            else if(inventoryMarkedItem.equals("Ris") && mouseEvent.getTarget() == barnAflever){
                barnTekst.setText("Tak for mad");
                SkjulTale();
                barnAflever.setVisible(false);
                playerController.removeItemFromInventory("Ris");
                opdaterInventory();
                saveState("barn");
                game.writeHarOpgave("");
                if(getKlaredeOpgaver().size() == 3) {
                    stageController.changeScene("Quiz");
                }
            }
        }
    }

    public void saveState(String input) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("antalKlaredeOpgaver.txt", true);
            writer.write(input + ",");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toggleInventory() {
        if(inventoryOpen) {
            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), inventoryBox);
            st.setFromX(1.0);
            st.setToX(0.0);
            st.setFromY(1.0);
            st.setToY(0.0);
            st.setInterpolator(Interpolator.EASE_BOTH);
            st.play();

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.2), inventoryBox);
            tt.setFromX(0);
            tt.setToX(275);
            tt.setFromY(0);
            tt.setToY(-275);
            tt.setInterpolator(Interpolator.EASE_BOTH);
            tt.play();

            inventoryBox.setDisable(true);
            inventoryOpen = false;
            inventoryMarkedItem = null;
            if(shownMarker != null) {
                shownMarker.setVisible(false);
            }
        }
        else {
            // Hent inventory
            ArrayList<String> inventory = playerController.getItemsFromInventory();

            if(!(inventory.size() == 1 && inventory.get(0).equals(""))) {
                for(int i = 0; i < inventory.size(); i++) {
                    FileInputStream input = null;
                    try {
                        input = new FileInputStream("WorldOfSult\\zuul-framework\\worldofzuul\\src\\" + inventory.get(i) + ".png");
                        Image image = new Image(input);
                        switch (i) {
                            case 0 -> c0r0Item.setImage(image);
                            case 1 -> c1r0Item.setImage(image);
                            case 2 -> c2r0Item.setImage(image);
                            case 3 -> c0r1Item.setImage(image);
                            case 4 -> c1r1Item.setImage(image);
                            case 5 -> c2r1Item.setImage(image);
                            case 6 -> c0r2Item.setImage(image);
                            case 7 -> c1r2Item.setImage(image);
                            case 8 -> c2r2Item.setImage(image);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            // Hent players penge
            playerBalance.setText("Penge: " + playerController.getPlayerBalance());

            // Vis inventory
            inventoryBox.setVisible(true);
            inventoryBox.setDisable(false);
            inventoryOpen = true;

            ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), inventoryBox);
            st.setFromX(0.0);
            st.setToX(1.0);
            st.setFromY(0.0);
            st.setToY(1.0);
            st.setInterpolator(Interpolator.EASE_BOTH);
            st.play();

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.2), inventoryBox);
            tt.setFromX(275);
            tt.setToX(0);
            tt.setFromY(-275);
            tt.setToY(0);
            tt.setInterpolator(Interpolator.EASE_BOTH);
            tt.play();
        }
    }

    public void opdaterInventory() {
        inventoryBox.setDisable(true);
        inventoryOpen = false;
        inventoryMarkedItem = null;
        if(shownMarker != null) {
            shownMarker.setVisible(false);
        }

        // Hent inventory
        ArrayList<String> inventory = playerController.getItemsFromInventory();

        if(!(inventory.size() == 1 && inventory.get(0).equals(""))) {
            for (int i = 0; i < inventory.size(); i++) {
                FileInputStream input = null;
                try {
                    input = new FileInputStream("WorldOfSult\\zuul-framework\\worldofzuul\\src\\" + inventory.get(i) + ".png");
                    Image image = new Image(input);
                    switch (i) {
                        case 0 -> c0r0Item.setImage(image);
                        case 1 -> c1r0Item.setImage(image);
                        case 2 -> c2r0Item.setImage(image);
                        case 3 -> c0r1Item.setImage(image);
                        case 4 -> c1r1Item.setImage(image);
                        case 5 -> c2r1Item.setImage(image);
                        case 6 -> c0r2Item.setImage(image);
                        case 7 -> c1r2Item.setImage(image);
                        case 8 -> c2r2Item.setImage(image);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for(int i = inventory.size(); i < 9; i++) {
                switch (i) {
                    case 8 -> c2r2Item.setImage(null);
                    case 7 -> c1r2Item.setImage(null);
                    case 6 -> c0r2Item.setImage(null);
                    case 5 -> c2r1Item.setImage(null);
                    case 4 -> c1r1Item.setImage(null);
                    case 3 -> c0r1Item.setImage(null);
                    case 2 -> c2r0Item.setImage(null);
                    case 1 -> c1r0Item.setImage(null);
                    case 0 -> c0r0Item.setImage(null);
                }
            }
        }
        else {
            for(int i = inventory.size() - 1; i < 9; i++) {
                switch (i) {
                    case 8 -> c2r2Item.setImage(null);
                    case 7 -> c1r2Item.setImage(null);
                    case 6 -> c0r2Item.setImage(null);
                    case 5 -> c2r1Item.setImage(null);
                    case 4 -> c1r1Item.setImage(null);
                    case 3 -> c0r1Item.setImage(null);
                    case 2 -> c2r0Item.setImage(null);
                    case 1 -> c1r0Item.setImage(null);
                    case 0 -> c0r0Item.setImage(null);
                }
            }
        }


        // Vis inventory
        inventoryBox.setVisible(true);
        inventoryBox.setDisable(false);
        inventoryOpen = true;

        // Hent players penge
        playerBalance.setText("Penge: " + playerController.getPlayerBalance());
    }

    public void toggleHints(MouseEvent mouseEvent) {
        // todo : Mikkel - Lav hints box
    }

    public void getItem(MouseEvent mouseEvent) {
        if(shownMarker != null) {
            shownMarker.setVisible(false);
        }
        if(mouseEvent.getTarget().equals(c0r0Item)) {
            c0r0Marker.setVisible(true);
            shownMarker = c0r0Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(0);
        }
        else if(mouseEvent.getTarget().equals(c1r0Item)) {
            c1r0Marker.setVisible(true);
            shownMarker = c1r0Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(1);
        }
        else if(mouseEvent.getTarget().equals(c2r0Item)) {
            c2r0Marker.setVisible(true);
            shownMarker = c2r0Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(2);
        }
        else if(mouseEvent.getTarget().equals(c0r1Item)) {
            c0r1Marker.setVisible(true);
            shownMarker = c0r1Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(3);
        }
        else if(mouseEvent.getTarget().equals(c1r1Item)) {
            c1r1Marker.setVisible(true);
            shownMarker = c1r1Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(4);
        }
        else if(mouseEvent.getTarget().equals(c2r1Item)) {
            c2r1Marker.setVisible(true);
            shownMarker = c2r1Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(5);
        }
        else if(mouseEvent.getTarget().equals(c0r2Item)) {
            c0r2Marker.setVisible(true);
            shownMarker = c0r2Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(6);
        }
        else if(mouseEvent.getTarget().equals(c1r2Item)) {
            c1r2Marker.setVisible(true);
            shownMarker = c1r2Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(7);
        }
        else if(mouseEvent.getTarget().equals(c2r2Item)) {
            c2r2Marker.setVisible(true);
            shownMarker = c2r2Marker;
            inventoryMarkedItem = playerController.getItemsFromInventory().get(8);
        }
        System.out.println(inventoryMarkedItem);
    }
}
