import java.util.Scanner;

public class BeerBottlesGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bottles = 21;
        int userPicked, compPicked;
        System.out.println("There are 21 beer bottles...");
        System.out.println("Computer and yourself, there are 2 players");
        System.out.println("At a time, each one can pick up any number of bottles between 1 and 4 (inclusive)");
        System.out.print("Will you like to play first? ");
        String response = scanner.nextLine();
        boolean userTurn = response.equalsIgnoreCase("Yes");
        while (bottles > 0) {
            if (userTurn) {
                System.out.print("How many you would like to pick up? ");
                userPicked = scanner.nextInt();
                bottles -= userPicked;
                System.out.println("The bottles remaining are: " + bottles);
                if (bottles == 0) {
                    System.out.println("You will have to pick up the last..you are loser");
                    break;
                }
            } else {
                compPicked = pickBottles(bottles);
                bottles -= compPicked;
                System.out.println("Computer has picked " + compPicked);
                System.out.println("The bottles remaining are: " + bottles);
                if (bottles == 0) {
                    System.out.println("Computer will have to pick up the last..Computer is loser");
                    break;
                }
            }
            userTurn = !userTurn;
        }
        scanner.close();
    }

    private static int pickBottles(int remainingBottles) {
        int maxPick = Math.min(4, remainingBottles);
        int compPicked = remainingBottles % 5;
        if (compPicked == 0) {
            compPicked = 1;
        }
        return compPicked;
    }
}
