package javase02.t02_03_04;

import javase02.t02_03_04.employees.Employees;
import javase02.t02_03_04.stationery.*;

import java.awt.*;
import java.util.*;

//Se02.02 Метод, позволяющий вести учет канцтоваров, определенн в классе Employees
//Se02.03 Иерархия канцтоваров находится в папке stationery
//Se02.04 Имплементация интерфейсов Comparator и Comparable для сортировки находится в классе Stationery
public class StationeryMain {
    public static void main(String... str)
    {
        //Создаем набор канцелярских товаров
        Pen pen = new Pen(30,"Черная ручка", Color.BLACK, Pen.Type.INK);
        Pencil pencil = new Pencil(21, "Карандаш", Color.BLACK, Pencil.Type.GRAPH);
        Pencil pencil2 = new Pencil(20, "Карандаш", Color.BLACK, Pencil.Type.GRAPH);
        Pencil pencil3 = new Pencil(20, "Арандаш", Color.BLACK, Pencil.Type.GRAPH);
        Notebook notebook = new Notebook(2, "Тетрадь", PaperSupplies.Format.A5, 96);

        java.util.List beginnerSet = new ArrayList();
        beginnerSet.add(pen);
        beginnerSet.add(pencil);
        beginnerSet.add(notebook);
        beginnerSet.add(pencil2);
        beginnerSet.add(pencil3);

        //Создаем нового сотрудника со статусом новичек
        Employees employees = new Employees("Александр Пушкин", Employees.Status.BEGINNER);
        //Выдаем новичку набор канцелярских товаров
        employees.setStationery(beginnerSet);

        System.out.println("Полная  стоимость канцтоваров: " + employees.costOfAllStationery());
        System.out.println();


        System.out.println("Список канцтоваров без сортировки:");
        for(Object obj: beginnerSet)
        {
            System.out.println((Stationery)obj);
        }
        System.out.println();

        System.out.println("Сортировка по цене и имени:");
        Collections.sort(beginnerSet);
        Collections.sort(beginnerSet, new Pen());
        for(Object obj: beginnerSet)
        {
            System.out.println((Stationery)obj);
        }
        System.out.println();

        System.out.println("Сортировка по имени:");
        Collections.sort(beginnerSet);
        for(Object obj: beginnerSet)
        {
            System.out.println((Stationery)obj);
        }
        System.out.println();

        System.out.println("Сортировка по цене:");
        Collections.sort(beginnerSet, new Pen());
        for(Object obj: beginnerSet)
        {
            System.out.println((Stationery)obj);
        }
    }
}
