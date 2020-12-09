package worldofzuul;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Player {
    // Inventory
    ArrayList<String> inventory = new ArrayList<String>();

    // Players balance
    int playerBalance = 0;

    // Player quiz score
    int playerQuizScore = 0;

    // opsætning af inventory
    boolean canLoadFile;
    String actual;

    //////////////////////////// INVENTORY ////////////////////////////////////////
    // add item to inventory
    public void addItemToInventory(String item) {
        //inventory.add(item);
        FileWriter writer = null;
        try {
            writer = new FileWriter("inventory.txt", true);
            writer.write("," + item);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // remove item with specific name, from the inventory
    public void removeItemFromInventory(String item) {
        inventory.remove(item);
    }

    // Get items in players inventory
    public ArrayList<String> getItemsFromInventory() {
        ArrayList<String> items = new ArrayList<String>();

        // Load Questions and Answers from file
        canLoadFile = false;
        Path fileName = Path.of("inventory.txt");
        actual = null;
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
            String[] itemsInInventory = actual.split(",");
            for (String s : itemsInInventory) {
                items.add(s);
            }
        }
        return items;
    }

    // Get specific items in players inventory
    // get with a number
    public String getSpecificItemFromInventory(int id) {
        return inventory.get(id);
    }
    // Get with item name
    public String getSpecificItemFromInventory(String item) {
        return inventory.get(inventory.indexOf(item));
    }


    ///////////////////////////// PLAYER BALANCE //////////////////////////////////
    // Add money to the player
    public void addMoneyToPlayer(int amount) {
        //playerBalance += amount;
        String balance = String.valueOf(getPlayerBalance() + amount);
        System.out.println(balance);
        try {
            PrintWriter writer = new PrintWriter("playerBalance.txt");
            writer.print(balance);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // subtract money from the player
    public void subtractMoneyFromPlayer(int amount) {
        if (canPlayerBuy(amount)) {
            String balance = String.valueOf(getPlayerBalance() - amount);
            try {
                PrintWriter writer = new PrintWriter("playerBalance.txt");
                writer.print(balance);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean canPlayerBuy(int amount) {
        System.out.println(getPlayerBalance() + " - " + amount + " = " + (getPlayerBalance()-amount));
        if (getPlayerBalance() - amount >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Get players amount of money
    public int getPlayerBalance(){
        // Load Questions and Answers from file
        canLoadFile = false;
        Path fileName = Path.of("playerBalance.txt");
        int amount = 0;
        actual = null;
        try {
            amount = Integer.parseInt(Files.readString(fileName));
            canLoadFile = true;
        } catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }

        return amount;
    }


    ///////////////////////////// PLAYER QUIZ //////////////////////////////////
    // Adds a point to the players score
    public void addPoint() {
        playerQuizScore++;
    }

    // Returns the players score
    public int getPoints() {
        return playerQuizScore;
    }

    // Reset players quiz score
    public void resetPlayersScore() {
        playerQuizScore = 0;
    }
}
