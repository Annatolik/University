package Menu.GeneralCommand;

import Gift.Gift;
import Gift.Sweet;
import Menu.Command;

import java.util.Scanner;
import java.util.logging.Logger;

public class FindCommand implements Command {
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        if(Gift.gifts.isEmpty()){
            logger.info("Немає зібраних подарунків.");
        }else {
            int gift_choice;
            double min_content, max_content;
            System.out.println("Виберіть подарунок, в якому ви хочете здійснити пошук:");
            Command view = new ViewCommand();
            view.execute();
            do {
                while (!scan.hasNextInt()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                gift_choice = scan.nextInt() - 1;
                if (gift_choice < -1 || gift_choice >= Gift.gifts.size()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            } while (gift_choice < -1 || gift_choice >= Gift.gifts.size());
            Gift gift = Gift.gifts.get(gift_choice);
            System.out.println("Введіть діапазон вмісту цукру для пошуку: ");
            do {
                while (!scan.hasNextDouble()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                min_content = scan.nextDouble();
                if (min_content < 0) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            } while (min_content < 0);
            do {
                while (!scan.hasNextDouble()) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                max_content = scan.nextDouble();
                if (max_content <= 0) {
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            } while (max_content <= 0);
            for (Sweet sweet : gift.FindSweetsToGivenRangeOfSugar(min_content, max_content)) {
                System.out.format("%s(%s)\t\tВага: %.1f\t\tВміст цукру: %.1f\n", sweet.getName(), sweet.getSweet_type(), sweet.getWeight(), sweet.getSugar_content());
            }
        }
    }
}
