public class Vehicle {
    private String make;
    private String model;
    private double mpg;

    public Vehicle(String make, String model, double mpg) {
        this.make = make;
        this.model = model;
        this.mpg = mpg;
    }

    public double getMpg() {
        return mpg;
    }

    @Override
    public String toString() {
        return make + " " + model + " | mpg: " + mpg;

    }
}
