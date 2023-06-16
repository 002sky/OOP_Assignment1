
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //create the BudgetCalculator object and the scanner object
        BudgetCalculator BG = new BudgetCalculator();
        Scanner keyboard = new Scanner(System.in);
        //a while loop for continue the program if there is a wrong input from user
        while (true) {
            //try catch
            try {
                System.out.print("Enter Your Age: ");
                int age = keyboard.nextInt();
                BG.setAge(age);
                keyboard.nextLine();
                String isMarried;
                do {
                    System.out.println("Have You Married? (Yes/No)");
                    isMarried = keyboard.nextLine();
                } while (CheckYesNO(isMarried));

                BG.setIsMarried(isMarried.toLowerCase().matches("yes"));

                String dependent;
                do {
                    System.out.println("Do you have Dependent? (Yes/No)");
                    dependent = keyboard.nextLine();
                } while (CheckYesNO(dependent));

                if (dependent.toLowerCase().matches("yes")) {
                    BG.setHasDependent(true);
                    int NoOfDependents;
                    do {
                        System.out.println("How many dependent, do you have?");
                        NoOfDependents = keyboard.nextInt();
                        BG.setNoOfDependent(NoOfDependents);
                        keyboard.nextLine();
                    } while (NoOfDependents <= 0);

                } else {
                    BG.setHasDependent(false);
                }
                String isCarOwner;
                do {
                    System.out.println("Do you own a car? (Yes/No)");
                    isCarOwner = keyboard.nextLine();
                } while (CheckYesNO(isCarOwner));


                BG.setCarOwner(isCarOwner.toLowerCase().matches("yes"));

                System.out.println("Thank You For Answering the Question.\n");

                System.out.println("Below are the budget in Johor Bahru Area: \n ");

                BG.displayJohorBudget();

                System.out.println("\nYou Monthly Income is: ");
                double MonthlyIncome = keyboard.nextDouble();
                BG.setMonthlyIncome(MonthlyIncome);
                BG.calUserBudget();
                break;

            } catch (Exception e) {
                System.out.println("Please enter the correct input");
                keyboard.next();
            }
        }
        BG.displayMessage();
    }

    private static boolean CheckYesNO(String Answer) {
        if (Answer.toLowerCase().matches("yes") || Answer.toLowerCase().matches("no")) {
            return false;
        } else {
            System.out.println("Please enter yes and no");
        }
        return true;
    }
}