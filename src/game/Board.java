package game;

public class Board {
    
    protected Player[][] board;
    protected int n, m;
    
    public Board(int n, int m) {
        this.n = n;
        this.m = m;
        board = new Player[n][m];
    }
    
    protected boolean set(int i, int j, Player rowIndex) {
        if (isEmpty(i, j)) {
            board[i][j] = rowIndex;
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
        int maxLength = 0;
        int currentLength = 0;
        
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
                                && board[i][reservedJ] != null && board[i][reservedJ].getMark() == board[i][j].getMark()) {
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
    
    
    
    
    
    
    
    
    
    
    
    
  /*  //horizontal
    char[] horizontalArr = new char[m];
    //builds a new array similar to the original row
        for (int k = 0; k < m; k++) {
        if (board[i][k] == null) {
            k++;
        } else {
            horizontalArr[k] = board[i][k].getMark();
        }
    }
    int k = j;
    int counter = 1;
        while (k < m && horizontalArr[k + 1] == horizontalArr[k]) {
        counter++;
        k++;
    }
    k = j;
        while (k > 0 && horizontalArr[k - 1] == horizontalArr[k]) {
        counter++;
        k--;
    }
    longestLine = counter;
    
    //vertical
    char[] verticalArr = new char[n];
    //builds a new array similar to the original column
        for (k = 0; k < n; k++) {
        if (board[k][j] == null) {
            k++;
        } else {
            verticalArr[k] = board[k][j].getMark();
        }
    }
    k = i;
    counter = 1;
        while (k < n && verticalArr[k + 1] == verticalArr[k]) {
        counter++;
        k++;
    }
    k = i;
        while (k > 0 && verticalArr[k - 1] == verticalArr[k]) {
        counter++;
        k--;
    }
    longestLine = Math.max(counter, longestLine);
    
    //Main diagonal
    int rowIndex = i, columnIndex = j, length = 0;
    //checks the length of the main diagonal containing the current cell
    int downWardsLength = 0;
        while (rowIndex < n && columnIndex < m) {
        downWardsLength++;
        rowIndex++;
        columnIndex++;
    }
    rowIndex = i;
    columnIndex = j;
    int upWardsLength = 0;
        while (rowIndex > 0 && columnIndex > 0) {
        upWardsLength++;
        rowIndex--;
        columnIndex--;
    }
        if (columnIndex > rowIndex) {
        k = rowIndex;
    } else {
        k = columnIndex;
    }
    char[] mainDiagonalArr = new char[upWardsLength + downWardsLength];
        for (int l = 0; l < mainDiagonalArr.length; l++) {
        if (board[rowIndex][columnIndex] == null) {
            l++;
        } else {
            mainDiagonalArr[l] = board[rowIndex++][columnIndex++].getMark();
        }
    }
    counter = 1;
        while (k > 0 && mainDiagonalArr[k - 1] == mainDiagonalArr[k]) {
        counter++;
        k--;
    }
    k = i;
        while (k < downWardsLength && mainDiagonalArr[k + 1] == mainDiagonalArr[k]) {
        counter++;
        k++;
    }
    longestLine = Math.max(counter, longestLine);
    
    //secondary
    length = 0;
    rowIndex = i;
    columnIndex = j;
    //checks the length of the secondary diagonal containing the current cell
        while (rowIndex > 0 && columnIndex < m) {
        length++;
        rowIndex--;
        columnIndex++;
    }
    rowIndex = i;
    columnIndex = j;
        while (rowIndex < n && columnIndex > 0) {
        length++;
        rowIndex++;
        columnIndex--;
    }
        
        if (columnIndex > rowIndex) {
        k = rowIndex;
    } else {
        k = columnIndex;
    }
    char[] secondaryDiagonalArr = new char[length];
        for (int l = 0; l < length; l++) {
        if (board[rowIndex][columnIndex] == null) {
            l++;
        } else {
            secondaryDiagonalArr[l] = board[rowIndex--][columnIndex++].getMark();
        }
    }
    counter = 1;
        
        while (rowIndex > 0 && secondaryDiagonalArr[rowIndex - 1] == secondaryDiagonalArr[rowIndex]) {
        counter++;
        rowIndex--;
    }
    rowIndex = i;
        while (rowIndex < length && secondaryDiagonalArr[rowIndex + 1] == mainDiagonalArr[rowIndex]) {
        counter++;
        rowIndex++;
    }
    longestLine = Math.max(counter, longestLine);
        
        return longestLine;*/
