package worldofzuul;

public enum CommandWord
{
    GO("go"), CONTINUE("continue"), QUIT("quit"),
    HELP("help"), UNKNOWN("?"), START("start"),
    INFO("info"), SETTINGS("settings"), BUY("buy"),
    INVENTORY("inventory"), MALE("male"), FEMALE("female"),
    CHILD("child");

    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
