package Gift;

import Menu.Command;
import Menu.GeneralCommand.ViewCommand;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Gift {

    private String name;
    private double total_weight;
    private double length;
    private double width;
    private String color;
    private ArrayList<Sweet> sweets = new ArrayList<>();
    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public String getName() {
        return name;
    }
    public double getTotal_weight() {
        return total_weight;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public String getColor() {
        return color;
    }
    public static Command view = new ViewCommand();
    //Масив всіх подарунків
    public static ArrayList<Gift> gifts = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Gift.class.getName());
    public Gift(String name, String color, double length, double width){
        this.name = name;
        this.color = color;
        this.length = length;
        this.width = width;
    }
    //Вводимо дані та створюємо подарунок
    public static void CreateGift(String name, String color, double length, double width){
        Gift gift = new Gift(name, color, length, width);
        gift.AddSweetToGift();
        gifts.add(gift);
    }
    //видаляємо вибраний подарунок з загального масиву
    public static void DeleteGift(int choice){
        gifts.remove(choice);
    }
    //створюємо нову цукерку та додаємо її до подарунку
    public void AddSweetToGift(){
        Scanner scan = new Scanner(System.in);
        int choice;
        Sweet sweet;
        do{
            sweet = Sweet.NewSweet();
            sweets.add(sweet);
            total_weight += sweet.getWeight();
            System.out.println("Хочете добавити ще одне нове солодке?\n1 - так\n2 - ні");
            do{
                while(!scan.hasNextInt()){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                    scan.next();
                }
                choice = scan.nextInt();
                if(choice < 1 || choice > 2){
                    logger.warning("Неправильно введені дані спробуйте ще раз.");
                }
            }while(choice < 1 || choice > 2);
        }while(choice != 2);
    }
    //видаляємо вибрані солодощі з подарунку
    public void DeleteSweetFromGift(ArrayList<Sweet> chosen_sweets){
        for(Sweet sweet : chosen_sweets){
            sweets.remove(sweet);
        }
        chosen_sweets.clear();
    }
    //здійснюємо пошук солодкого за заданим діапазоном вмісту цукру
    public ArrayList<Sweet> FindSweetsToGivenRangeOfSugar(double min_content, double max_content){
        ArrayList<Sweet> found_sweets = new ArrayList<>();
        for(Sweet sweet : sweets){
            if(sweet.getSugar_content() > min_content && sweet.getSugar_content() < max_content){
                found_sweets.add(sweet);
            }
        }
        return found_sweets;
    }
    //сортуємо солодощі за зростанням та вибраним параметром (1 - вміст цукру, 2 - вага)
    public void AscSortSweetsByChosenParameter(int parameter_choice){
        Sweet temp;
        boolean isSorted = false, check = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 1; i < sweets.size(); i++) {
                switch(parameter_choice){
                    case 1:
                        check = sweets.get(i).getSugar_content() < sweets.get(i - 1).getSugar_content();
                        break;
                    case 2:
                        check = sweets.get(i).getWeight() < sweets.get(i - 1).getWeight();
                        break;
                }
                if (check) {
                    isSorted = false;
                    temp = sweets.get(i);
                    sweets.set(i, sweets.get(i - 1));
                    sweets.set(i - 1, temp);
                }
            }
        }
    }
    //сортуємо солодощі за спаданням та вибраним параметром (1 - вміст цукру, 2 - вага)
    public void DescSortSweetsByChosenParameter(int parameter_choice){
        Sweet temp;
        boolean isSorted = false, check = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 1; i < sweets.size(); i++) {
                switch(parameter_choice){
                    case 1:
                        check = sweets.get(i).getSugar_content() > sweets.get(i - 1).getSugar_content();
                        break;
                    case 2:
                        check = sweets.get(i).getWeight() > sweets.get(i - 1).getWeight();
                        break;
                }
                if (check) {
                    isSorted = false;
                    temp = sweets.get(i);
                    sweets.set(i, sweets.get(i - 1));
                    sweets.set(i - 1, temp);
                }
            }
        }
    }
    //виводимо дані про солодощі в подарунку
    public void PrintSweetsInGift(){
        if(sweets.isEmpty()){
            logger.info("Немає солодощів в подарунку.");
            return;
        }
        int count_sweet = 1;
        for(Sweet sweet : sweets){
            System.out.format("%d - %s(%s)\t\tВага: %.1f\t\tВміст цукру: %.1f\n", count_sweet, sweet.getName(), sweet.getSweet_type(), sweet.getWeight(), sweet.getSugar_content());
            count_sweet++;
        }
    }
    //записуємо дані про подарунки в файл
    public static void WriteInFile(FileWriter wfile) throws IOException {
        if(Gift.gifts.isEmpty()){
            wfile.write("Немає зібраних подарунків.");
            return;
        }
        wfile.write("\n");
        int count_gift = 1, count_sweet;
        for(Gift gift : Gift.gifts){
            count_sweet = 1;
            wfile.write(count_gift + " - " + gift.getName() + "\nВага подарунка: " + gift.getTotal_weight() + "\nКолір подарунка: " + gift.getColor() + "\nРозмір подарунка:   ширина: " + gift.getWidth() + "  довжина: " + gift.getLength() + "\nВміст:");
            for(Sweet sweet : gift.getSweets()){
                wfile.write("\t" + count_sweet + " - " + sweet.getName() + "(" + sweet.getSweet_type() + ")\t\tВага: " + sweet.getWeight() + "\t\tВміст цукру: " + sweet.getSugar_content() + "\n");
                count_sweet++;
            }
            count_gift++;
            wfile.write("\n");
        }
    }
}
