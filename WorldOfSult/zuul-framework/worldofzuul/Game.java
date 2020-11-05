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
    private ArrayList<String> quizList = new ArrayList<String>();
    private ArrayList<String> quizAnswers = new ArrayList<String>();
    private Items items = new Items();

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room markedsplads, frugtoggrønt, kød, humans, quiz;


        markedsplads = new Room("Du er nu ved markedspladsen");
        frugtoggrønt = new Room("Her kan du købe frugt og grønt");
        kød = new Room("Her kan du købe kød");
        humans = new Room("In a room with people who needs your help to get the correct food and supplements.");
        quiz = new Room("in the quiz room");

        //markedsplads.setExit("humans", humans);
        markedsplads.setExit("kornoggrønt", frugtoggrønt);
        markedsplads.setExit("kød", kød);

        frugtoggrønt.setExit("markedsplads", markedsplads);

        kød.setExit("markedsplads", markedsplads);

        humans.setExit("markedsplads", markedsplads);

        currentRoom = markedsplads;
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
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void quiz() {
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

        if(canLoadFile) {
            String[] questionsAndAnswers = actual.split(":");
            for (String s : questionsAndAnswers) {
                String[] splitted = s.split(",");
                for (String x : splitted) {
                    System.out.println(x);
                }
            }
        }

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processQuizCommand(command);
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
        }
        else if (commandWord == CommandWord.B) {
            // Valg B
            System.out.println("Player chose B");
        }
        else if (commandWord == CommandWord.C) {
            // Valg C
            System.out.println("Player chose C");
        }
        else if (commandWord == CommandWord.D) {
            // Valg D
            System.out.println("Player chose D");
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
        items.items();



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
