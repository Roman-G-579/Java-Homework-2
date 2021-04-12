package game;

import java.util.Scanner;

public class Game extends Board {
    
    protected Player[] players;
    protected Scanner s = new Scanner(System.in);
    
    public Game(int n, int m, Player p1, Player p2) {
        super(n, m);
        players = new Player[2];
        players[0] = p1;
        players[1] = p2;
    }
    
    protected boolean doesWin(int i, int j) {
        return i == 0 && j == 0;
    }
    
    protected boolean onePlay(Player p) {
        System.out.println(p.toString() + ", please enter x and y:");
        int x = s.nextInt();
        int y = s.nextInt();
        
        while (!isEmpty(x, y)) {
            System.out.println("This cell is already taken...");
            x = s.nextInt();
            y = s.nextInt();
        }
        board[x][y] = p;
        
        if (doesWin(x, y)) {
            System.out.println(p + " Won!");
            return true;
        }
        return false;
    }
    
    public Player play() {
        while (!isFull()) {
            if (onePlay(players[0])) {
                return players[0];
            }
            if (onePlay(players[1])) {
                return players[1];
            }
            //NO HABLE ESPANOL
        }
        return null;
    }
    
}
