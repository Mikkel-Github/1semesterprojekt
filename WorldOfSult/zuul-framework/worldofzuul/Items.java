package worldofzuul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Items {

    Player playerManager = new Player();

    ArrayList<String> kødListe;
    ArrayList<Integer> kødPriser;
    ArrayList<String> frugtoggrønt1;
    public void printKød() {
        kødListe = new ArrayList<String>();
        kødListe.add("kylling");
        kødListe.add("ged");
        kødListe.add("fisk");
        kødPriser = new ArrayList<Integer>();
        kødPriser.add(30);
        kødPriser.add(50);
        kødPriser.add(20);
        System.out.println("Du kan købe: ");
        for (int i = 0; i < kødListe.size(); i++) {
            System.out.println(kødListe.get(i) + " " + kødPriser.get(i) + " kroner");
        }
    }

    public void printFrugtOgGrønt() {
        frugtoggrønt1 = new ArrayList<String>();
        frugtoggrønt1.add("yams");
        frugtoggrønt1.add("kassava");
        frugtoggrønt1.add("ris");
        frugtoggrønt1.add("banan");
        System.out.println("Du kan købe: ");
        for(String s: frugtoggrønt1) {
            System.out.println(s);
        }
    }

    public void buyItem(String item) {
        for (int i = 0; i < kødListe.size(); i++) {
            if(item.equals(kødListe.get(i))) {
                if(playerManager.canPlayerBuy(kødPriser.get(i))) {
                    playerManager.subtractMoneyFromPlayer(kødPriser.get(i));
                    playerManager.addItemToInventory(item);
                    System.out.println(playerManager.getPlayerBalance());
                    break;
                }
            }
        }
    }
}
    //System.out.println("man kan købe " + kød);
    //System.out.println("Man kan købe " + frugtoggrønt);

   /* public void items() {

        if (ArrayList == kød) {
            System.out.println("Man kan købe " + kød1);
        }



        if (Room == frugtoggrønt) {
            System.out.println("Man kan købe " + frugtoggrønt1);
        }

    }*/


//(Arrays.asList("kylling", "ged", "fisk"))
//(Arrays.asList("yams", "kassava", "ris", "banan"))
   /* void items() {
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
    }*/

// lige nu printer den kun teksten med buy, vi skal have den til at printe listen når vi går ind i et rum.
// vi skal have den til at genkende, hver item og for hvert rum