public class Neighbors {
    private int[][] board = new int[5][5];

    public void printBoard(){
        System.out.println();
        for (int[] row : board){
            for (int i : row){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int rollDice(){
        return ((int) (Math.random() * 10 + 1));
    }

    public boolean placeNumber(int row, int col, int num){
        if (board[row][col] != 0){
            return false;
        }
        else{
            board[row][col] = num;
            return true;
        }
    }

    public boolean isValid(int row, int col){
        if (row < 0 || row > 4 || col < 0 || col > 4){
            return false;
        }
        return true;
    }

    public boolean isFull(){
        for (int[] row : board){
            for (int i : row){
                if (i == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public int addUp(){
        int sum = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if ((isValid(i, j - 1) && board[i][j - 1] == board[i][j]) || (isValid(i, j + 1) && board[i][j + 1] == board[i][j])){
                    sum += board[i][j];
                }
            }
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if ((isValid(i - 1, j) && board[i - 1][j] == board[i][j]) || (isValid(i + 1, j) && board[i + 1][j] == board[i][j])){
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }

}
