package oop.lessons_4.graph;

import org.checkerframework.checker.signature.qual.IdentifierOrPrimitiveType;

import java.io.Serializable;


public class Circle extends Shape implements Scaleable, Serializable, Moveble {

    public int x;
    public int y;
    private int r;

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getR(){
        return r;
    }

    public int setR(int r){
        if(r > 0 )
           return this.r = r;
        else
            throw new RuntimeException("radius < = 0");
    }

    public Circle(int x, int y, int r, String color){
        //Для инициализации цвета вызовим родительский кнструктор
        super(color);
        this.x = x;
        this.y = y;
        setR(r);
    }

    public void scale(double factor){
        r = (int)(factor * r );
        setR((int)(factor * getR()));
    }

    public void scale(){
        scale(Scaleable.DEFAULT_FACTOR);
    }

    @Override
    public String toString() {
        return String.format("Circle (%d, %d) R: %d Color: %s", x, y, getR(), color);
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
