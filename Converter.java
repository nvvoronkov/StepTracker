package sprint1;
public class Converter {

    public double convertToKm(int steps) {
        double stepSize = 0.75;
        return steps * stepSize / 1000;
    }

    public double convertStepsToKilocalories(int steps) {
        int callorieInStep = 50;
        return steps * callorieInStep / 1000;
    }
}