package Menu.GeneralCommand;

import Gift.*;
import Menu.Command;

import java.util.logging.Logger;

public class ViewCommand implements Command {
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    @Override
    public void execute() {
        if(Gift.gifts.isEmpty()){
            logger.info("Немає зібраних подарунків.");
            return;
        }
        int count_gift = 1, count_sweet;
        for(Gift gift : Gift.gifts){
            count_sweet = 1;
            System.out.println(count_gift + " - " + gift.getName() + "\nВага подарунка: " + gift.getTotal_weight() + "\nКолір подарунка: " + gift.getColor() + "\nРозмір подарунка:   ширина: " + gift.getWidth() + "  довжина: " + gift.getLength() + "\nВміст:");
            for(Sweet sweet : gift.getSweets()){
                System.out.format("\t%d - %s(%s)\t\tВага: %.1f\t\tВміст цукру: %.1f\n", count_sweet, sweet.getName(), sweet.getSweet_type(), sweet.getWeight(), sweet.getSugar_content());
                count_sweet++;
            }
            count_gift++;
            System.out.println("\n");
        }
    }
}
