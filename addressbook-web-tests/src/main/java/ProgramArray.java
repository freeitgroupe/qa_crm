import java.util.*;

public class ProgramArray {
  /**
   * @author Teacher_qa
   * @param args
   */
  public static void main(String[] args) {
    //при создании пустого массива, массив заполняется пустыми байтами
    /*int[] nums = new int[3];
    nums[0] = 10;
    nums[1] = 123;*/

    //int[] nums = new int[] {10, 123, 0};
    int[] nums = {10, 123, 0};

    System.out.println(nums.length);
    for (int i=0; i<nums.length; i++ ){
      System.out.println(nums[i]);
    }
   /* System.out.println(nums[0]);
    System.out.println(nums[1]);
    System.out.println(nums[2]);*/

    //Создано 4 объекта типа стринг, будет создан массив из 4-ссылок на эти строки, ссылки будут проинициализированы ссылками на эти четыре объекта
    String[] names = new String[] {"h4","h2","h3","h1"};

    Arrays.sort(names);
    for (int i=0; i<names.length; i++ ){
      System.out.println(names[i]);
    }

    int[][] matrix =
            {
                    {1,2,3},
                    {4,5,6}
            };
    System.out.println(matrix.length);
    for (int i=0; i < matrix.length; i++){
      for(int j=0; j < matrix[i].length; j++){
        System.out.printf("%-4d", matrix[i][j]);
      }
      System.out.println();
    }

    //коллекции
    System.out.println("---коллекции---");
    ArrayList<String> persons = new ArrayList<String>();
    persons.add("one");
    persons.add("two");
    persons.add("three");

    System.out.println(persons.size());

    for(int i=0; i<persons.size(); i++){
      System.out.println(persons.get(i));
    }

    persons.set(1, "oneee");
    persons.remove(0);

    for(int i=0; i<persons.size(); i++){
      System.out.println(persons.get(i));
    }

    System.out.println("//используем итератор");
    Iterator<String> iter =  persons.iterator();
    //iter.hasNext() - проверяет есть ли следующий элемент

    while(iter.hasNext()){
      //возвращает копию из элемента коллекции
      //переменная p будет тепизирована тем типом копию которого возвращает iter.next
      String p = iter.next();
      System.out.println(p);
    }

    System.out.println("//используем синтаксический сахар");
    // запись идентичная  записи выше, при компиляции в байт коде выглядит одинаково
    // при таком переборе нельзя изменять элементы коллекции
    for (String p : persons) {
      System.out.println(p);
    }
    //данный класс реализует ряд методов для работы с коллекциями
    Collections.sort(persons);

    //возвращает up неизменяемую коллекцию, по факту это обертка над коллекцией persons.
    List<String> up = Collections.unmodifiableList(persons);

    //up.add("add_parametr"); не сработает
    persons.add("add_parametr");

    for(String p : up){
      System.out.println(p);
    }

    //Выводим числа только 2 ки возведенной в определенную степень
    int n = 1;
    for(n=0; n <= 1024; n++){
      if((n & (n-1)) == 0)
        System.out.println(n);
    }



  }
}
