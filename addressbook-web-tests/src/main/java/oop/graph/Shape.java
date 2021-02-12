package oop.graph;


/*
* Супер класс,  некая графическая фигура.
* */
public class Shape {
  public String color;

  public static final String DEFAULT_COLOR = "black";

  public Shape(){
    this(DEFAULT_COLOR);
  }

  public Shape(String color){
    this.color  = color;
  }

  public void draw(){
    System.out.printf("Shape. Color: %S\n", color);
  }

}
