import java.util.*;

public class battleship {
    private static final int cruiser = 2;
    private static final int submarine = 2;
    private static final int ptBoat = 1;
    private static final int battleship = 3;
    private static final int aircraftCarrier = 4;
    // ship placement
    private static void PlaceShips(int ship) {
        int validCounter = 0;
        boolean sentinel = false;
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
                    if (board[row+i][col].equals("\uD83C\uDF0A")){
                        // verifying length
                        validCounter++;
                        System.out.println("yippee");
                    }
               }

           } while (validCounter!=(ship+1));
           // valid = true, ship placement is allowed
           for (int i = 0; i <= ship; i++){
               board[row+i][col] = "\uD83D\uDEA2";
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
                   if (board[row][col+i].equals("\uD83C\uDF0A")){
                       // verifying length
                       validCounter++;
                       System.out.println("yippee");
                   }
               }

           } while (validCounter!=(ship+1));
           // valid = true, ship placement is allowed
           for (int i = 0; i <= ship; i++){
               board[row][col+i] = "\uD83D\uDEA2";
               System.out.println("yippee ship placed");
           }
       }
    }
    // checking for if the shot overlaps or not
    private static boolean validPlayerMove(int row, int col){
        boolean valid = false;

        if (board[row][col].equals("\uD83C\uDF0A")){
            valid = true;
        }
        else {
            System.out.println("That is an invalid place to move, pick somewhere else.");
        }

        return valid;
    }
    // methods for board/board info
    private static final int ROW = 11;
    private static final int COL = 11;
    private static final String[][] board = new String[ROW][COL];
    // board clearing to restart
    private static void clearBoard() {

        for (int row = 0; row < ROW; row++){

            for (int col = 0; col < COL; col++){

                board[row][col] = "\uD83C\uDF0A";

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
    private static void display() {

        for (int row = 0; row < ROW; row++){

            System.out.println("| ");
            for (int col = 0; col < COL; col++){

                System.out.print(board[row][col]+ " | ");

            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        String rowMove = "";
        int colMove = 0;
        // declaring the scanner
        Scanner in = new Scanner(System.in);
        // prepping board
        clearBoard();
        display();
        PlaceShips(aircraftCarrier);
        PlaceShips(ptBoat);
        PlaceShips(cruiser);
        PlaceShips(battleship);
        PlaceShips(submarine);
        display();
    }
}
