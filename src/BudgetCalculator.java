
import java.util.LinkedHashMap;
import java.util.Map;

public class BudgetCalculator {
    private int age;
    private boolean isMarried;
    private boolean hasDependent;
    private int noOfDependent;
    private boolean isCarOwner;
    private double MonthlyIncome;
    private Map<String, Double> JohorBudget;
    private double shortTermSaving;
    private double mediumTermSaving;
    private double longTermSaving;
    private double wants;
    private double needs;


    BudgetCalculator() {
        //constructor which initial the object with some value
        this.age = 0;
        this.isMarried = false;
        this.hasDependent = false;
        this.noOfDependent = 0;
        this.isCarOwner = false;
        this.MonthlyIncome = 0;
        //create a linkedHashMap object
        this.JohorBudget = new LinkedHashMap<>();

        this.longTermSaving = 0;
        this.shortTermSaving = 0;
        this.mediumTermSaving = 0;
        this.wants = 0;
        this.needs = 0;

        //initial the map with the budget data
        this.JohorBudget.put("Single Public Transport User", 1760.00);
        this.JohorBudget.put("Single Car Owner", 2290.00);
        this.JohorBudget.put("Married without Children", 4110.00);
        this.JohorBudget.put("Married(1 Children)", 5360.00);
        this.JohorBudget.put("Married(2 Children)", 6100.00);
        this.JohorBudget.put("Senior Single", 2330.00);
        this.JohorBudget.put("Senior Couple", 3020.00);
        this.JohorBudget.put("Single Parent (1 Children)", 4200.00);
        this.JohorBudget.put("Single Parent (2 Children)", 4940.00);
    }

    //setter getter
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public boolean getIsMarried() {
        return isMarried;
    }

    public void setHasDependent(boolean hasDependent) {
        this.hasDependent = hasDependent;
    }

    public boolean getHasDependent() {
        return hasDependent;
    }

    public void setNoOfDependent(int noOfDependent) {
        this.noOfDependent = noOfDependent;
    }

    public int getNoOfDependent() {
        return noOfDependent;
    }

    public void setCarOwner(boolean isCarOwner) {
        this.isCarOwner = isCarOwner;
    }

    public boolean getCarOwner() {
        return isCarOwner;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        MonthlyIncome = monthlyIncome;
    }

    public double getMonthlyIncome() {
        return MonthlyIncome;
    }


    //The message display after all the calculation is done
    public void displayMessage() {
        System.out.println("Your age is: " + getAge());
        System.out.println("Your Married Status is: " + (getIsMarried() ? "Married" : "Single"));
        System.out.println("Your had dependent: " + (getHasDependent() ? "yes" : "no"));
        if (getHasDependent()) {
            System.out.println("The number of dependent you have is: " + getNoOfDependent());
        } else {
            System.out.print("");
        }
        System.out.println("Your are a car owner: " + getCarOwner());
        System.out.println("Your monthly income is: RM" + getMonthlyIncome());

        System.out.println("\nBased on Your Monthly income below are the suggested budget allocation for you");

        System.out.println("The Budget Allocation for Short Term Saving: " + shortTermSaving);
        System.out.println("The Budget Allocation for Medium Term Saving: " + mediumTermSaving);
        System.out.println("The Budget Allocation for Long Term Saving: " + longTermSaving);
        System.out.println("The Budget Allocation for wants: " + wants);
        System.out.println("The Budget Allocation for needs: " + needs);

        //compare the total expenses of user to the suggested data
        cmpTheExpenses();
    }

    public void displayJohorBudget() {
        //for each loop to display the data set from the linear hash map
        JohorBudget.forEach((key, value) -> System.out.println(key + " = " + "RM" + value));
    }



    public void calUserBudget() {
        // calculate the user budget
        shortTermSaving = getMonthlyIncome() * 0.10;
        longTermSaving = getMonthlyIncome() * 0.10;
        mediumTermSaving = getMonthlyIncome() * 0.10;
        wants = getMonthlyIncome() * 0.25;
        needs = getMonthlyIncome() * 0.45;
    }

    public String findUserCategory() {
        //based on the user input to determine the user belongs to which category of people
        if (age >= 60) {
            //senior if > 60
            //no married
            if (!isMarried) return "Senior Single";
            //married
            return "Senior Couple";

            // all < 60 so only check the married statues
        } else if (!isMarried) {
            //single and don't have children
            if (!hasDependent) {
                //has car or don't have car
                if (!isCarOwner) return "Single Public Transport User";
                return "Single Car Owner";
            } else {
                //check the number of  children
                if (noOfDependent >= 2) return "Single Parent (2 Children)";
                return "Single Parent (1 Children)";
            }
        } else {
            //all married
            if (!hasDependent) {
                //no children
                return "Married without Children";
            } else {
                //have children so determine how many there have
                if (noOfDependent < 2) return "Married(1 Children)";
                return "Married(2 Children)";
            }
        }
    }
    public void cmpTheExpenses() {
        //get the user category from the findUserCategory function
        String userCategory = findUserCategory();
        //get the suggested expenses budget from the hashmap
        double UserCategoryExpenses = JohorBudget.get(userCategory);
        //calculate the total expenses of the user
        double totalUserExpense = needs + wants;

        //print out
        System.out.println("You are belong to: " + userCategory + "and the suggested expenses is: " + UserCategoryExpenses);
        System.out.println("Your total expense budget is : " + totalUserExpense);

        //determine the expenses is higher or lower
        if (UserCategoryExpenses > totalUserExpense) {
            System.out.println("Sorry, your expenses budget was lower than our suggested expenses budget");
        } else {
            System.out.println( "Congratulation! your expenses budget was higher than our suggested expenses budget");
        }
    }

}
