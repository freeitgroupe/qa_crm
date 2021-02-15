import java.sql.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
//import java.util.Calendar;
import static java.lang.Math.PI;

public class Program {
   // public static int x; // как только класслоадер ппал на класс с этим полем, x будет жить столько сколько будет жить програомма
    int y; //поля объекта, переменная будет жить на время существования объекта

    public static void main(String[] args) {

        //double r = Math.cos(PI);
        Date d = new Date();
        int year = d.getYear() + 1900;
        int counter;
        String userName = "Рома";
        //int a=2, b=3;
        String s = null;
        counter = 10+1;
        System.out.println(year);

        byte b1 = 100;
        int ix =b1;
        byte b3 =(byte) ix;
        int mValue = Integer.MAX_VALUE;
        System.out.println(mValue);
        long l1 = mValue + 1L;
        System.out.println(l1);

        double dd = 2.0; // 8 байт отводится
        float ff = 2.5F; // 4 байта отводится

        {
            int a = 5;
            int b = 2;
            double c = (double)a / b; //2.5
            double c1 = a / b; //2.0, так как a, b целочисленные
            System.out.println(c1);
        }

        {
            char ch = 'A';
            char ch2 = '\u004D';
            int charCode = (int)ch2;

            System.out.println(ch2);
            System.out.println(charCode);
        }

        {
            boolean aa = true;
            boolean bb = false;
            boolean c  = aa && bb;
            System.out.println(c);
        }

        {
            int aa = 10;
            int dd1;
            int bb = (int)(dd1 = aa++) + (int)(dd = ++aa);
            //dd1 = 10; dd = 12;
            System.out.println(dd);
        }

        {
            //побитовые операции
            int a = 7; //0111
            int b = 5; //0101

            int c = a & b; //0101
            c = a | b;//0111
            c = ~a;

            c = a << 2;// 0111 << 2 = 011100

            a = -7;
            //c = a>>1; //0111 >> 1 = 0011
            c = a >>>1; // 0111 >> 1 = 0011

            a = 5; // 0101
            int b2 = (a >> 1) & 1;
            System.out.println(c);
        }

        {
            //работа со строками
            String hello = "Hello";
            String name = "Sergey";

            String str = hello + " " + name;
            System.out.println(str);
            System.out.println(str.length());//длина строки
            System.out.println(str.charAt(0));//обращение к первому символу
            System.out.println(str.charAt(str.length()-1)); //обращение к последниму символу

           //bad resolved
           /* String result = "";
            for(int i=1; i <= 100; i++){
                result += String.valueOf(i) + " ";
                System.out.println(result);
            }*/

            //good resolved
            StringBuilder sb = new StringBuilder();
            for(int i=1; i <= 100; i++) sb.append(i).append(" ");
            String result2 = sb.toString();
            System.out.println(result2);
        }

        {
            //Форматирование вывода
            String name = "Sergey";
            int age = 40;
            //вывод с подстновочными символами
            String r = String.format("Привет, %s - %d!", name, age); //форматируем строку

            //форматируем строку, указывваем прядковые номера подставляемых аргументов 1$, 2$
            String r1 = String.format("Привет, %2$s - %1$s!", name, age);

            String r2 = String.format("Привет, %2$s - %1$s! %3$d", name, age, 100);

            System.out.println(r2); //Выаодим в консоль Привет, Sergey - 40!
            System.out.printf("pi = %f\n", Math.PI); //выводим вещественное число 3,141593
            System.out.printf("pi = %.2f\n", Math.PI);// округляем данные до 2- значений после запятой 3,14

            //8 говорит о том что вывод должен занимать 8 символов pi =     3,14 - симв. добавлены слева
            System.out.printf("pi = %8.2f\n", Math.PI);
            //-8 говорит о том что вывод должен занимать 8 символов pi =     3,14 - симв. добавлены сконца
            System.out.printf("pi = %-8.2f\n", Math.PI);
            //Вывод даты 2017-10-03
            Date now = new Date();
            System.out.println(now);
            System.out.printf("%tY-%tm-%td\n", now, now, now);//2021-02-07


            //2021-02-07, 1$ - значит брать данные с первого аргумента
            System.out.printf("%1$tY-%1$tm-%1$td \n", now);

            //2021-02-07, %tY - берем первый параметр порядкового номера подстановочного значения
            //< смотри как сделно слева
            System.out.printf("%tY-%<tm-%<td \n", now);
            //2021-02-07,
            System.out.printf("%tF \n", now);
            //18:27
            System.out.printf("%tR \n", now);
        }

        {
            //Чтение потока
            Scanner sc = new Scanner(System.in);
            System.out.print("Your name:");
            String name = sc.nextLine();
            System.out.print("Your age: ");
            int age = sc.nextInt();
            sc.close();
        }

        {


        }

    }

    /*public static String whoLikesIt(String... names) {
        String str;
        int countNames = names.length;
        //Do your magic here
        if(countNames == 0){
            str = "no one likes this";
        }else if(countNames == 1){
            str = names[0] + " likes this";
        }else if(countNames == 2){
            str = names[0] + " and " + names[1] + " like this";
        }else if(countNames == 3){
            //Max, John and Mark like this
            str = names[0] + ", " + names[1] + " and " + names[2] + " like this";
        }else{
            //Alex, Jacob and 2 others like this
            str = names[0] + ", " + names[1] + " and " + (countNames - 2) + " others like this";;
        }
        return str;
    }*/

    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }



}
