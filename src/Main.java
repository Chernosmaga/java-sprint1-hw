import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Добро пожаловать!\nЧто вы хотите сделать?");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while(true) {

            printMenu();

            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (userInput == 2) {
                stepTracker.changeStepGoal();
            } else if (userInput == 3) {
                stepTracker.printStatistic();
            } else if (userInput == 4) {
                System.out.println("До встречи!");
                scanner.close();
                break;
            } else {
                System.out.println("Такой команды пока нет");
            }
        }
    }

    public static void printMenu() {
        System.out.println("1. Добавить количество шагов за определённый день\n2. Изменить цель по количеству шагов");
        System.out.println("3. Напечатать статистику за определённый месяц\n4. Выйти из приложения");
    }
}
