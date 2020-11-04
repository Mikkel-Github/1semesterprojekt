package worldofzuul;

public enum CommandWord
{
    GO("go"), CONTINUE("continue"), QUIT("quit"), HELP("help"), UNKNOWN("?"), START("start"), INFO("info"), SETTINGS("settings");
    
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
