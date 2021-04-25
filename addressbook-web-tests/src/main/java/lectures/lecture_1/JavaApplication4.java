package lectures.lecture_1;

public class JavaApplication4 {
    public static void main(String[] args) {
        int a = 5;
        a++;
        System.out.println("a = " + a);
        //float c = .5; так записывать нельз€ так как происходит потер€ точности
        float b = (float).5;//.5f
        b = 1.f / 0; // infinity
        System.out.println("b = " + b); // infinity
        if(a < b) System.out.println("OK"); // OK
    }

}


/*
    Garbage collector (когдаочистит пам€ть) -
        ћы не знаем точно когда gc очистит пам€ть.
        ‘ормально gc должен очистить пам€ть когда закончитьс€ к-€  System.out.println("a = " + a);

     ак наш код исполн€етс€ ?
        »сполн€етс€ как байт код виртуальной машиной, при этом весь код хрнитс€ в пам€ти которой управл€ет jvm
 */
