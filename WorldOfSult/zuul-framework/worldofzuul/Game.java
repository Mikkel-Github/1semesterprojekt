package worldofzuul;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Game
{
    private Parser parser;
    private Room currentRoom;
        

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;
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
        else if (commandWord == CommandWord.CONTINUE) {
            System.out.println("TEST");
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

        // 5 seconds delay
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tryk på en knap for at forsætte");
        boolean finished = false;
        while (! finished) {
            
        }

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
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
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
