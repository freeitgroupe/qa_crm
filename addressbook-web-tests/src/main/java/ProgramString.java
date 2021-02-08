import java.util.Scanner;

public class ProgramString {
  public static void main(String[] args) {
    int b = 2;
    //Обязательно использовать final, так как с должно быть известно на этапе компиляции.
    final int c = 1;
    switch(b){
      case 0:
        System.out.println("0");
        break;
      case c:
        System.out.println("1");
        break;
      case 2:
        System.out.println("2");
        break;
      default:
        System.out.println("много");
    }

    // Сравнение строк
    // Строки это ссылочный тип данных
    Scanner sc = new Scanner(System.in);
    String s1 = "hello";
    String s2 = sc.nextLine() ; // вводим в консоли hello
    String s3 = "hello" ; // hello
    String s4 = "he" + "llo" ; // hello, при сравнении "==", инициализируется при компиляции, и компилятор приобразует на этапе компиляции.
    String s5 = new String("hello") ;// hello, при сравнении "==", выдаст false, так как new String() создает новый объект и соответственно мы выделяем новую область памяти
    //true так как при сравнении обращаемся к той же области памяти
    if(s1 == s3){
      System.out.println("true");
    }else{
      System.out.println("false");
    }

    // false, так как сравниваются разные области памяти, т.е. сравнивает только ссылки
    if(s1 == s2){
      System.out.println("true");
    }else{
      System.out.println("false");
    }

    //true, содержимое объектов совпадает
    if(s1.equals(s2)){
      System.out.println("true");
    }else{
      System.out.println("false");
    }



  }
}
