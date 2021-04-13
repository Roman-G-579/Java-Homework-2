package game;

public class Player {
    
    private String name;
    private char mark;
    
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }
    
    // returns the name of the player
    public String getName() {
        return name;
    }
    
    // returns the mark of the player
    public char getMark() {
        return mark;
    }
    
    // returns a phrase containing the player's name and mark
    public String toString() {
        return name + "(" + mark + ")";
    }
}
