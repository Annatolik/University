//Завдання:
//Новорічний подарунок. Визначити ієрархію цукерок та інших солодощів.
//Створити кілька об’єктів-цукерок. Зібрати дитячий подарунок з визначенням його ваги.
//Здійснити сортування цукерок в подарунку на основі одного з параметрів.
//Знайти цукерку в подарунку, що відповідає заданому діапазону вмісту цукру.

import Menu.Menu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("Напишіть шлях до папки для запису(розділення //):");
        String path = scan.next();
        FileWriter wfile = new FileWriter(path, false);
        int choice;
        while (true)
        {
            System.out.println(menu.AllCommands());
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                choice = scan.nextInt();
                if(choice < 1 || choice > 8){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(choice < 1 || choice > 8);
            if(choice == 7){ return; }
            menu.execute(choice);
        }
//      Gift.WriteInFile(wfile);
//      wfile.close();
    }
}