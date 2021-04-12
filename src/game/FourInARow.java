package game;

import java.util.Scanner;

public class FourInARow extends Game {
    
    public FourInARow(String player1, String player2) {
        super(6, 7, new Player(player1, 'W'), new Player(player2, 'B'));
    }
    
    @Override
    protected boolean doesWin(int i, int j) {
        return maxLineContaining(i, j) == 4;
    }
    
    @Override
    protected boolean onePlay(Player p) {
        Scanner s = new Scanner(System.in);
        System.out.println(p.toString() + ", please enter Column:");
        int j = s.nextInt();
        
        while (!isEmpty(0, j)) {
            System.out.println("Please enter a new column:");
            j = s.nextInt();
        }
        
        int i = 5;
        while (!isEmpty(i, j)) {
            i--;
        }
        set(i, j, p);
        return doesWin(i, j);
    }
}
