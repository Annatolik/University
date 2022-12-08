package Menu.GeneralCommand;

import Gift.Gift;
import Menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class SortCommand implements Command {
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    @Override
    public void execute() {

        Scanner scan = new Scanner(System.in);
        if(Gift.gifts.isEmpty()){
            logger.info("Немає зібраних подарунків.");
        }else{
            int gift_choice, parameter_choice, method_choice;
            System.out.println("Виберіть подарунок, в якому ви хочете здійснити сортування:");
            Command view = new ViewCommand();
            view.execute();
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                gift_choice = scan.nextInt()-1;
                if(gift_choice < -1 || gift_choice >= Gift.gifts.size()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(gift_choice < -1 || gift_choice >= Gift.gifts.size());
            Gift gift = Gift.gifts.get(gift_choice);
            System.out.println("Виберіть параметр за яким хочете посортувати цукерки:\n1 - вміст цукру\n2 - вага");
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                parameter_choice = scan.nextInt();
                if(parameter_choice < 1 || parameter_choice > 2){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(parameter_choice < 1 || parameter_choice > 2);
            System.out.println("Сортувати:\n1 - за зростанням\n2 - за спаданням");
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                method_choice = scan.nextInt();
                if(method_choice < 1 || method_choice > 2){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(method_choice < 1 || method_choice > 2);
            if(method_choice == 1){
                gift.AscSortSweetsByChosenParameter(parameter_choice);
            }else {
                gift.DescSortSweetsByChosenParameter(parameter_choice);
            }
            System.out.println("Посортовані цукерки:\n");
            gift.PrintSweetsInGift();
        }

    }
}
