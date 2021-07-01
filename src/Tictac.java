public class Tictac {
    public static void main(String[] args) {
        Player player1 = new Player("First player");
        Player player2 = new Player("Second player");
        Methods does = new Methods();
        boolean isPlayer1 = true;
        boolean closeGame = false;
        char symbol;

        char[][] board = new char[3][3];

        does.createBoard(board);  //create an empty board for the game of row size 3 and column size 3

        player1.acceptName(player1); //accept First Players name

        player1.acceptName(player2); //accept Second Players name

        does.showBoard(board); //show board state
        System.out.println();

        while (!closeGame) {// this loop keeps going until game ends

            /*
            when its first players turn symbol to be updated on board becomes 'x' and when its
            seconds players turn 'o' is used to update moves played by second player
             */
            if (isPlayer1) {
                symbol = 'x';
                System.out.println("Its " + player1.name + "'s turn(x)");

            } else {
                symbol = 'o';
                System.out.println("Its " + player2.name + "'s turn(o)");
            }

            //this loop continue going until a valid move is made
            while (true) {
                System.out.println("Enter the coordinate of " + symbol + " : ");
                does.acceptRow(); //accepts row coordinate
                does.acceptCol(); //accepts col coordinate

                //check if row and column cordinates are valid
                if (does.playerRow > 3 || does.playerRow < 0 || does.playerCol > 3 || does.playerCol < 0) {
                    System.out.println("Your row and column coordinate is out of bond");
                } else if (board[does.playerRow - 1][does.playerCol - 1] != ' ') {
                    System.out.println("The entered position has already been played");
                } else {
                    //if valid move was made then break out of the loop
                    break;
                }
            }
            //update move at index with expected symbol
            board[does.playerRow - 1][does.playerCol - 1] = symbol;
           //show the board state
            does.showBoard(board);
            //check if the game state of the board is a win or draw and announce winner or print out its a tie
            if(does.hasWon(board) == 'x'){
                System.out.println();
                    System.out.println("voila " + player1.name +" has won");//annouce the winner
                    closeGame = true; //if game has been won return true to break the while loop
            }else if(does.hasWon(board) == 'o'){
                System.out.println();
                    System.out.println("voila " + player2.name +" has won");
                    closeGame = true; //if game has been won return true to break the while loop
            }else{
                // if not won, check if its a tie
                if(does.hasTied(board)){
                    System.out.println();
                    System.out.println("it is a tie");
                    closeGame = true;// if its a tie, annouce tie return true and break out of the loop
                }else{
                    isPlayer1 = !isPlayer1;//toogle between first player and second player after each successful turn
                }
            }

        }
    }
}
