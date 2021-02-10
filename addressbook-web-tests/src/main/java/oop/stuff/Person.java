package oop.stuff;

//public - значит класс будет доступен и в других пакетах.
//также, если public, файл должен называться также как и класс
public class Person {

  // Выражения ициализации
  public String name = "Unknown";
  public int age;

  // Блок инициализации.
  {
    age =  name.length();
  }

  // Конструктор
  /*
  * У конструктора нет возвращаемого значения
  * */
  public Person(String name, int age){
    //this указывает на объект у которого он вызывается
    this.name = name;
    this.age = age;
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
