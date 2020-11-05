package worldofzuul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Items {


    void items() {
        boolean canLoadFile = false;
        Path fileName = Path.of("items.txt");
        String actual = null;
        try {
            actual = Files.readString(fileName);
            canLoadFile = true;
        } catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }

        if(canLoadFile) {
            String[] questionsAndAnswers = actual.split(";");
            for (String s : questionsAndAnswers) {
                String[] splitted = s.split(",");
                for (String x : splitted) {
                    System.out.println(x);
                }
            }
        }
    }
}
// lige nu printer den kun teksten med buy, vi skal have den til at printe listen når vi går ind i et rum.
// vi skal have den til at genkende, hver item og for hvert rum