package worldofzuul;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class QuizController {
    Game game = new Game();
    int questionNumber = 0;

    @FXML
    private TextArea questionText;
    @FXML
    private StackPane questionPanel;
    @FXML
    private Pane answerPanel;
    @FXML
    private ImageView background;
    @FXML
    private Pane answerAPanel;
    @FXML
    private Pane answerBPanel;
    @FXML
    private Pane answerCPanel;
    @FXML
    private Pane answerDPanel;
    @FXML
    private Text AnswerAText;
    @FXML
    private Text AnswerBText;
    @FXML
    private Text AnswerCText;
    @FXML
    private Text AnswerDText;
    @FXML
    private ImageView answerA;
    @FXML
    private ImageView answerB;
    @FXML
    private ImageView answerC;
    @FXML
    private ImageView answerD;
    @FXML
    private Pane quizDone;
    @FXML
    private VBox quizResults;
    @FXML
    private ScrollPane scrollBox;

    ArrayList<String> resultat = new ArrayList<String>();

    @FXML
    void initialize() {
        // Load questions
        game.quiz();

        // Ask question
        showQuestion();
    }

    public void showQuestion() {
        animationFadeOut_StackPane(questionPanel);
        animationPopOut_Pane(answerAPanel);
        animationPopOut_Pane(answerBPanel);
        animationPopOut_Pane(answerCPanel);
        animationPopOut_Pane(answerDPanel);

        if(game.checkIfDone(questionNumber)) {
            for(int i = 0; i < resultat.size(); i += 2) {
                Text text = new Text(resultat.get(i) + ": " + resultat.get(i+1));
                text.setCache(true);
                text.setFill(Color.BLACK);
                text.setFont(Font.font(24));
                quizResults.getChildren().add(text);
                scrollBox.setContent(quizResults);
            }
            answerPanel.setDisable(true);
            questionPanel.setDisable(true);
            animationPopIn_Pane(quizDone);
            quizDone.setDisable(false);
        }
        else {
            ArrayList gameData = game.askQuestion(questionNumber);
            if(gameData.size() > 1) {
                questionText.setText((String) gameData.get(0));
                AnswerAText.setText((String) gameData.get(1));
                AnswerBText.setText((String) gameData.get(2));
                AnswerCText.setText((String) gameData.get(3));
                AnswerDText.setText((String) gameData.get(4));

                resultat.add((String) gameData.get(0));
            }

            questionNumber += 5;

            animationBlur_Background();
            animationFadeIn_StackPane(questionPanel);
            animationPopIn_Pane(answerAPanel);
            animationPopIn_Pane(answerBPanel);
            animationPopIn_Pane(answerCPanel);
            animationPopIn_Pane(answerDPanel);
        }
    }

    public void chooseAnswer(MouseEvent mouseEvent) {
        if(mouseEvent.getTarget() == answerA) {
            if(game.checkQuestion(questionNumber / 5, "a")) {
                resultat.add("Rigtigt");
            }
            else {
                resultat.add("Forkert");
            }
            showQuestion();
        }
        else if(mouseEvent.getTarget() == answerB) {
            if(game.checkQuestion(questionNumber / 5, "b")) {
                resultat.add("Rigtigt");
            }
            else {
                resultat.add("Forkert");
            }
            showQuestion();
        }
        else if(mouseEvent.getTarget() == answerC) {
            if(game.checkQuestion(questionNumber / 5, "c")) {
                resultat.add("Rigtigt");
            }
            else {
                resultat.add("Forkert");
            }
            showQuestion();
        }
        else if(mouseEvent.getTarget() == answerD) {
            if(game.checkQuestion(questionNumber / 5, "d")) {
                resultat.add("Rigtigt");
            }
            else {
                resultat.add("Forkert");
            }
            showQuestion();
        }
    }

    // Animations
    @FXML
    public void animationSizeBig_Pane(MouseEvent mouseEvent) {
        Pane target = (Pane) mouseEvent.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), target);
        st.setToX(1.2);
        st.setToY(1.2);
        st.setCycleCount(1);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();
    }

    @FXML
    public void animationSizeStandard_Pane(MouseEvent mouseEvent) {
        Pane target = (Pane) mouseEvent.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), target);
        st.setToX(1.0);
        st.setToY(1.0);
        st.setCycleCount(1);
        st.setInterpolator(Interpolator.EASE_BOTH);
        st.play();
    }

    @FXML
    public void animationFadeIn_StackPane(StackPane target) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), target);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setInterpolator(Interpolator.EASE_BOTH);
        ft.play();
    }

    @FXML
    public void animationFadeOut_StackPane(StackPane target) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1), target);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setInterpolator(Interpolator.EASE_BOTH);
        ft.play();
    }

    @FXML
    public void animationPopIn_Pane(Pane target) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1.5), target);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setCycleCount(1);
        ft.setInterpolator(Interpolator.EASE_BOTH);

        ft.play();
    }

    @FXML
    public void animationPopOut_Pane(Pane target) {
        FadeTransition ft = new FadeTransition(Duration.seconds(1.5), target);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        ft.setInterpolator(Interpolator.EASE_BOTH);
        ft.play();
    }

    @FXML
    public void animationBlur_Background() {
        BoxBlur bb = new BoxBlur();
        bb.setWidth(8);
        bb.setHeight(8);
        bb.setIterations(3);

        background.setEffect(bb);
        background.setTranslateX(0);
        background.setTranslateY(0);

    }
}
