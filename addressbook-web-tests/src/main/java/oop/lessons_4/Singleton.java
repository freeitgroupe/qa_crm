package oop.lessons_4;

public class  Singleton {
  /*
  * Приватный конструктор, чтобы нельзя было достучаться из вне
  * */
  private Singleton(){}

  //статическое поле для хранения объекта
  private static Singleton instance = null;

  public static Singleton getInstance(){
    if(instance == null)
      instance =  new Singleton();
    // Возвращаеми ссылку на созданный объект.
    return  instance;
  }

}
