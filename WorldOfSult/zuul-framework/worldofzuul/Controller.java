package worldofzuul;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


import static worldofzuul.StageController.currentStage;

public class Controller {
    StageController stageController = new StageController();

    Game game = new Game();
    Player playerController = new Player();

    boolean inventoryOpen = false;

    String inventoryMarkedItem;

    ImageView shownMarker = null;

    boolean hintsOpen = false;

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
    private ImageView mandAflever;
    @FXML
    private ImageView kvindeAflever;
    @FXML
    private ImageView barnAflever;
    @FXML
    private Text mandTekst;
    @FXML
    private Text kvindeTekst;
    @FXML
    private Text barnTekst;
    @FXML
    private Pane hintsBox;
    @FXML
    private Text hintsText;
    @FXML
    private Button tagQuizButton;
    @FXML
    private ImageView skiltMarkedspladsImage;

    @FXML
    public void initialize() {
        if(currentStage.equals("Menu")) {
            animateLogo();
            playerController.resetTasks();
            playerController.resetInventory();
            playerController.resetPlayerBalance();
        }
        else if(currentStage.equals("kodMarked") || currentStage.equals("frugtOgGront")) {
            playerBalanceKødMarked.setText("Penge: " + playerController.getPlayerBalance());
        }
    }

    ///////////////////// MENU ////////////////////////
    public void startClicked() throws Exception {
        stageController.changeScene("Landsby");
    }

    public void infoClicked() throws IOException {
        stageController.changeScene("Info");
    }

