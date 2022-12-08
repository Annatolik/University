package Menu.GeneralCommand;

import Gift.Gift;
import Menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class DeleteCommand implements Command {
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    @Override
    public void execute() {
        Command view = new ViewCommand();
        Scanner scan = new Scanner(System.in);
        if(Gift.gifts.isEmpty()){
            logger.info("Немає зібраних подарунків.");
            return;
        }
        int choice;
        System.out.println("Виберіть подарунок, який ви хочете видалити:");
        view.execute();
        do{
            while(!scan.hasNextInt()){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            choice = scan.nextInt()-1;
            if(choice < 0 || choice >= Gift.gifts.size()){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
            }
        }while(choice < 0 || choice >= Gift.gifts.size());
        Gift.DeleteGift(choice);
        while(!Gift.gifts.isEmpty()) {
            System.out.println("Хочете видалити ще один подарунок?\n1 - так\n2 - ні");
            do {
                while (!scan.hasNextInt()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                choice = scan.nextInt();
                if (choice < 1 || choice > 2) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            } while (choice < 1 || choice > 2);
            if (choice == 2) {
                return;
            }
            System.out.println("Виберіть подарунок, який ви хочете видалити:");
            view.execute();
            do {
                while (!scan.hasNextInt()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                choice = scan.nextInt() - 1;
                if (choice < 0 || choice >= Gift.gifts.size()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            } while (choice < 0 || choice >= Gift.gifts.size());
            Gift.DeleteGift(choice);
        }

    }
}
