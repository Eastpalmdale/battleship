import java.util.*;

public class battleship {
    // declaring ship sizes
    private static final int cruiser = 2;
    private static final int submarine = 2;
    private static final int ptBoat = 1;
    private static final int battleship = 3;
    private static final int aircraftCarrier = 4;
    // ship placement
    private static void PlaceShips(int ship) {
        int validCounter;
        int row;
        int col;
                Random rnd = new Random();

        int horizontalOrVertical = rnd.nextInt(2);
        // vertical placement
       if (horizontalOrVertical==0){
           // loop for placement
           do {
               validCounter = 0;
               row = rnd.nextInt(10-ship); // space allocation
               col = rnd.nextInt(10-ship + 1); // space allocation
               // declaring placement
               System.out.println("vertically placing "+ship+" in position "+row+" "+col);
               for (int i = 0; i <= ship; i++){
                    if (board[row+i][col].equals(" -")){
                        // verifying length
                        validCounter++;
                        System.out.println("yippee");
                    }
               }

           } while (validCounter!=(ship+1));
           // valid = true, ship placement is allowed
           for (int i = 0; i <= ship; i++){
               board[row+i][col] = " %";
               System.out.println("yippee ship placed");
           }
       }
       // horizontal placement
       else {
           do {
               validCounter = 0;
               row = rnd.nextInt(10-ship + 1); // space allocation
               col = rnd.nextInt(10-ship); // space allocation
               // declaring placement
               System.out.println("horizontally placing "+ship+" in position "+row+" "+col);
               for (int i = 0; i <= ship; i++){
                   if (board[row][col+i].equals(" -")){
                       // verifying length
                       validCounter++;
                       System.out.println("yippee");
                   }
               }

           } while (validCounter!=(ship+1));
           // valid = true, ship placement is allowed
           for (int i = 0; i <= ship; i++){
               board[row][col+i] = " %";
               System.out.println("yippee ship placed");
           }
       }
    }
    // checking for if the shot overlaps or not
    private static boolean playerMove(){
        // initialization
        Scanner in = new Scanner(System.in);
        boolean valid;
        boolean loopA = false;
        boolean loopB = false;
        int hitRegister = 0;
        int missRegister = 0;
        int strike  = 0;
        displayGameBoard();
        System.out.println("What is your move?");
        // gathering move data
        int rowMove = safeinput.getRangedInt(in, "Column move:", 1, 10);
        String letteringColumn = safeinput.getRegExString(in, "Row move:", "[aAbBcCdDeEfFgGhHiIjJ]");
        letteringColumn = letteringColumn.toUpperCase();
        int colMove = 0;
        // transferring column input into numbers (in reality this is row, just too lazy to rename it all)
        switch (letteringColumn) {
            case "A":
                colMove = 1;
                break;
            case "B":
                colMove = 2;
                break;
            case "C":
                colMove = 3;
                break;
            case "D":
                colMove = 4;
                break;
            case "E":
                colMove = 5;
                break;
            case "F":
                colMove = 6;
                break;
            case "G":
                colMove = 7;
                break;
            case "H":
                colMove = 8;
                break;
            case "I":
                colMove = 9;
                break;
            case "J":
                colMove = 10;
                break;
        }
            valid = valdiation(colMove,rowMove);
        return valid;
    }
    // player move checks to make sure they are valid
    public static boolean valdiation(int rowMove, int colMove){
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        boolean hit = false;
        int strike  = 0;
        // move validation, also checking for overlap
        if (board[rowMove][colMove].equals(" -") || board[rowMove][colMove].equals("MISS") || board[rowMove][colMove].equals("HIT")) {
            board[rowMove][colMove] = ("MISS");
            displayBoard[rowMove][colMove] = ("MISS");
            System.out.println("You missed, or shot an old position");
        }
        else {
            // valid move qualified'
            System.out.println("You hit a ship!");
            board[rowMove][colMove] = ("HIT");
            displayBoard[rowMove][colMove] = ("HIT");
            valid = true;
        }


        // returning if the hit was valid or not valid
        return valid;
    }

