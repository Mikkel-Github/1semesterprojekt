package worldofzuul;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Game
{
    private Player playerManager = new Player();
    ArrayList<String> Questionlist = new ArrayList<String>();
    ArrayList<String> answerList = new ArrayList<String>();
    boolean isQuizDone = false;

    public void quiz() {
        // Load Questions and Answers from file
        boolean canLoadFile = false;
        Path fileName = Path.of("quizSporgsmaal.txt");
        String actual = null;
        try {
            actual = Files.readString(fileName);
            canLoadFile = true;
        } catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }

        // Set Questions and Answers up in a list
        if(canLoadFile) {
            int counter = 0;
            String[] questionsAndAnswers = actual.split(";");
            for (String s : questionsAndAnswers) {
                // It first puts the questions and ansers in the list if counter is an odd number
                if(counter == 0 || counter % 2 == 0) {
                    String[] splitted = s.split(",");
                    for (String x : splitted) {
                        Questionlist.add(x);
                    }
                }
                else {
                    // Every other ";" it puts answer in answerList
                    answerList.add(s);
                }
                counter++;
            }
        }
    }

    public String checkHarOpgave() {
        // Load Questions and Answers from file
        boolean canLoadFile = false;
        Path fileName = Path.of("harOpgave.txt");
        String actual = null;
        try {
            actual = Files.readString(fileName);
            canLoadFile = true;
        } catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }
        return actual;
    }

    public void writeHarOpgave(String input) {
        try {
            PrintWriter writer = new PrintWriter("harOpgave.txt");
            writer.print(input);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList askQuestion(int questionNumber) {
        ArrayList<String> question = new ArrayList();
        if(questionNumber < Questionlist.size()) {
            for(int i = questionNumber; i < questionNumber + 5; i++) {
                System.out.println(Questionlist.get(i));
                question.add(Questionlist.get(i));
            }
        }
        else {
            isQuizDone = true;
        }
        return question;
    }

    public boolean checkIfDone(int questionNumber) {
        if(questionNumber >= Questionlist.size()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkQuestion(int questionNumber, String answer) {
        if(answer.equals(answerList.get(questionNumber - 1))) {
            System.out.println("Rigtigt svar");
            playerManager.addPoint();
            return true;
        }
        else {
            System.out.println("Forkert svar");
            return false;
        }
    }
}
