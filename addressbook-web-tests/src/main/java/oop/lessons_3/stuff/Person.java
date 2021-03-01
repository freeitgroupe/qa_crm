package oop.lessons_3.stuff;

import java.util.ArrayList;

//public - значит класс будет доступен и в других пакетах.
//также, если public, файл должен называться также как и класс
public class Person {

  // Выражения ициализации
  public String name = "Unknown";
  public int age;

  /*
  * Статическое поле создается для класса и класс лоадер сразу создает место в памяти для статических полей и методов
  * */
  public static int counter = 0;

  static{
    counter = 0;
  }

  //<> - diamond оператор
  static ArrayList<Person> persons = new ArrayList<>();

  public static void showCounter(){
    System.out.printf("Total persons: %d\n", Person.counter );
  }

  // Блок инициализации.
  /*{
    age =  name.length();
  }*/

  // Конструктор
  /*
  * У конструктора нет возвращаемого значения
  * */
  public Person(String name, int age){
    //this указывает на объект у которого он вызывается
    this.name = name;
    this.age = age;

    // возвращаем объект класса для создаваемого объекта данного класса
    // this - ссылка на объект, который сейчас конструируется
    // такая практика достаточно опасная, ввиду того что мы вынесим наружу ссылку на объект который может быть с ошибкой
    Person.persons.add(this);
  }

  /*
  * Для создания объекта этого класса можно воспользоваться сл-м методом
  * В чем преимущество?
  * В том что, добавление в коллекцию происходит после того как объект создан.
  * */
  public static Person create(String name, int age){
    // Создание объекта
    Person p = new Person(name, age);
    // Добавление  в коллекцию.
    persons.add(p);
    return p;
  }



  public static void showAll(){
    for (Person p : Person.persons){
      p.show();
    }
  }

  //Консруктор с редуцированным набором параметром
  public Person(String name){
    //вариант вызова конструктора внутри конструктора
    //должен быть вызван первым в методе
    this(name, 18);
  }

  public Person(){
    this("Неизвестный");
  }


  public void show(){
    //this - указывает на поле класса
    System.out.printf("%s - %d\n", this.name, this.age);
  }

  public static void main(String[] args) {}
}
