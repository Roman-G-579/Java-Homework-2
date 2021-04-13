package game;

public class TicTacToe extends Game {
    
    public TicTacToe(String player1, String player2) {
        super(3, 3, new Player(player1, 'X'), new Player(player2, 'O'));
    }
    
    //checks if the current move is a winning one
    @Override
    protected boolean doesWin(int x, int y) {
        return maxLineContaining(x, y) == 3;
    }
}
