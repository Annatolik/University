package Menu.GeneralCommand;

import Gift.Sweet;
import Menu.Command;

import java.util.Scanner;

public class NewSweetCommand implements Command {

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        int choice;
        String name, sweet_type = null;
        double weight, sugar_content;
        System.out.println("Виберіть вид солодкого: \n1 - цукерка\n2 - батончик\n3 - шоколадка");
        do {
            while (!scan.hasNextInt()) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            choice = scan.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
            }
        } while (choice < 1 || choice > 3);
        switch (choice) {
            case 1:
                sweet_type = "цукерка";
                break;
            case 2:
                sweet_type = "батончик";
                break;
            case 3:
                sweet_type = "шоколадка";
                break;
        }
        System.out.println("Введіть назву: ");
        name = scan.next();
        System.out.println("Введіть вагу: ");
        do {
            while (!scan.hasNextDouble()) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            weight = scan.nextDouble();
            if (weight < 0) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
            }
        } while (weight < 0);
        System.out.println("Введіть вміст цукру:");
        do {
            while (!scan.hasNextDouble()) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            sugar_content = scan.nextDouble();
            if (sugar_content < 0) {
                System.out.println("Неправильно введені дані спробуйте ще раз.");
            }
        } while (sugar_content < 0);
        Sweet sweet = new Sweet(name, sweet_type, weight, sugar_content);
    }
}
