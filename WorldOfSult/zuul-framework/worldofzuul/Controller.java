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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PrivateKey;
import java.util.ArrayList;


import static worldofzuul.StageController.currentStage;

public class Controller {
    StageController stageController = new StageController();

    Game game = new Game();
    Player playerController = new Player();

    boolean HarOpgave = false;

    boolean inventoryOpen = false;

    String inventoryMarkedItem;

    ImageView shownMarker = null;

    @FXML
    private ImageView startImage;
    @FXML
    private ImageView infoImage;
    @FXML
    private ImageView slutImage;
    @FXML
    private ImageView logoImage;
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
    private GridPane inventoryGrid;
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
    public void initialize() {
        if(currentStage.equals("Menu")) {
            animateLogo();
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

    public void toggleInventory(MouseEvent mouseEvent) {
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
            shownMarker.setVisible(false);
        }
        else {
            // Hent inventory
            ArrayList<String> inventory = playerController.getItemsFromInventory();
            int column = 0;
            int row = 0;

            for(int i = 0; i < inventory.size(); i++) {
                FileInputStream input = null;
                try {
                    input = new FileInputStream("WorldOfSult\\zuul-framework\\worldofzuul\\src\\" + inventory.get(i) + ".png");
                    Image image = new Image(input);
                    ImageView imageView = new ImageView(image);
                    imageView.setPreserveRatio(true);
                    imageView.setFitWidth(100);
                    inventoryGrid.add(imageView, column, row);
                    if(column == 2) {
                        column = 0;
                        row++;
                    }
                    else {
                        column++;
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
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
        // Hent inventory
        ArrayList<String> inventory = playerController.getItemsFromInventory();
        int column = 0;
        int row = 0;

        inventoryGrid.getChildren().removeAll();

        for(int i = 0; i < inventory.size(); i++) {
            FileInputStream input = null;
            try {
                input = new FileInputStream("WorldOfSult\\zuul-framework\\worldofzuul\\src\\" + inventory.get(i) + ".png");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(100);
            inventoryGrid.add(imageView, column, row);
            if(column == 2) {
                column = 0;
                row++;
            }
            else {
                column++;
            }
        }

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

        Node clickedNode = mouseEvent.getPickResult().getIntersectedNode();
        // Finder hvilken column og row der bliver trykket på
        Integer colIndex = GridPane.getColumnIndex(clickedNode);
        Integer rowIndex = GridPane.getRowIndex(clickedNode);

        if(colIndex != null && rowIndex != null) {
            // Beregn hvilket item der bliver trykket på
            int itemNumber = colIndex + (rowIndex * 3);
            inventoryMarkedItem = playerController.getItemsFromInventory().get(itemNumber);
            System.out.println(inventoryMarkedItem);
            if(colIndex == 0) {
                if(rowIndex == 0) {
                    c0r0Marker.setVisible(true);
                    shownMarker = c0r0Marker;
                }
                if(rowIndex == 1) {
                    c0r1Marker.setVisible(true);
                    shownMarker = c0r1Marker;
                }
                if(rowIndex == 2) {
                    c0r2Marker.setVisible(true);
                    shownMarker = c0r2Marker;
                }
            }
            else if(colIndex == 1) {
                if(rowIndex == 0) {
                    c1r0Marker.setVisible(true);
                    shownMarker = c1r0Marker;
                }
                if(rowIndex == 1) {
                    c1r1Marker.setVisible(true);
                    shownMarker = c1r1Marker;
                }
                if(rowIndex == 2) {
                    c1r2Marker.setVisible(true);
                    shownMarker = c1r2Marker;
                }
            }
            else if(colIndex == 2) {
                if(rowIndex == 0) {
                    c2r0Marker.setVisible(true);
                    shownMarker = c2r0Marker;
                }
                if(rowIndex == 1) {
                    c2r1Marker.setVisible(true);
                    shownMarker = c2r1Marker;
                }
                if(rowIndex == 2) {
                    c2r2Marker.setVisible(true);
                    shownMarker = c2r2Marker;
                }
            }
        }
    }
}
