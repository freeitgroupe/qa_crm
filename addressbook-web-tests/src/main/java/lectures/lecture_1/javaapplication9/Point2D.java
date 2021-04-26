package lectures.lecture_1.javaapplication9;

import oop.graph.Point;

public class Point2D {
    private int x, y;
    private double length; // длина вектора.
    private static int pointsCounter;
    private final int pointID; // финальное поле должно быть заданно явно или в конструкторе

    static {
        System.out.println("Static block");
    }

    public Point2D(){
        // Так как на момент создания конструктора объект размещен в памяти тогда мы можем воспользовться ссылкой this.
        // обращаемся к другому конструктору нашего класса
        // this может быть вызван только первым в строке
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
        pointID = pointsCounter++;
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
        // return "Point2D{" + "x=" + x + ", y=" + y + '}';// так писать нельзя это увелич нагрузку на gc, надо использовать StringBuilder
    }

    public double distanceTo(Point2D rValue){
      return  Math.sqrt((this.x - rValue.x) * (this.x - rValue.x) +
              (this.y - rValue.y) * (this.y - rValue.y));
    }

    // Длина радиус вектора
    private void length(){
        length = Math.sqrt(x*x + y*y);
    }

    public double getLength() {
        return length;
    }

    public int getID() {
        return pointID;
    }

    public static int getPointsCounter() {
        return pointsCounter;
    }
}
