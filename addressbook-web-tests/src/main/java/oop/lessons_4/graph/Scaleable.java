package oop.lessons_4.graph;

public interface Scaleable{

  /*
  * public static final - подставляется по-умолчанию
  * */
  /*public static final*/ double DEFAULT_FACTOR = 2D;

  /*
  * public abstract можно не писать, компилятор сам подставит
  * */
  /*public abstract*/ void scale(double factor);

  /*
  *Дефолтная реализация, если не реализовать метод scale  с параметром то тогда реализуется default scale
  * */
  default void scale(){
    scale(DEFAULT_FACTOR);
  }



}