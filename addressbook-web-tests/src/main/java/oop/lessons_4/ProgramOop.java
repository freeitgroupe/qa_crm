package oop.lessons_4;

import oop.lessons_4.stuff.Person;
import oop.lessons_4.graph.*;

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
      /*
      * Конструкторы выполняются в такой последовательности Object, Shape, Point
      * */
      Point p1 = new Point(10, 20, "green");

      // p1.toString()
      // клонирование объекта
      Point p2 = p1.clone();
      p1.color = "red";
      /*
      * Преобразование типа ссылок, в данном случае ссылка s1 типа Shape указывает
      * на объект p1 типа Point
      * */
      //Также происходит не явное преобрзовние типа ссылки implicit conversion
      Shape s1 = p1;
      // Point оператор явного преобразования типа ссылки, оператор cast/
      // Явное преобразование ссылки explicit conversion (cast).
      // Point p3 = (Point) s1;
        /*
        * Преобразование типа ссылки с использовнием проверки оператором instanceof
        * */
        if(s1 instanceof Point){  //true
            Point p3 = (Point) s1;
            p3.moveBy(1,1);
        }
        /*
        * признак полиморфизма в java, где метод объевленный в классе родителя и переопределенный в дочерних классах при вызове у объектов этих классов будет указывать на метод класса объектом которого он является.
        * т.е. Вызывать одно и тоже действие для множество типов и возможность конкретизации для кждого из типов
        * */

        /*
        * Как это работает? Полиморфизм через таблицу вертуальных методов.
        * В эту таблицу попадают только переопределенные методы
        * Class   Method   Addr
        * Shape   draw()   ****
        * Point   draw()   ****
        * Circle  draw()   ****
         * */
        // p1 является Объектом класса Point. draw(), будет от класса Point
        p1.draw();
        // так как выше Shape s1 = p1; тогда s1 вызовет метод draw класса p1
        s1.draw();


      Circle c1 = new Circle(100, 200, 50, "pink");
        //c1.scale(1.5);
        Shape s2 = c1;
        //c1.setR(5);
        //s2.draw();

        if(s2 instanceof Point){  //false
            Point p3 = (Point) s2;
            p3.moveBy(2,1);
        }

        Scaleable sc1 = c1;

        //sc1.scale(1.5);


      //System.out.println(Circle.DEFAULT_FACTOR);
      System.out.println(Moveble.DEFAULT_FACTOR);
      System.out.println(Scaleable.DEFAULT_FACTOR);
      System.out.println(((Moveble)c1).DEFAULT_FACTOR);

      //Shape.drawScene();
      //p1.draw();
      //p2.draw();
    }

  }



}
