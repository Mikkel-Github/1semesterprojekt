package worldofzuul;

public enum CommandWord
{
    GO("go"), CONTINUE("continue"), QUIT("quit"),
    HELP("help"), UNKNOWN("?"), START("start"),
    INFO("info"), SETTINGS("settings"), BUY("buy"),
    A("a"), B("b"), C("c"), D("d"),
    QUIZ("quiz");
    
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
