package worldofzuul;

import java.util.ArrayList;

public class Player {
    // Inventory
    ArrayList<String> inventory = new ArrayList<String>();

    // Players balance
    int playerBalance = 0;

    // Player quiz score
    int playerQuizScore = 0;

    //////////////////////////// INVENTORY ////////////////////////////////////////
    // add item to inventory
    public void addItemToInventory(String item) {
        inventory.add(item);
    }

    // remove item with specific name, from the inventory
    public void removeItemFromInventory(String item) {
        inventory.remove(item);
    }

    // Get items in players inventory
    public ArrayList<String> getItemsFromInventory() {
        return inventory;
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
        playerBalance += amount;
    }

    // subtract money from the player
    public void subtractMoneyFromPlayer(int amount) {
        if (canPlayerBuy(amount)) {
            playerBalance -= amount;
        }
    }

    public boolean canPlayerBuy(int amount) {
        if (playerBalance - amount > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Get players amount of money
    public int getPlayerBalance(){
        return playerBalance;
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
