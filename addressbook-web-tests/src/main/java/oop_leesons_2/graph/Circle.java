package oop_leesons_2.graph;

public class Circle extends Shape {
    public int x;
    public int y;
    public int r;

    public Circle(int x, int y, int r, String color){
        //Для инициализации цвета вызовим родительский кнструктор
        super(color);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void scale(double factor){
        r = (int)(factor * r );
    }

    @Override
    public String toString() {
        return String.format("Circle (%d, %d) R: %d Color: %s", x,y,r,color);
    }

    /*
    * Переопределили метод draw
    * */
    @Override
    public void draw() {
        // В данном случае this возвращает объект который создается.
        System.out.println(this);
    }
}
