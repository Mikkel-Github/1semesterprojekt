package worldofzuul;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Game
{
    private Parser parser;
    private Room currentRoom, kød, frugtoggrønt;
    private Player playerManager = new Player();
    ArrayList<String> Questionlist = new ArrayList<String>();
    ArrayList<String> answerList = new ArrayList<String>();
    int quizNumber = 0;
    boolean isQuizDone = false;
    Room village;
    private Items items = new Items();


    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room markedsplads;


        markedsplads = new Room("Du er på markedspladsen");
        frugtoggrønt = new Room("Du er på frugt og grønt markedet");
        kød = new Room("Du er på kød markedet");
        village = new Room("Du er nu i et rum med tre personer, som har brug for din hjælp til at få den rigtige mængde ernæringsstoffer.");

        //markedsplads.setExit("humans", humans);
        markedsplads.setExit("frugtoggrønt", frugtoggrønt);
        markedsplads.setExit("kød", kød);
        markedsplads.setExit("village", village);
        markedsplads.setHints("Her kan du vælge i mellem at gå til 'frugt og Grønt', 'Kød-markedet' eller tilbage til 'village'");

        frugtoggrønt.setExit("markedsplads", markedsplads);
        frugtoggrønt.setHints("Her kan du købe frugt og grønt");

        kød.setExit("markedsplads", markedsplads);
        kød.setHints("Her kan du købe kød");

        village.setExit("markedsplads", markedsplads);
        village.setHints("Her er tre mennesker som har brug for din hjælp til at købe næringsrigt mad");

        currentRoom = village;

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
            System.out.println("Ugyldig kommando");
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
        System.out.println("Information om spillet og sult");
    }

    public void settings() {
        System.out.println("Settings");
        System.out.println("Vi har ingen indstillinger at ændre");
    }

    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Tak fordi du spillede spillet. ");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Velkommen til World of Sult");
        System.out.println("World of Sult handler om FN's 2. verdensmål, 'Stop Sult'.");
        System.out.println("* Informationer omkring emnet *");

        

        System.out.println("Giv kommando '" + CommandWord.HELP + "' hvis du har brug for hjælp.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Ugyldig kommando ");
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
            if(currentRoom == kød) {
                items.printKød();
            }
            else if(currentRoom == frugtoggrønt) {
                items.printFrugtOgGrønt();
            }
        }
        else if (commandWord == CommandWord.VILLAGE) {
            goToVillage();
        }
        else if (commandWord == CommandWord.HINTS) {
            System.out.println(currentRoom.getHints());
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
                Humans male = new Humans("Mand", 30);
                System.out.println("Hej, jeg er en " + male.name + " og jeg er " + male.age + ", jeg har brug for ....");
            }
        }
        else if (commandWord == CommandWord.FEMALE){
            if (currentRoom == village){
                Humans female = new Humans("Kvinde", 30);
                System.out.println("Hej, jeg er en " + female.name + " og jeg er " + female.age + ", jeg har brug for ....");
            }
        }
        else if (commandWord == CommandWord.CHILD){
            if (currentRoom == village){
                Humans child = new Humans("Barn", 2);
                System.out.println("Hej, jeg er et " + child.name + " og jeg er " + child.age + ", jeg har brug for ....");
            }
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void pauseGame() {
        System.out.println("Spillet er sat på pause");
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
            System.out.println("Ugyldig kommando ...");
            return false;
        }
        if (commandWord == CommandWord.PAUSE) {
            // Unpauses the game
            System.out.println("Spillet er ikke længere på pause");
            System.out.println("Giv kommando '" + CommandWord.HELP + "' hvis du har brug for hjælp.");
            System.out.println();
            System.out.println(currentRoom.getLongDescription());
            wantToQuit = true;
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

        // First time quiz runs, it asks a question
        // The other questions are being called from "processQuizCommand
        //askQuestion(quizNumber);

        /*boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processQuizCommand(command);

            if(isQuizDone) {
                System.out.println("Du klarede quizen!");
                System.out.println("Du fik " + playerManager.getPoints() + " rigtige ud af " + answerList.size() + " spørgsmål");
            }
        }*/
    }

    public boolean read() {
        // Load Questions and Answers from file
        boolean canLoadFile = false;
        Path fileName = Path.of("haropgave.txt");
        String actual = null;
        try {
            System.out.println("can load");
            actual = Files.readString(fileName);
            canLoadFile = true;
        } catch (IOException e) {
            e.printStackTrace();
            canLoadFile = false;
            System.out.println("Can't load file");
        }
        return true;
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

    private boolean processQuizCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("Ugyldig kommando...");
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
            System.out.println("Køb hvad?");
            return;
        }
        String item = command.getSecondWord();
        if(items.buyItem(item)) {
            playerManager.addItemToInventory(item);
        }
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Hvor vil du hen?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Der er ingen vej!");
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
            System.out.println("Quit hvad?");
            return false;
        }
        else {
            // Hvis brugeren kun har skrevet "quit", returnere den true
            return true;
        }
    }
}
