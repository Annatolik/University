package Menu.GeneralCommand;

import Gift.*;
import Menu.Command;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class EditCommand implements Command {
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        if(Gift.gifts.isEmpty()){
            logger.info("Немає зібраних подарунків.");
            return;
        }
        int gift_choice, change_choice;
        Command view = new ViewCommand();
        System.out.println("Виберіть подарунок, який ви хочете змінити:");
        view.execute();
        do{
            while(!scan.hasNextInt()){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            gift_choice = scan.nextInt()-1;
            if(gift_choice < 0 || gift_choice >= Gift.gifts.size()){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
            }
        }while(gift_choice < 0 || gift_choice >= Gift.gifts.size());
        Gift gift = Gift.gifts.get(gift_choice);
        System.out.println("Виберіть, що саме ви хочете змінити:\n1 - додати солодощі\n2 - вилучити солодощі\n");
        do{
            while(!scan.hasNextInt()){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
                scan.next();
            }
            change_choice = scan.nextInt();
            if(change_choice < 1 || change_choice > 2){
                logger.warning("Неправильно введені дані спробуйте ще раз.");
            }
        }while(change_choice < 1 || change_choice > 2);
        if(change_choice == 1){
            gift.AddSweetToGift();
        }else {
            ArrayList<Sweet> chosen_sweets = new ArrayList<Sweet>();
            int sweet_choice;
            System.out.println("Виберіть солодощі, які хочете вилучити з подарунку(якщо більше не хочете вилучати - введіть 0):");
            gift.PrintSweetsInGift();
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                sweet_choice = scan.nextInt()-1;
                if(sweet_choice < -1 || sweet_choice >= gift.getSweets().size()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(sweet_choice < -1 || sweet_choice >= gift.getSweets().size());
            while(sweet_choice != -1){
                chosen_sweets.add(gift.getSweets().get(sweet_choice));
                do{
                    while(!scan.hasNextInt()){
                        logger.warning("Неправильно введені дані спробуйте ще раз.");
                        scan.next();
                    }
                    sweet_choice = scan.nextInt()-1;
                    if(sweet_choice < -1 || sweet_choice >= gift.getSweets().size()){
                        logger.warning("Неправильно введені дані спробуйте ще раз.");
                    }
                }while(sweet_choice < -1 || sweet_choice >= gift.getSweets().size());
            }
            gift.DeleteSweetFromGift(chosen_sweets);
        }
    }
}
