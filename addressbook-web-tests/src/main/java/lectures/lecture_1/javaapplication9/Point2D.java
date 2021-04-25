package lectures.lecture_1.javaapplication9;

public class Point2D {
    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override //аннотция обозначающая переопределение метода
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(")");
        return sb.toString();
        //return "Point2D{" + "x=" + x + ", y=" + y + '}';// так писать нельзя это увелич нагрузку на gc, надо использовать StringBuilder
    }
}
