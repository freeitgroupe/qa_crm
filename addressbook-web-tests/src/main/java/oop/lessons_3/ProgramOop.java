package oop.lessons_3;

import oop.lessons_4.Singleton;
import oop.lessons_3.stuff.Person;
import oop.lessons_3.graph.*;

public class ProgramOop {

  public static void main(String[] args) {
    /*
    *
    * Что происходит при сооздании объекта?
    * оператор new - в динамической области памяти (куча), выделяется место для хранения объекта этого класса (размер места зависит от суммы полей класса + служебные поля виртуальной машины). Далее область памяти инициализируется нулевыми байтами, потом выполняются выражения инициализации, потом блок инициализации, потом конструктор и только после этого ссылка на созданный объект т.е. на эту область памяти возвращается нам как результат выполнения оператора new и мы ссылку помещаем в переменную p1.
    *
    * */
    /*Person p1 = new Person();
    p1.name = "Name for man 1";
    p1.age = 40;

    Person p2 = new Person();
    p2.name = "Name for man 2";
    p2.age = 42;

    Person px = new Person();

    p1.show(); // this == p1
    p2.show(); // this == p2
    px.show(); //
    */

    // Обращаемся к коунтеру класса percent
    //System.out.printf("Total persons: %d\n", Person.counter );

    //Обращаемся к статическому методу класса person
    Person.showCounter();

    //Person p1 = Person.create("name for man 1", 40);

    //Person p1 = new Person("Name for man 1", 40);
    //Person p2 = new Person();
    //Person px = new Person();


    //p1.show(); // this == p1;
    //p2.show(); // this == p2
    //px.show(); //

    //Person.showAll();

    //System.out.printf("Total persons: %d\n", Person.counter );
    //Person.showCounter();

    /*
    * Работа с пакетом graph
    * */
    {
      Point p1 = new Point(10, 20);
      p1.draw();
    }

    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    System.out.println(s1 == s2);


  }



}
