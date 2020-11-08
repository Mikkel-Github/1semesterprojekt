package worldofzuul;

import java.util.ArrayList;

public class Items {
    Player playerManager = new Player();

    ArrayList<String> kødListe;
    ArrayList<String> kødBeskrivelse;
    ArrayList<Integer> kødPriser;
    ArrayList<String> frugtoggrøntListe;
    ArrayList<String> frugtoggrøntBeskrivelse;
    ArrayList<Integer> frugtoggrøntPriser;

    public void printKød() {
        kødListe = new ArrayList<String>();
        kødListe.add("kylling");
        kødListe.add("ged");
        kødListe.add("fisk");
        kødBeskrivelse = new ArrayList<String>();
        kødBeskrivelse.add(": 181 kcal, 18,8g protein, 0g kulhydrater");
        kødBeskrivelse.add(": 143 kcal, 27g protein, 0g kulhydrater");
        kødBeskrivelse.add(": 205 kcal, 22g protein, 0g kulhydrater");
        kødPriser = new ArrayList<Integer>();
        kødPriser.add(30);
        kødPriser.add(50);
        kødPriser.add(20);
        System.out.println("Du kan købe: ");
        for (int i = 0; i < kødListe.size(); i++) {
            System.out.println(kødListe.get(i) + "" + kødBeskrivelse.get(i) + " " + kødPriser.get(i) + " kroner");
        }
    }

    public void printFrugtOgGrønt() {
        frugtoggrøntListe = new ArrayList<String>();
        frugtoggrøntListe.add("yams");
        frugtoggrøntListe.add("kassava");
        frugtoggrøntListe.add("ris");
        frugtoggrøntListe.add("banan");
        frugtoggrøntBeskrivelse = new ArrayList<String>();
        frugtoggrøntBeskrivelse.add(": 112 kcal, 1,5g protein, 27,9g kulhydrater");
        frugtoggrøntBeskrivelse.add(": 159 kcal, 1,4g protein, 38,1g kulhydrater");
        frugtoggrøntBeskrivelse.add(": 365 kcal, 7,8g protein, 79,8g kulhydrater");
        frugtoggrøntBeskrivelse.add(": 82 kcal, 1,3g protein, 19g kulhydrater");
        frugtoggrøntPriser = new ArrayList<Integer>();
        frugtoggrøntPriser.add(30);
        frugtoggrøntPriser.add(20);
        frugtoggrøntPriser.add(40);
        frugtoggrøntPriser.add(20);
        System.out.println("Du kan købe: ");
        for (int i = 0; i < frugtoggrøntListe.size(); i++) {
            System.out.println(frugtoggrøntListe.get(i) + "" + frugtoggrøntBeskrivelse.get(i) + " "+ frugtoggrøntPriser.get(i) + " kroner");
        }

    }

    public boolean buyItem(String item) {
        boolean didBuy = false;
        if(kødListe != null) {
            for (int i = 0; i < kødListe.size(); i++) {
                if(item.equals(kødListe.get(i))) {
                    if(playerManager.canPlayerBuy(kødPriser.get(i))) {
                        playerManager.subtractMoneyFromPlayer(kødPriser.get(i));
                        System.out.println(playerManager.getPlayerBalance());
                        didBuy = true;
                        break;
                    }
                    else {
                        System.out.println("Du har ikke råd til " + item);
                    }
                }
            }
        }
        if(frugtoggrøntListe != null) {
            for (int i = 0; i < frugtoggrøntListe.size(); i++) {
                if(item.equals(frugtoggrøntListe.get(i))) {
                    if(playerManager.canPlayerBuy(frugtoggrøntPriser.get(i))) {
                        playerManager.subtractMoneyFromPlayer(frugtoggrøntPriser.get(i));
                        System.out.println(playerManager.getPlayerBalance());
                        didBuy = true;
                        break;
                    }
                    else {
                        System.out.println("Du har ikke råd til " + item);
                    }
                }
            }
        }
        return didBuy;
    }
}

