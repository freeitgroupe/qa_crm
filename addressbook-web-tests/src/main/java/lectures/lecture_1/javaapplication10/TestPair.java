package lectures.lecture_1.javaapplication10;

public class TestPair extends Test {
    private int y;

    // super(x) - вызывется конструктор родительского класса
    // после чего вызывается конструктор для нашего класса
    public TestPair(int x, int y) {
        super(x);
        this.y = y;
    }
}
