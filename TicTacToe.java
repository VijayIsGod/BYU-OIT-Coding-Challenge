import java.util.*;
class TicTacToe {
    String[] board = new String[]{"1","2","3","4","5","6","7","8","9"};
    /*Introduction of the game and the board. */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Tic-Tac-Toe World!!!");
        input.nextLine();
        System.out.print("In this world, Tic-Tac-Toe is the only game played by the inhabitants.");
        input.nextLine();
        System.out.print("To play with better players you need to defeat Tom");
        input.nextLine();
        System.out.print("who is considered the weakest player.");
        input.nextLine();
        System.out.print("However, you need to defeat him continuosly for one year every day!!!");
        input.nextLine();
        System.out.print("Well enough talk. Let's begin the match. Choose your position: ");
        int position = input.nextInt();
        while(position != 1 && position != 2){
            System.out.println("\nIt must be either 1 or 2. Either you start first or Tom starts first.");
            System.out.print("Please Choose your Fighter: ");
            position = input.nextInt();
        }
        input.close();
        // new TicTacToe().printBoard(new TicTacToe().board);
        new TicTacToe().startGame(position);
    }

    /*Method to print board */
    public void printBoard(String[] array) {
        String display = "\n"+"-------------------------------------------------";
        display += "\n|\t"+board[0]+"\t|\t"+board[1]+"\t|\t" + board[2]+"\t|";
        display += "\n"+"-------------------------------------------------";
        display += "\n|\t"+board[3]+"\t|\t"+board[4]+"\t|\t" + board[5]+"\t|";
        display += "\n"+"-------------------------------------------------";
        display += "\n|\t"+board[6]+"\t|\t"+board[7]+"\t|\t" + board[8]+"\t|";
        display += "\n"+"-------------------------------------------------";
        System.out.println(display);
    }
    
    public void startGame(int position){
        Scanner player = new Scanner(System.in);
        int turn = 0;
        while(true){
            printBoard(board);
            if(position ==2) {
                System.out.println("It is Tom's Turn. Please give him time to play his turn.");
                tomsTurn();
                turn++;
                if(gameCondition(turn)) {
                    break;
                }
            }
            System.out.println("Type a number shown in the board to place \"X\": ");
            int point = player.nextInt();
            if(board[point-1] != "O" && board[point-1] != "X") {
                board[point-1] = "X";
                turn++;
                if(gameCondition(turn)) {
                    break;
                }
                tomsTurn();
                turn++;
                if(gameCondition(turn)) {
                    break;
                }
            } else {
                System.out.println("Please input the number's available on the board.");
            }
        }
    }

    public void tomsTurn() {

    }

    public boolean gameCondition(int turnNumber) {
        boolean gameOver = false;
        return gameOver;
    }
}