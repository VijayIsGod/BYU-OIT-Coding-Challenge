import java.util.Arrays;
class Challenge {
    public static void main(String[] args) {
        String[][] board = new String[5][5];
        for(int i = 0; i < 5; i++) {
            if(i%2 == 0) {
                for(int j = 1; j < 5; j=j+2) {
                    board[i][j] ="|";
                }    
            } else {
                Arrays.fill(board[i], "\u2014");
            }
        }
        Arrays.deepToString(board);
    }
}