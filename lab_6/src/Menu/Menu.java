package Menu;

import Menu.GeneralCommand.*;

public class Menu {
    private Command create, view, edit, delete, find, sort;

    public Menu(){
        create = new CreateCommand();
        view = new ViewCommand();
        edit = new EditCommand();
        delete = new DeleteCommand();
        find = new FindCommand();
        sort = new SortCommand();
    }

    public void execute(int command){
        switch(command){
            case 1:create.execute();break;
            case 2:view.execute();break;
            case 3:edit.execute();break;
            case 4:delete.execute();break;
            case 5:find.execute();break;
            case 6:sort.execute();break;
        }
    }
    //вивід всіх пунктів меню
    public String AllCommands(){
        return "\n Меню:\n1 - Зібрати подарунок\n2 - Переглянути зібрані подарунки\n3 - Змінити подарунок\n4 - Видалити подарунок\n5 - Знайти солодощі в подарунку за заданим діапазоном вмісту цукру\n6 - Сортувати солодощі в подарунку за заданим параметром\n7 - вийти\n";
    }
}
