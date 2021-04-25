package lectures.lecture_1;

public class JavaApplication7 {
    public static void main(String[] args) {
        // int[] m = new int[10]; динамический массив

        //Класс для работы со строками
        StringBuilder sb = new StringBuilder();
        // append работает со строкой как с массивом символов.
        sb.append("Hello");
        sb.append(' '); // символ
        sb.append("World");
        sb.append('!'); // символ
        System.out.println(sb);

    }
}

  /*  new -
        Для размещения в памяти сложного типа данных

      Работать без new можно только
        - с дататипами
        - данные типа стринг
        - данные типа оберток над дататипами
   */
