import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Neighbors n = new Neighbors();
        while (!n.isFull()){
            n.printBoard();
            int random = n.rollDice();
            System.out.println("Rolling the die ...");
            System.out.println("\nThe number rolled is " + random);
            while (true){
                System.out.println("In which row would you like to place the number");
                int row = s.nextInt();
                System.out.println("In which row would you like to place the number");
                int col = s.nextInt();
                if (n.isValid(row, col) && n.placeNumber(row, col, random)){
                    break;
                }
                System.out.println("That coordinate is either invalid or already has a number. Try again");
            }
            

        }
        System.out.println("You scored " + n.addUp() + ". Good job :)");
    }
}
