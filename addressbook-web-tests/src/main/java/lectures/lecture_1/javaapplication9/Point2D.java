package lectures.lecture_1.javaapplication9;

public class Point2D {
    private int x, y;
    private double length; // длина вектора.

    public Point2D(){
        // Так как на момент создания конструктора объект размещен в памяти тогда мы можем воспользовться ссылкой this.
        // обращаемся к другому конструктору нашего класса
        this(0,0);
    }

    /*public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }*/

    // Чтобы нельзя было переопределить процесс создания объектов, сеттеры объявляем как final
    // Методы вызываемые из конструктора должны быть final, чтобы не сломать процесс создания объектов
    //
    public Point2D(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public final void setX(int x) {
        this.x = x;
        length();
    }

    public int getY() {
        return y;
    }

    public final void setY(int y) {
        this.y = y;
        length();
    }

    @Override //аннотация обозначающая переопределение метода
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(x);
        sb.append(", ");
        sb.append(y);
        sb.append(")");
        return sb.toString();
        //return "Point2D{" + "x=" + x + ", y=" + y + '}';// так писать нельзя это увелич нагрузку на gc, надо использовать StringBuilder
    }

    // Длина радиус вектора
    private void length(){
        length = Math.sqrt(x*x + y*y);
    }

    public double getLength() {
        return length;
    }
}
