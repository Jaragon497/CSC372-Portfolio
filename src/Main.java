import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    final static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<Vehicle> vehicleList = new LinkedList<>();

        System.out.println("Enter make, model and mpg for a vehicle. Type 'done' to finish.");
        while (true) {

            // Get Make
            System.out.print("Make: ");
            String make = scnr.next();
            if (make.equalsIgnoreCase("done")) {
                break;
            }

            // Get Model
            System.out.print("Model: ");
            String model = scnr.next();

            // Get mpg
            System.out.print("Miles per gallon (mpg): ");
            double mpg = getValidDouble();

            vehicleList.add(new Vehicle(make, model, mpg));
        }

        MergeSort.mergeSort(vehicleList, new MpgComparator());
        writeToFile(vehicleList);
    }

    public static double getValidDouble() {
        // Initialize mpg var before try block
        double mpg;
        while (true) {

            // Try creating a double from user input
            try {
                mpg = Double.parseDouble(scnr.next());
                if (mpg <= 0) {
                    System.out.println("Enter a positive value!");
                } else {
                    return mpg;
                }
            } catch (Exception e) {
                System.out.print("Invalid number error. Enter a numeric value: ");
            }
        }
    }

    public static void writeToFile(LinkedList<Vehicle> vehicleList) {
        try (FileWriter wtr = new FileWriter("./vehicles.txt")) {
            for (Vehicle v : vehicleList) {
                wtr.write(v + "\n");
            }
            System.out.println("Successfully wrote data to `./vehicles.txt`");
        } catch (Exception e) {
            System.out.println("Error occurred writing to file: " + e.getMessage());
        }
    }
}