    public void slutClicked() {
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
    public void backToMenu() throws IOException {
        stageController.changeScene("Menu");
    }

    public void MarkedspladsClicked() throws IOException {
        stageController.changeScene("Markedsplads");
    }

    public void Skilt_kødmarkedClicked() throws IOException {
        stageController.changeScene("kodMarked");
    }

    public void Skilt_frugtoggrøntClicked() throws IOException {
        stageController.changeScene("frugtOgGront");
    }

    public void Skilt_MarkedspladsClicked() throws IOException {
        stageController.changeScene("Markedsplads");
    }

    public void markedsplads_venstreClicked() throws IOException {
        stageController.changeScene("Markedsplads");
    }
    public void Skilt_LandsbyClicked() throws IOException {
        stageController.changeScene("Landsby");
    }

    public void FiskClicked() {
        hideFoodBox();
        fiskTekst.setVisible(true);
    }

    public void KyllingClicked() {
        hideFoodBox();
        kyllingTekst.setVisible(true);
    }

    public void BøfClicked() {
        hideFoodBox();
        bøfTekst.setVisible(true);
    }

    public void bananClicked() {
        hideFoodBox();
        bananTekst.setVisible(true);
    }

    public void YamsClicked() {
        hideFoodBox();
        yamsTekst.setVisible(true);
    }

    public void RisClicked() {
        hideFoodBox();
        risTekst.setVisible(true);
    }

    public void KassavaClicked() {
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
            if (playerController.canPlayerBuy(15)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(15);
                    playerController.addItemToInventory("Bøf");
                    amount = "15";
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
            if (playerController.canPlayerBuy(12)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(12);
                    playerController.addItemToInventory("Kylling");
                    amount = "12";
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
            if (playerController.canPlayerBuy(10)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(10);
                    playerController.addItemToInventory("Fisk");
                    amount = "10";
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
            if (playerController.canPlayerBuy(5)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(5);
                    playerController.addItemToInventory("Yams");
                    amount = "5";
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
            if (playerController.canPlayerBuy(6)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(6);
                    playerController.addItemToInventory("Kassava");
                    amount = "6";
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
            if (playerController.canPlayerBuy(8)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(8);
                    playerController.addItemToInventory("Ris");
                    amount = "8";
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
            if (playerController.canPlayerBuy(3)) {
                if(playerController.canAddItemToInventory()) {
                    playerController.subtractMoneyFromPlayer(3);
                    playerController.addItemToInventory("Banan");
                    amount = "3";
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

    public void MandClicked() {
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
                mandTekst.setText("Hej. Jeg hedder Lucas\n" +
                        "Jeg er 26 år gammel. Jeg har brug for din hjælp til at handle ind. '" +
                        "Jeg får ikke nok mad, jeg har brug for C-vitamin, B1 vitamin og over 30g kulhydrater. " +
                        "Jeg kan give dig 15Kr, til at købe maden for mig. Kan du hjælpe mig?");
            }
        }
        else {
            SkjulTale();
            MandTale.setVisible(true);
            MandSvarJa.setVisible(false);
            MandSvarNej.setVisible(false);
            mandAflever.setVisible(false);
            mandTekst.setText("\nMange tak for din hjælp.\n" +
                    "Uden din hjælp havde jeg risikeret skørbug, svage tænder og appetitløshed, på grund af C-vitamin mangel. \n");
        }
    }

    public void KvindeClicked() {
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
                kvindeTekst.setText("Hej jeg hedder Tina\n" +
                        "Jeg er en kvinde på 26 år, og jeg er underernæret og har brug for din hjælp til at købe noget mad" +
                        " som indeholder mere end 60 kulhydrater og mere end 0,50 mg B1 vitaminer. " +
                        "Hvis du tager imod min opgave, så kan jeg give dig 15Kr til at købe for henne på markedspladsen. Kan du hjælpe mig?");
            }
        }
        else {
            SkjulTale();
            KvindeTale.setVisible(true);
            KvindeSvarJa.setVisible(false);
            KvindeSvarNej.setVisible(false);
            kvindeAflever.setVisible(false);
            kvindeTekst.setText("\nMange tak for din hjælp.\n" +
                    "Uden din hjælp havde jeg risikeret nedsat appetit, koncentrationsbesvær, træthed og irritabilitet, på grund af mangel på B1 vitamin.\n");
        }
    }

    public void DrengClicked() {
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
                barnTekst.setText("Hej jeg hedder Mads\n" +
                        "Jeg er en dreng på 8 år, og jeg er underernæret og har brug for din hjælp til at købe noget mad" +
                        " som indeholder omega 3 og en høj mængde proteiner. " +
                        "Hvis du tager imod min opgave, så kan jeg give dig 10Kr til at købe for henne på markedspladsen. Kan du hjælpe mig?");
            }
        }
        else {
            SkjulTale();
            BarnTale.setVisible(true);
            BarnSvarJa.setVisible(false);
            BarnSvarNej.setVisible(false);
            barnAflever.setVisible(false);
            barnTekst.setText("\nMange tak for din hjælp.\n" +
                    "Uden din hjælp havde jeg risikeret udtørret hud og irriterede tørre øjne.\n");
        }
    }

    public void SkiltClicked() throws Exception{
        stageController.changeScene("Markedsplads");
    }


    public void SvarJaClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getTarget()==MandSvarJa){
           playerController.addMoneyToPlayer(15);
           game.writeHarOpgave("mand");
           MandSvarJa.setVisible(false);
           MandSvarNej.setVisible(false);
           game.writePersonHint("Manden skal have C- og B1 vitamin, og over 30g kulhydrater.");
        }
        else if(mouseEvent.getTarget()==KvindeSvarJa) {
            playerController.addMoneyToPlayer(15);
            game.writeHarOpgave("kvinde");
            KvindeSvarJa.setVisible(false);
            KvindeSvarNej.setVisible(false);
            game.writePersonHint("Kvinden skal have mere en 60 hulhydrater og mere end 0,50mg B1 vitamin.");
        }
        else if(mouseEvent.getTarget()==BarnSvarJa) {
            playerController.addMoneyToPlayer(10);
            game.writeHarOpgave("dreng");
            BarnSvarJa.setVisible(false);
            BarnSvarNej.setVisible(false);
            game.writePersonHint("Barnet har brug for mads om indeholder omega 3 og en høj mængde proteiner.");
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
        }

        ArrayList<String> tasksDone = new ArrayList<String>();
        // Set Questions and Answers up in a list
        String[] tasksDoneList = actual.split(",");
        for (String s : tasksDoneList) {
            tasksDone.add(s);
        }

        return tasksDone;
    }

    public void afleverGenstande(MouseEvent mouseEvent) {
        if(!inventoryOpen) {
            toggleInventory();
        }
        if(inventoryMarkedItem != null){
            // Tjek for maden man aflevere
            if(inventoryMarkedItem.equals("Kassava") && mouseEvent.getTarget() == mandAflever){
                mandAflever.setVisible(false);
                playerController.removeItemFromInventory("Kassava");
                playerController.resetPlayerBalance();
                opdaterInventory();
                saveState("mand");
                game.writeHarOpgave("");
                MandClicked();
                if(inventoryOpen){
                    toggleInventory();
                }
                if(getKlaredeOpgaver().size() == 3) {
                    if(inventoryOpen) {
                        toggleInventory();
                    }
                    tagQuizButton.setVisible(true);
                    skiltMarkedspladsImage.setDisable(true);
                }
            }
            else if(mouseEvent.getTarget() == mandAflever) {
                playerController.resetPlayerBalance();
                playerController.resetInventory();
                playerController.addMoneyToPlayer(15);
                opdaterInventory();
                if(inventoryOpen){
                    toggleInventory();
                }
                mandTekst.setText("Det er ikke rigtigt. \nPrøv igen.");
            }
            else if(inventoryMarkedItem.equals("Ris") && mouseEvent.getTarget() == kvindeAflever){
                kvindeAflever.setVisible(false);
                playerController.removeItemFromInventory("Ris");
                playerController.resetPlayerBalance();
                opdaterInventory();
                saveState("kvinde");
                game.writeHarOpgave("");
                KvindeClicked();
                if(inventoryOpen){
                    toggleInventory();
                }
                if(getKlaredeOpgaver().size() == 3) {
                    if(inventoryOpen) {
                        toggleInventory();
                    }
                    tagQuizButton.setVisible(true);
                    skiltMarkedspladsImage.setDisable(true);
                }
            }
            else if(mouseEvent.getTarget() == kvindeAflever) {
                playerController.resetPlayerBalance();
                playerController.resetInventory();
                playerController.addMoneyToPlayer(15);
                opdaterInventory();
                if(inventoryOpen){
                    toggleInventory();
                }
                kvindeTekst.setText("Det er ikke rigtigt. \nPrøv igen.");
            }
            else if(inventoryMarkedItem.equals("Fisk") && mouseEvent.getTarget() == barnAflever){
                SkjulTale();
                barnAflever.setVisible(false);
                playerController.removeItemFromInventory("Fisk");
                playerController.resetPlayerBalance();
                opdaterInventory();
                saveState("barn");
                game.writeHarOpgave("");
                DrengClicked();
                if(inventoryOpen){
                    toggleInventory();
                }
                if(getKlaredeOpgaver().size() == 3) {
                    if(inventoryOpen) {
                        toggleInventory();
                    }
                    tagQuizButton.setVisible(true);
                    skiltMarkedspladsImage.setDisable(true);
                }
            }
            else if(mouseEvent.getTarget() == barnAflever) {
                playerController.resetPlayerBalance();
                playerController.resetInventory();
                playerController.addMoneyToPlayer(10);
                opdaterInventory();
                if(inventoryOpen){
                    toggleInventory();
                }
                barnTekst.setText("Det er ikke rigtigt. \nPrøv igen.");
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

    public void toggleHints() {
        if(!hintsOpen) {
            // Åben
            hintsBox.setVisible(true);
            if(currentStage.equals("Landsby")) {
                hintsText.setText("I dette rum, kan du snakke med 3 forskellige personer, som er underernæret, disse personer mangler nogle specifikke vitaminer, som de selv vil fortælle dig mere om.\n\n" +
                        "Du skal i dette rum klare 1 opgave fra hver af de 3 personer. Efter du har taget en opgave, skal du tage hen på markedspladsen, og købe noget mad til dem, " +
                        "som indeholder de vitaminer som de mangler. Når du har købt maden der indeholder de vitaminer som personen mangler, så kan du aflevere maden til dem og på den måde klare din opgave.\n\n" +
                        "Efter du har klaret alle 3 opgaver, så bliver du sendt videre til en quiz, omkring informationerne du har fået i løbet af spillet.");
            }
            else if(currentStage.equals("Markedsplads")) {
                hintsText.setText("I dette rum kan du vælge mellem at besøge “Frugt og grønt” eller “Kød”. \n" +
                        "I disse 2 rum kan du købe mad som indeholder de forskellige vitaminer, som du skal bruge til at klare din opgave.\n" +
                        game.getPersonHints());
            }
            else if(currentStage.equals("frugtOgGront")) {
                hintsText.setText("I dette rum er det muligt for dig at købe noget “Frugt og grønt” som indeholder x vitaminer, " +
                        "som du efter at have købt, skal tage tilbage til landsbyen og aflevere, for at kunne klare din opgave. \n" +
                        game.getPersonHints());
            }
            else if(currentStage.equals("kodMarked")) {
                hintsText.setText("I dette rum er det muligt for dig at købe noget “Kød” som indeholder x vitaminer, " +
                        "som du efter at have købt, skal tage tilbage til landsbyen og aflevere, for at kunne klare din opgave. \n" +
                        game.getPersonHints());
            }
            else {
                hintsText.setText("Der er ikke nogen hints at finde");
            }
            hintsOpen = true;

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.2), hintsBox);
            tt.setFromY(-400);
            tt.setToY(0);
            tt.setInterpolator(Interpolator.EASE_BOTH);

            tt.play();
        }
        else {
            // Luk
            hintsOpen = false;

            TranslateTransition tt = new TranslateTransition(Duration.seconds(0.2), hintsBox);
            tt.setFromY(0);
            tt.setToY(-400);
            tt.setInterpolator(Interpolator.EASE_BOTH);

            tt.play();
        }
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
    }

    public void tagQuiz() throws IOException {
        stageController.changeScene("Quiz");
    }
}
