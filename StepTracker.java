package StepTracker;
import java.util.Scanner;

public class StepTracker{
    Converter converter = new Converter();
    MonthData[] monthToData = new MonthData[13];
    Scanner scanner = new Scanner(System.in);
    int goalByStepsPerDay = 10000;
    String[] monthName = {"null","январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    StepTracker(Scanner scanner) {
        for (int i = 0; i < 13; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].monthName = monthName[i];
        }
    }

    public int changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день");
        int newSteps = scanner.nextInt();
        if (newSteps < 0) {
            System.out.println("Значение не может быть отрицательным \n");
        } else if (newSteps == 0){
            System.out.println("Значение не может быть нулевым \n");
        } else {
            goalByStepsPerDay = newSteps;
            System.out.println("Ваша новая цель: " + goalByStepsPerDay + " шагов в день \n");
        }
        return goalByStepsPerDay;
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца. (от 1 ("+ monthName[1] + ") до 12 ("+ monthName[12]+")");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Ошибка. Начните заново.");
            return;
        }

        System.out.println("Введите номер дня от 1 до 30.");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Ошибка. Начните заново");
            return;
        }
        System.out.println("Введите количество шагов (Больше нуля).");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Ошибка. Начните заново.\n");
            return;
        }
        if (steps>=goalByStepsPerDay){
            System.out.println("Вы достигли цели шагов на день! Так держать!\n");
        }
        monthToData[month].days[day-1]=steps;
    }

    void printStatistic() {
        System.out.println("За какой месяц вы хотите получить статистику (от 1 до 12):");
        int monthNumber = scanner.nextInt();
        MonthData monthData = monthToData[monthNumber];
        System.out.println("Количество пройденных шагов по дням: ");
        monthData.printDaysAndStepsFromMonth(monthNumber);
        System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth(monthNumber));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps(monthNumber));
        System.out.println("Среднее количество шагов: " + (monthData.sumStepsFromMonth(monthNumber) / 30));
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(monthData.sumStepsFromMonth(monthNumber)));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth(monthNumber)));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
    }
}