    // methods for board/board info
    private static final int ROW = 11;
    private static final int COL = 11;
    private static final String[][] board = new String[ROW][COL];
    private static final String[][] displayBoard = new String[ROW][COL];
    // ship, non-displayed board clearing to restart
    private static void clearBoard() {

        for (int row = 0; row < ROW; row++){

            for (int col = 0; col < COL; col++){

                board[row][col] = " -";

            }
        }
        // lettering left side
        board[0][0] = "X";
        board[1][0] = "A";
        board[2][0] = "B";
        board[3][0] = "C";
        board[4][0] = "D";
        board[5][0] = "E";
        board[6][0] = "F";
        board[7][0] = "G";
        board[8][0] = "H";
        board[9][0] = "I";
        board[10][0] = "J";
        // numbering top
        board[0][0] = "0";
        board[0][1] = "1 ";
        board[0][2] = "2 ";
        board[0][3] = "3";
        board[0][4] = "4 ";
        board[0][5] = "5 ";
        board[0][6] = "6 ";
        board[0][7] = "7 ";
        board[0][8] = "8 ";
        board[0][9] = "9 ";
        board[0][10] = "10";
    }
    // board with the ships recorded, non displayed
    private static void display() {

        for (int row = 0; row < ROW; row++){

            System.out.println("| ");
            for (int col = 0; col < COL; col++){

                System.out.print(board[row][col]+ " | ");

            }
            System.out.println();
        }

    }
    // clearing the displayed board and setting up spaces
    private static void clearGameBoard() {

        for (int row = 0; row < ROW; row++){

            for (int col = 0; col < COL; col++){

                displayBoard[row][col] = " -";

            }
        }
        // lettering left side
        displayBoard[0][0] = "X";
        displayBoard[1][0] = "A";
        displayBoard[2][0] = "B";
        displayBoard[3][0] = "C";
        displayBoard[4][0] = "D";
        displayBoard[5][0] = "E";
        displayBoard[6][0] = "F";
        displayBoard[7][0] = "G";
        displayBoard[8][0] = "H";
        displayBoard[9][0] = "I";
        displayBoard[10][0] = "J";
        // numbering top
        displayBoard[0][0] = "0";
        displayBoard[0][1] = "1 ";
        displayBoard[0][2] = "2 ";
        displayBoard[0][3] = "3";
        displayBoard[0][4] = "4 ";
        displayBoard[0][5] = "5 ";
        displayBoard[0][6] = "6 ";
        displayBoard[0][7] = "7 ";
        displayBoard[0][8] = "8 ";
        displayBoard[0][9] = "9 ";
        displayBoard[0][10] = "10";
    }
    // displayed board setup, no ships "placed" (Cross-references non-displayed board for ships)
    private static void displayGameBoard() {

        for (int row = 0; row < ROW; row++){

            System.out.println("| ");
            for (int col = 0; col < COL; col++){

                System.out.print(displayBoard[row][col]+ " | ");

            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        // declaring the scanner
        boolean gameEnd = false;
        boolean loopExit = false;
        boolean valid = false;
        int missRegister = 0;
        int hitRegister = 0;
        int strike = 0;
        Scanner in = new Scanner(System.in);
        // prepping board
        clearBoard();
        clearGameBoard();
        PlaceShips(aircraftCarrier);
        PlaceShips(ptBoat);
        PlaceShips(cruiser);
        PlaceShips(battleship);
        PlaceShips(submarine);

        do {
            missRegister = 0;
            strike = 0;
            hitRegister = 0;
            loopExit = false;
            valid = false;
            gameEnd = false;
            clearGameBoard();
            clearBoard();
            do {
                valid = playerMove();
                if (!valid){
                    missRegister++;
                    System.out.println("miss added, "+missRegister+" total miss/misses");
                    // checking for miss volume
                    if (missRegister == 5) {
                        // adding strike
                        missRegister = 0;
                        strike++;
                        System.out.println("strike added, clearing misses and adding strike, "+strike+" total strike/strikes");
                    }
                    // ending match if there are 3 strikes
                    if (strike == 3) {
                        loopExit = true;
                        System.out.println("You missed way too much for your own good, you lost");
                    }
                }
                else {
                    hitRegister++;
                }
                if (hitRegister == 17){
                    loopExit = true;
                }
            } while (!loopExit);
            gameEnd = safeinput.getYNConfirm(in,"Are you done playing?");
        } while (!gameEnd);


    }
}
