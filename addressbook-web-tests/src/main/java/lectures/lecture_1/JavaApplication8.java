package lectures.lecture_1;

public class JavaApplication8 {
    public static void main(String[] args) {

        Test test = new Test();
        test.setX(-101);
        System.out.println(test.getX());
        // после запуска видим lectures.lecture_1.Test@15db9742
        // lectures.lecture_1.Test - какого типа наш объект
        // 15db9742 - хэш код где он находится

    }
}

class Test{
    private int x;

    public void setX(int x){
        if (x < 0) x = -x;
        this.x = x;
    }

    public int getX() {
        // this можно не писать так как у нас нет локальной переменной. Мы будем обрщаться к локльной переменной
        return x;
    }

    // void - тип возовращаемогозначения
    // this это автоматически генерируемая ссылка на объект который вызвал тот метод в котором этот this используется
    // ссылка на объект который вызвал данный метод
}

/*
*
*
* */