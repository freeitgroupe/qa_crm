public class ProgramMethods {
  /*
  * Сигнатура метода это имя метода и набор передаваемых параметров
  * */
  public void sayHello(){
    System.out.println("say Hello!");
  }

  //Пример перегрузки методов
  public void sayHello(String text){
    System.out.println("say Hello!" + text);
  }

  public  static void sayHelloStatic(){
    System.out.println("say Hello Static!");
  }

  public  static void sayHelloStaticParam(String userName, int age){
    System.out.printf("Hello, %S - %d \n", userName, age);
  }

  public static double average(int a, int b){
    double avg = (a+b)/2d;
    return avg;
  }

  public static double average(int[] m){
    int summa = 0;
    for(int k : m){
      summa += k;
    }
    return (double)summa / m.length;
  }


  public static void main(String[] args) {
    ProgramMethods p = new ProgramMethods();
    p.sayHello();
    ProgramMethods.sayHelloStatic();
    sayHelloStatic();
    sayHelloStaticParam("John", 18);
    double d = average(16, 7);
    System.out.println(d);
    System.out.println(average(new int[]{7,8,9,10,11}));
  }


}
