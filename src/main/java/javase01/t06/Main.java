package javase01.t06;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Notebook myNotebook = new Notebook();

        myNotebook.addNewEntry("Первая запись в блокноте");
        myNotebook.addNewEntry("Вторая запись в блокноте");
        myNotebook.addNewEntry("Третья запись в блокноте");
        myNotebook.addNewEntry("Четвертая запись в блокноте");
        out.println();

        myNotebook.printAllEntry();
        out.println();

        myNotebook.editEntry(3, "Третья запись в блокноте отредактирована");
        myNotebook.printAllEntry();
        out.println();

        myNotebook.deleteEntry(2);
        myNotebook.printAllEntry();
        out.println();

        out.println("Попытка удалить несуществующую запись");
        myNotebook.deleteEntry(4); //В рамках сущестующего массива
        myNotebook.deleteEntry(6); //Вне массива
        myNotebook.printAllEntry();
        out.println();

        out.println("Попытка изменить несуществующую запись");
        myNotebook.editEntry(4, "Четвертая запись, изменись!"); //В рамках сущестующего массива
        myNotebook.editEntry(6, "Шестая запись, изменись!"); //Вне массива
        myNotebook.printAllEntry();
    }

}
