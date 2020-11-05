package worldofzuul;

public class Humans {
    private String humans;

    public String humans(String humans){
        this.humans = humans;
        return this.humans;
    }

    private void setHumans(){
        this.humans += 2;
    }

    protected String getHumans(){
        return this.humans;
    }
}