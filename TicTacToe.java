import java.util.*;
class TicTacToe {
    String[] board = new String[]{"1","2","3","4","5","6","7","8","9"};
    int victory;
    static int wins = 0;
    Scanner scan = new Scanner(System.in);
    /*Introduction of the game and the board. */
    public static void main(String[] args) {
        System.out.print("Welcome to the Tic-Tac-Toe World!!!");
        new TicTacToe().scan.nextLine();
        System.out.print("In this world, Tic-Tac-Toe is the only game played by the inhabitants.");
        new TicTacToe().scan.nextLine();
        System.out.print("To play with better players you need to defeat Tom");
        new TicTacToe().scan.nextLine();
        System.out.print("who is considered the weakest player.");
        new TicTacToe().scan.nextLine();
        System.out.print("However, you need to defeat him continuosly for one year every day!!!");
        new TicTacToe().scan.nextLine();
        System.out.print("Well enough talk. Let's begin the match. Choose your position: ");
        int position = new TicTacToe().checkInt();
        while(position != 1 && position != 2){
            System.out.println("\nIt must be either 1 or 2. Either you start first or Tom starts first.");
            System.out.print("Please Choose your Fighter: ");
            position = new TicTacToe().checkInt();
        }
        new TicTacToe().startGame(position);
        System.out.println("Thank you for playing! Would you like to play again.");
        System.out.println("Press 1 to play again, or any other number to escape the world.");
        int retry = new TicTacToe().checkInt();
        if(retry == 1){
            while(new TicTacToe().playAgain()) {
            }
        }
        System.out.println("Hope You Had A Nice Stay In This World and said Thank You to Tom!");
        new TicTacToe().scan.close();
    }

    /*Method to print board */
    public void printBoard() {
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
        int turn = 0;
        printBoard();
        if(position == 2) {
            System.out.println("It is Tom's Turn. Please give him time to play his turn.");
            tomsTurn();
            turn++;
        }
        while(true){
            System.out.println("Type a number shown in the board to place \"X\": ");
            int point = checkInt();
            scan.nextLine();
            if(point == 0) {
                System.out.println("Please input the numbers available on the board.");
                continue;
            }
            if(board[point-1] != "O" && board[point-1] != "X") {
                board[point-1] = "X";
                turn++;
                if(gameCondition(turn, "X")) {
                    victory = 1;
                    break;
                }
                System.out.println("It is Tom's Turn. Please give him time to play his turn.");
                tomsTurn();
                turn++;
                if(gameCondition(turn, "O")) {
                    victory = 2;
                    break;
                }
            } else {
                System.out.println("Please input the numbers available on the board.");
            }
        }if(turn == 9){
            System.out.println("OH That was close match. I guess you are safe and your wins counter is same.");
            System.out.print("You have to win against Tom another ");
            System.out.print(100-wins);
            System.out.println(" times.");
        }else if(victory ==1) {
            wins++;
            System.out.print("Congrats you won against Tom. Well you have to beat him another ");
            System.out.print(100-wins);
            System.out.println(" times.");
        } else if (victory == 2){
            wins = 0;
            System.out.println("Better Luck Next time.");
            System.out.println("Now your wins counter has resetted. Better leave this world now.");
        } else {

        }
    }

    public void tomsTurn() {
        Random random = new Random();
        boolean turnOver = false;
        do{
            int nextNumber = random.nextInt(9);
            if(board[nextNumber] != "O" && board[nextNumber] != "X") {
                board[nextNumber] = "O";
                turnOver = true;
            }
        } while(!turnOver);
        printBoard();
    }

    public boolean gameCondition(int turnNumber, String mark) {
        if(turnNumber == 9) {
            return true;
        }
        if(board[0] == mark) {
            if(board[1] == mark && board[2] == mark){
                return true;
            } else if(board[3] == mark && board[6] == mark) {
                return true;
            } else if(board[4] == mark && board[8] == mark) {
                return true;
            }
        }
        if(board[4] == mark){
            if(board[3] == mark && board[5] == mark){
                return true;
            } else if(board[1] == mark && board[7] == mark){
                return true;
            } else if(board[2] == mark && board[6] == mark){
                return true;
            }
        }
        if(board[8] == mark){
            if(board[2] == mark && board[5] == mark){
                return true;
            } else if(board[7] == mark && board[6] == mark){
                return true;
            }
        }
        return false;
    }

    public boolean playAgain() {
        System.out.print("Choose Your Position: ");
        int position = checkInt();
        while(position != 1 && position != 2){
            System.out.println("\nIt must be either 1 or 2. Either you start first or Tom starts first.");
            System.out.print("Please Choose your Fighter: ");
            position = checkInt();
        }
        startGame(position);
        System.out.println("Thank you for playing! Would you like to play again.");
        System.out.println("Press 1 to play again, or any other key except enter to escape the world.");
        int retry = checkInt();
        if(retry == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int checkInt() {
        String value= scan.next();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }
}