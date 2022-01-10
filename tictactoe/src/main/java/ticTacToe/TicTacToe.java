
package ticTacToe;

public class TicTacToe {
    private String[][] ticTacToe;
    private String turn;
    
    public TicTacToe() {
        this.ticTacToe = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        this.turn = "X";
    }
    
    public String status(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return "";
        }
        return this.ticTacToe[x][y];
    }
    
    public void place(int x, int y) {
        if (x < 0 || y < 0 || x > 2 || y > 2) {
            return;
        }
        if (!this.ticTacToe[x][y].equals(" ")) {
            return;
        }
        if (gameEnded()) {
            return;
        }
        this.ticTacToe[x][y] = this.turn;
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else {
            this.turn = "X";
        }
    }
    
    public boolean gameEnded() {
        int[][] posToCheck = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {2, 4, 6},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
        };
        for (int i = 0; i < posToCheck.length; i++) {
            if (sameValsInPlaces(posToCheck[i])) {
                return true;
            }
        }
        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                if (this.ticTacToe[x][y].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public String getTurn() {
        return this.turn;
    }
    
    public boolean sameValsInPlaces(int[] arr) {
        String[] symbols = new String[] {getSymbol(arr[0]), getSymbol(arr[1]), getSymbol(arr[2])};
        return (!symbols[0].trim().equals("")) && symbols[0].equals(symbols[1]) && symbols[0].equals(symbols[2]);
            
        
    }
    
    public String getSymbol(int place) {
        int x = place % 3;
        int y = place / 3;
        return status(x, y);
    }
}
