package worldofzuul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Game
{
    private Parser parser;
    private Room currentRoom;
    private Player playerManager = new Player();
    ArrayList<String> Questionlist = new ArrayList<String>();
    ArrayList<String> answerList = new ArrayList<String>();
    int quizNumber = 0;
    boolean isQuizDone = false;
    Room village;


    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room markedsplads, kornoggrønt, kød, quiz;


        markedsplads = new Room("in the campus pub");
        kornoggrønt = new Room("in a computing lab!");
        kød = new Room("in the computing admin office");
        quiz = new Room("in the quiz room");
        village = new Room("In a room with three people who needs your help to get the correct food and supplements.");

        //markedsplads.setExit("humans", humans);
        markedsplads.setExit("kornoggrønt", kornoggrønt);
        markedsplads.setExit("kød", kød);
        markedsplads.setExit("village", village);

        kornoggrønt.setExit("markedsplads", markedsplads);

        kød.setExit("markedsplads", markedsplads);

        village.setExit("markedsplads", markedsplads);

        currentRoom = markedsplads;

        // TEST af inventory
        playerManager.addItemToInventory("computer");
    }

    public void startMenu() {
        // Our start menu that can be called
        System.out.println("World of Sult");
        // Printer kommandoerne så hvis vi ændre dem, vil de også blive ændret her
        System.out.println(CommandWord.START + "\n" + CommandWord.INFO + "\n" + CommandWord.SETTINGS + "\n" + CommandWord.QUIT);

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processStartMenuCommand(command);
        }
    }

    private boolean processStartMenuCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.START) {
            // Starts the game
            play();
        }
        // DEBUG
        else if (commandWord == CommandWord.QUIZ) {
            quiz();
            return true;
        }
        else if (commandWord == CommandWord.CONTINUE) {
            return true;
        }
        else if (commandWord == CommandWord.INFO) {
            // Opens information
            info();
        }
        else if (commandWord == CommandWord.SETTINGS) {
            // Opens settings
            settings();
        }
        else if (commandWord == CommandWord.QUIT) {
            // Exits the game
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    public void info() {
        System.out.println("Info");
        System.out.println("Information about the game and hunger");
    }

    public void settings() {
        System.out.println("Settings");
        System.out.println("We have no settings to change");
    }

    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til World of Sult");
        System.out.println("World of Sult handler om FN's 2. verdensmål, 'Stop Sult'.");
        System.out.println("* Informationer omkring emnet *");

        

        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.BUY){
            buyItem(command);
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.VILLAGE) {
            goToVillage();
        }

        else if (commandWord == CommandWord.PAUSE) {
            pauseGame();
        }
        else if (commandWord == CommandWord.INVENTORY) {
            //opens inventory
            ArrayList<String> temp = playerManager.getItemsFromInventory();
            for (String n : temp) {
                System.out.println(n);
            }
        }
        else if (commandWord == CommandWord.MALE){
            if (currentRoom == village){
                Humans male = new Humans("Male", 30);
                System.out.println("Hello I am " + male.name + " " + male.age + " i need ....");
            }
        }
        else if (commandWord == CommandWord.FEMALE){
            if (currentRoom == village){
                Humans female = new Humans("Female", 30);
                System.out.println("Hello I am " + female.name + " " + female.age + " i need ....");
            }
        }
        else if (commandWord == CommandWord.CHILD){
            if (currentRoom == village){
                Humans child = new Humans("Child", 2);
                System.out.println("Hello I am " + child.name + " " + child.age + " i need ....");
            }
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void pauseGame() {
        System.out.println("Game is now paused");
        System.out.println("Pause \nInfo \nSettings \nQuit");

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processPauseGameCommand(command);
        }
    }

    private boolean processPauseGameCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (commandWord == CommandWord.PAUSE) {
            // Unpauses the game
            System.out.println("The game is now unpaused");
            System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
            System.out.println();
            System.out.println(currentRoom.getLongDescription());
        }
        else if (commandWord == CommandWord.INFO) {
            // Opens information
            info();
        }
        else if (commandWord == CommandWord.SETTINGS) {
            // Opens settings
            settings();
        }
        else if (commandWord == CommandWord.QUIT) {
            // Exits the game
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void quiz() {
        // Load Questions and Answers from file
        boolean canLoadFile = false;
        Path fileName = Path.of("quizSpørgsmål.txt");
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

        // First time quiz runs, it asks a question
        // The other questions are being called from "processQuizCommand
        askQuestion(quizNumber);

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processQuizCommand(command);

            if(isQuizDone) {
                System.out.println("Du klarede quizen!");
                System.out.println("Du fik " + playerManager.getPoints() + " rigtige ud af " + answerList.size() + " spørgsmål");
            }
        }
    }

    private void askQuestion(int questionNumber) {
        if(questionNumber < Questionlist.size()) {
            for(int i = questionNumber; i < questionNumber + 5; i++) {
                System.out.println(Questionlist.get(i));
            }
        }
        else {
            isQuizDone = true;
        }
    }

    private void checkQuestion(int questionNumber, String answer) {
        if(answer.equals(answerList.get(questionNumber - 1))) {
            System.out.println("Right answer");
            playerManager.addPoint();
        }
        else {
            System.out.println("Wrong answer");
        }
    }

    private boolean processQuizCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            // Printe hjælp til quizen
        }
        else if (commandWord == CommandWord.A){
            // Valg A
            System.out.println("Player chose A");
            quizNumber += 5;
            checkQuestion(quizNumber / 5, "a");
            askQuestion(quizNumber);
        }
        else if (commandWord == CommandWord.B) {
            // Valg B
            System.out.println("Player chose B");
            quizNumber += 5;
            checkQuestion(quizNumber / 5, "b");
            askQuestion(quizNumber);
        }
        else if (commandWord == CommandWord.C) {
            // Valg C
            System.out.println("Player chose C");
            quizNumber += 5;
            checkQuestion(quizNumber / 5, "c");
            askQuestion(quizNumber);
        }
        else if (commandWord == CommandWord.D) {
            // Valg D
            System.out.println("Player chose D");
            quizNumber += 5;
            checkQuestion(quizNumber / 5, "d");
            askQuestion(quizNumber);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    private void buyItem(Command command)
    {
        if(!command.hasSecondWord()){
            System.out.println("Buy what?");
            return;
        }
        String item = command.getSecondWord();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void goToVillage() {
        // Quick way to get to the village
        currentRoom = village;
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            // Tjekker om brugeren har givet to commands
            System.out.println("Quit what?");
            return false;
        }
        else {
            // Hvis brugeren kun har skrevet "quit", returnere den true
            return true;
        }
    }
}
