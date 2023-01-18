package sprint1;
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        System.out.println("Привет! Начнем использовать счёткик шагов!");

        while(true) {
            printMenu(scanner,stepTracker);
            int command = scanner.nextInt();

            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                ;
            } else if (command == 3) {
                stepTracker.changeStepGoal();
                } else if (command == 4) {
                System.out.println("Программа завершена");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды пока нет");
            }
        }
    }

     public static void printMenu(Scanner scanner,StepTracker stepTracker) {
     System.out.println("Что вы хотите сделать?");
     System.out.println("1. Ввести количество шагов за определённый день");
     System.out.println("2. Напечатать статистику за определённый месяц");
     System.out.println("3. Изменить цель по количеству шагов в день");
     System.out.println("4. Выйти из приложения");
     }
}