package game;

public class Board {
    
    protected Player[][] board;
    protected int n, m;
    
    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        board = new Player[n][m];
    }
    
    protected boolean set(int i, int j, Player p) {
        if (isEmpty(i, j)) {
            board[i][j] = p;
            return true;
        }
        return false;
    }
    
    public boolean isEmpty(int i, int j) {
        return board[i][j] == null;
    }
    
    public Player get(int i, int j) {
        return isEmpty(i, j) ? null : board[i][j];
    }
    
    public boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public String toString() {
        String str = new String();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isEmpty(i, j)) {
                    str += ".";
                } else {
                    str += (board[i][j].getMark());
                }
            }
            str += ("\n");
        }
        return str;
    }
    
    protected int maxLineContaining(int i, int j) {
        int maxLength;
        int currentLength;
        
        maxLength = rayLength(i, j, 0, 1) + rayLength(i - 1, j, 0, -1); // vertical ray
        
        currentLength = rayLength(i, j, 1, 0) + rayLength(i, j - 1, -1, 0); // horizontal ray
        maxLength = Math.max(maxLength, currentLength);
        
        currentLength = rayLength(i, j, 1, 1) + rayLength(i - 1, j - 1, -1, -1); // main diagonal
        maxLength = Math.max(maxLength, currentLength);
        
        currentLength = rayLength(i, j, -1, 1) + rayLength(i - 1, j + 1, 1, -1); // secondary diagonal
        maxLength = Math.max(maxLength, currentLength);
        
        return maxLength;
    }
    
    //returns the ray length of the chosen direction
    private int rayLength(int i, int j, int dx, int dy) {
        
        int reservedI = i;
        int reservedJ = j;
        int counter = 0;
        
        switch (dx) {
            // vertical line
            case 0:
                switch (dy) {
                    case 1:
                        while (reservedI < n && board[reservedI][j] != null
                                && board[reservedI][j].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedI++;
                        }
                        break;
                    case -1:
                        while (reservedI > -1 && board[reservedI][j] != null
                                && board[reservedI][j].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedI--;
                        }
                        break;
                }
                break;
            // rightward horizontal or diagonal
            case 1:
                switch (dy) {
                    case 0:
                        while (reservedJ < m && board[i][reservedJ] != null
                                && board[i][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedJ++;
                        }
                        break;
                    case 1:
                        while (reservedJ < m && reservedI < n && board[reservedI][reservedJ] != null
                                && board[reservedI][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedI++;
                            reservedJ++;
                        }
                        break;
                    case -1:
                        while (reservedJ < m && reservedI > -1 && board[reservedI][reservedJ] != null
                                && board[reservedI][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedJ++;
                            reservedI--;
                        }
                        break;
                }
                break;
            // leftward horizontal or diagonal
            case -1:
                switch (dy) {
                    case 0:
                        while (reservedJ > -1 && board[i][reservedJ] != null
                                && board[i][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedJ--;
                        }
                        break;
                    case 1:
                        while (reservedJ > -1 && reservedI < n && board[reservedI][reservedJ] != null
                                && board[reservedI][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedJ--;
                            reservedI++;
                        }
                        break;
                    case -1:
                        while (reservedJ > -1 && reservedI > -1 && board[reservedI][reservedJ] != null
                                && board[reservedI][reservedJ].getMark() == board[i][j].getMark()) {
                            counter++;
                            reservedI--;
                            reservedJ--;
                        }
                        break;
                }
                break;
        }
        return counter;
    }
}