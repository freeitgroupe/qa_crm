public class ProgramMethods {
  /*
  * Сигнатура метода это имя метода и набор передаваемых параметров
  * */
  public void sayHello(){
    System.out.println("say Hello!");
  }


  public void sayHello(String text){
    System.out.println("say Hello!" + text);
  }

  public  static void sayHelloStatic(){
    System.out.println("say Hello Static!");
  }

  public  static void sayHelloStaticParam(String userName, int age){
    System.out.printf("Hello, %S - %d \n", userName, age);
  }


  /*
  *  Пример перегрузки методов, на примере average
  * */
  //Start
  //int a, int b - переменые типа integer
  public static double average(int a, int b){
    double avg = (a+b)/2d;
    return avg;
  }

  //int[] m - Ссылка на массив интов
  public static double average(int[] m){
    int summa = 0;
    for(int k : m){
      summa += k;
    }
    return (double)summa / m.length;
  }
  //End
  /*
  * Суть в том что мы используем методы с одинаковым именем, но передаем различного типа параметры
  * */
  //int[] m, можем записать как: int... m, будет работать как предыдущий вариант
  public static double average2(int... m){
    int summa = 0;
    for(int k : m){
      summa += k;
    }
    return (double)summa / m.length;
  }

  /*
  * Находим наибольший общий делитель 2-х чисел
  * */
  public static int delitel(int k1, int k2){
   /* int vol = 0;//наибольшее число
    int res = 0;
    int oldRes;

    //один вариант
    if(k1 > k2){
      res = k1 % k2;
      if(res == 0) return k2;
      oldRes = res;

      while(res > 0){
        res = k2 % oldRes;
        if(res > 0){
          oldRes = res;
          k2 = res;
        }else{
          vol = oldRes;
        }
      }
    }else {
      vol = k1;
    }
    return vol;*/
   //второй вариант
    int k;
    while((k = k1 % k2) !=0){
      k1 = k2;
      k2 = k;
    }
    return k2;
  }

  static void test1(int a){
      a++;
      System.out.printf("test 1 a = %d\n", a);
    }

  static void test2(int[] a){
      a[0]++; //меняем данные массива
      System.out.printf("test[]2 a = %d\n", a[0]);
    }

  static void test3(String a){
      a+="!"; // создали новый объект типа String
      System.out.printf("test3 a = %s\n", a); //Hello!
    }

  static void test4(StringBuilder a){
    a.append("!"); // В данном месте мы изменили объект StringBuilder
    System.out.printf("test4 a = %s\n", a); //Hello!
  }

  public static void main(String[] args) {

     {
       StringBuilder a = new StringBuilder("Hello");
       test4(a);//Hello!, StringBuilder, изменяемый тип данных, в этом месте мы создаем копию ссылки
       System.out.printf("main4 a = %s\n", a); //Hello!, так как мы изменили объект соответственно строкой выше, соответственно будем ссылаться на изменненый объект

     }

     {
       String a= "Hello";//
       test3(a); // Hello!, в этом месте создается новый объект строки, так как string не изменяемый тип данных, в этом месте создается копия ссылки на новый объект типа стринг/
       System.out.printf("main3 a=%s\n-----\n", a); // Hello, так как мы обращаея к старой ссылке старому объекту a
     }

    {
      int[]a= {10};// создается оригинальная ссылка на массив a
      test2(a); // test2 a = 11, так как в этом месте создается копия ссылки на массив, т.е. на стеке создается копия.Сам массив хранится в куче, динамическая область памяти.
      System.out.printf("main[]2 a=%d\n-----\n", a[0]); //main2 a=11, так как мы вернемся к оригинальной ссылке на массив, которая будет указывать на новый измененный массив
    }

    {
      int a = 10;
      test1(a); // test 1 a = 11, так как в этом месте создается копия переменной a, т.е. на стеке создается копия значения
      System.out.printf("main 1 a=%d\n-----\n", a); //main 1 a=10
    }

    ProgramMethods p = new ProgramMethods();
    p.sayHello();
    ProgramMethods.sayHelloStatic();
    sayHelloStatic();
    sayHelloStaticParam("John", 18);
    double d = average(16, 7);
    System.out.println(d);

    System.out.println(average(new int[]{7,8,9,10,11}));

    System.out.println(average2(7,8,9,10,11));
    System.out.println(delitel(1071, 462));

    //тип данных value type, Java создаст 4  байтовый регион в памяти для хранения.
    //
    {
      int a = 10;
      int b = a;
      ++a;
      System.out.println(a + "\n" + b ); //11, 10
      // b = 10, так как в b, останется старое значение a.
    }

    //Тип данных Reference type - Ссылочные вид данных,
    {
      int[] a = {10};
      int[] b = a;
      a[0]++;
      System.out.println(a[0]+ "\n" + b[0] );
    }

  }

}
