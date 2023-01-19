package StepTracker;

import java.util.Scanner;

public class MonthData {

    Scanner scanner = new Scanner(System.in);
    int[] days  = new int[30];
    String monthName;
    void inputStep(int step,int day){
        days[day-1] = days[day-1]+step;
    }

    public void printDaysAndStepsFromMonth(int month) {
        for (int i = 0; i < 30; i++) {
            System.out.println(i+1 + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth(int month) {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    public int maxSteps(int month) {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int bestSession = 0;
        int countBest = 0;
        for (int i = 0; i < 30; i++) {
            if (days[i] >= goalByStepsPerDay) {
            countBest++;
            if (countBest > bestSession) {
                bestSession = countBest;
            }
        } else if (days[i] < goalByStepsPerDay) {
            countBest = 0;
        }
    }
    return bestSession;
    }

}