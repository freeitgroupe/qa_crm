public class ProgramLoop {
  /**
   * @autor Teacher_qa
   * Циклы
   */
  public static void main(String[] args) {
    //loop for
    for(int i=1; i < 10; i++){
      //break; прирывает цикл
      //останавливает итерацию при данных условиях и переходим на следующую итерацию
      if (i == 3) continue;
      System.out.println("Число: " + i);
    }
    label:
    for(int i=1; i<= 10; i++){
      for (int j =1; j <= 10; j++){
        if (j==5) break label;
        System.out.printf("%-4d", i*j);
        //return;
      }
      System.out.println(); //для перевода строки
      break;
    }
    System.out.println("break label");

    //while
    System.out.println("\n while \n");
    int a = 2;
    while (a < 1000){
      System.out.println(a);
      a*=2;
    }
    //do while
    System.out.println("\n do while \n");
    a = 1500;
    do{
      System.out.println(a);
      a*=2;
    }while(a < 2000);



    System.out.println("продолжение main");
  }
}
