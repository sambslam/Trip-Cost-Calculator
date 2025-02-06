import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains code for receiving inputs for various costs and
 * discounts and calculates the total cost incurred for the trip.
 * Bugs: none known
 *
 * @author Samarth Lamba
 */

public class TripCostCalculator {

    /**
     * This method prompts the user for input for various costs
     * and calculates the total costs incurred on the trip.
     * <p>
     * Algorithm:
     * Input values for daily expenses, number of days,
     * transportation, accommodation and miscellaneous.
     * Use while loops and if-else statements to check
     * if input is safe to use.
     * Calculate the total cost of the trip using the tripCostCalculator() method.
     * Calculate the discounted cost of the trip using the getDiscountedTotalCost() method.
     * Print out the discounted cost.
     * <p>
     *
     * @param args unused
     */


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double dailyExpenses = 0.0;
        int numberOfDays = 0;
        double transportationCost = 0.0;
        double accommodationCost = 0.0;
        double miscellaneousCost = 0.0;
        boolean safeInputForDailyExpenses = false;
        boolean safeInputForNumberOfDays = false;
        boolean safeInputForTransportationCost = false;
        boolean safeInputForAccommodationCost = false;
        boolean safeInputForMiscellaneousCost = false;

        System.out.println("Enter the daily expenses: ");
        while (!safeInputForDailyExpenses && input.hasNext()) {

            if (input.hasNextDouble()) {
                dailyExpenses = input.nextDouble();
                safeInputForDailyExpenses = true;
            } else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }

        System.out.println("Enter the number of days of the trip: ");
        while (!safeInputForNumberOfDays && input.hasNext()) {

            if (input.hasNextInt()) {
                numberOfDays = input.nextInt();
                safeInputForNumberOfDays = true;
            }
            else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }

        System.out.println("Enter the transportation cost: ");
        while (!safeInputForTransportationCost && input.hasNext()) {

            if (input.hasNextDouble()) {
                transportationCost = input.nextDouble();
                safeInputForTransportationCost = true;
            }
            else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }

        System.out.println("Enter the accommodation cost: ");
        while (!safeInputForAccommodationCost && input.hasNext()) {

            if (input.hasNextDouble()) {
                accommodationCost = input.nextDouble();
                safeInputForAccommodationCost = true;
            }
            else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }

        System.out.println("Enter the miscellaneous cost: ");
        while (!safeInputForMiscellaneousCost && input.hasNext()) {

            if (input.hasNextDouble()) {
                miscellaneousCost = input.nextDouble();
                safeInputForMiscellaneousCost = true;
            }
            else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }
        double totalTripCost = tripCostCalculator(dailyExpenses, numberOfDays, transportationCost,
                miscellaneousCost, accommodationCost);

        System.out.println("The total cost of the trip before the discount is $"
                + totalTripCost + ".");

        ArrayList<Double> tripExpenses = new ArrayList<>();
        tripExpenses.add(dailyExpenses * numberOfDays);
        tripExpenses.add(transportationCost);
        tripExpenses.add(accommodationCost);
        tripExpenses.add(miscellaneousCost);

        int discountPercentage = 0;
        boolean safeInputForDiscountPercentage = false;
        System.out.println("Enter discount: ");
        while (!safeInputForDiscountPercentage && input.hasNext()) {

            if (input.hasNextInt()) {
                discountPercentage = input.nextInt();
                safeInputForDiscountPercentage = true;
            }
            else {
                input.next();
                System.out.println("Input not a number. Please try again.");
            }
        }

        double discountedTotal = getDiscountedTotalCost(tripExpenses,
                discountPercentage);
        System.out.println("The final discounted total cost of the trip is $"
                + discountedTotal + ".");

        input.close();
    }

    /**
     * This method calculates the total cost of the trip based on the parameter values passed.
     * The total cost of the trip is the summation of the transportation, accommodation
     * and miscellaneous costs and the daily expenses multiplied by the number of days to
     * get the summation of all the daily expenses.
     *
     * @param dailyExpenses Daily expenses incurred on the trip.
     * @param numberOfDays Total duration of the trip.
     * @param transportationCost Total cost of transportation.
     * @param miscellaneousCost Total miscellaneous costs incurred on the trip.
     * @param accommodationCost Total cost of accommodations.
     * @return totalTripCost Total cost of the trip.
     */
    public static double tripCostCalculator(double dailyExpenses, int numberOfDays,
                                            double transportationCost,
                                            double miscellaneousCost,
                                            double accommodationCost) {
        double totalTripCost = Math.round(((dailyExpenses * numberOfDays) + transportationCost +
                accommodationCost + miscellaneousCost) * 100.0) / 100.0;

        return totalTripCost;
    }

    /**
     * This method processes a list of expenses by applying a discount to each expense
     * and calculates the final total discounted cost.
     *
     * @param expenses A list of trip expenses.
     * @param discountPercentage The discount percentage to apply to each expense.
     * @return The total cost after applying the discount to all expenses.
     */
    public static double getDiscountedTotalCost(ArrayList<Double> expenses,
                                                double discountPercentage) {
        ArrayList<Double> discountedExpenses = new ArrayList<>();
        double totalDiscountedCost = 0.0;

        for (double expense : expenses) {
            double discountedExpense = expense - (expense * (discountPercentage / 100));
            discountedExpense = Math.round(discountedExpense * 100.0) / 100.0;
            discountedExpenses.add(discountedExpense);
            totalDiscountedCost += discountedExpense;
        }

        totalDiscountedCost = Math.round(totalDiscountedCost * 100.0) / 100.0;

        System.out.println("Discounted trip expenses: " + discountedExpenses);

        return totalDiscountedCost;
    }
}
