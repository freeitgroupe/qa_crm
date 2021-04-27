package lectures.lecture_1.javaapplication10;

public class Test {
    private int x;

    public Test(int x) {
        this.x = x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Test{" + "x=" + x + '}';
    }
}
