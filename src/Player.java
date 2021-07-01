import java.util.Scanner;

public class Player {
    // attributes of class person
    String turn;
    String name;
    //Symbol symbol;

   // enum Symbol{
//        X,
//        O
//
//    }
    Scanner scan = new Scanner(System.in);// use of scanner class to accept input
    Player(String turn){
        this.turn = turn;
    }
//method to accept name of users
    void acceptName(Player person){

        System.out.println("Hello "+person.turn+", Please enter your name: ");
        System.out.print(">");
        try{
            person.name = scan.nextLine();

        } catch (Exception e){
            System.out.println("Wrong input");
            acceptName(person);
        }

    }


}
