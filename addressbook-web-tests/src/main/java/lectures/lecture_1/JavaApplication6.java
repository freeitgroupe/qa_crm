package lectures.lecture_1;

public class JavaApplication6 {
    public static void main(String[] args) {

        int a, b;

        a = sum(1,2);

        b = sum(a, 1, 2);
    }

    private static int sum(int ... x){
        int s = 0, i;
      /*  for (i = 0; i < x.length; i++) {
            s += x[i];
        }*/
        // Пример foreach. При помощи которого я буду переберать массив x.
        // xi временный объект для итерации
        for (int xi: x) s += xi;
        return s;
    }

//    private static int sum(int a, int b) {
//        return a + b;
//    }
//
//    private static int sum(int a, int b, int c) {
//        return a + b + c;
//    }

    /*
    Overload -
        Перегрузка метода, где мы объявляем два меода с одинаковым методом но с разной сигнатурой и похожей реаализации.
        Не предсказуемая ситуация(может вызваться что угодно):
            f(long, int)
            f(int, long)
            f(10, 10)

    Сигнатура метода -
        Это его название и список аргументов.


    **/


}
