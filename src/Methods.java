import java.util.Scanner;

public class Methods {
    int playerRow;
    int playerCol;
    Scanner scan = new Scanner(System.in); //Scanner to accept input
    //method to create board
    void createBoard(char[][] rowAndCols){
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                rowAndCols[i][j] = ' ';
            }
        }
    }

    //method to display/draw board
    void showBoard(char[][] rowAndCols){
        System.out.println(" _ _ _");
        for(int i = 0; i<3; i++){
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(rowAndCols[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println(" _ _ _");
    }
    //method to check if a player has won
    char hasWon(char[][] rowAndCols){
        for(int i = 0; i < 3; i++){
            if (rowAndCols[i][0] == rowAndCols[i][1] && rowAndCols[i][1] == rowAndCols[i][2] && rowAndCols[i][2] != ' ' ){
                return rowAndCols[i][0];
            }
        }

        for(int i = 0; i<3; i++){
            if(rowAndCols[0][i] == rowAndCols[1][i] && rowAndCols[1][i] == rowAndCols[2][i] && rowAndCols[2][i] != ' '  ){
                return rowAndCols[0][i];
            }
        }
        if(rowAndCols[0][0] == rowAndCols[1][1] && rowAndCols[1][1] == rowAndCols[2][2] && rowAndCols[2][2] != 0){
            return rowAndCols[0][0];
        }
        if(rowAndCols[0][2] == rowAndCols[1][1] && rowAndCols[1][1] ==rowAndCols[2][0] && rowAndCols[2][0] != ' '){
            return rowAndCols[0][2];
        }
        return ' ';
    }
// method to check if its a draw
    boolean hasTied(char[][] rowAndCols){
        for(int i = 0; i<3; i++){
            for (int j=0; j<3; j++){
                if(rowAndCols[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
    // method to accept row input
    void acceptRow(){
        System.out.print(">");
        try{
            playerRow = scan.nextInt();
        } catch (Exception e){
            System.out.println("you should enter a number!");
            scan.next();
            acceptRow();
        }
    }
    //method to accept column input
    void acceptCol(){
        System.out.print(">");
        try{
            playerCol = scan.nextInt();
        } catch (Exception e){
            System.out.println("you should enter a number");
            scan.next();
            acceptCol();
        }
    }

}
