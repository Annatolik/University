package Menu.GeneralCommand;

import Gift.Gift;
import Menu.Command;

import java.util.Scanner;

public class CreateCommand implements Command {
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть назву або кому призначається цей подарунок: ");
        String name = scan.next();
        System.out.println("Введіть колір подарунка:");
        String color = scan.next();
        System.out.print("Введіть розмір подарунка:\nширина:");
        double width = scan.nextDouble();
        System.out.print("довжина:");
        double length = scan.nextDouble();
        Gift.CreateGift(name, color, length, width);
    }
}
