package oop.lessons_4.graph;


import java.util.ArrayList;

/*
* Супер класс,  некая графическая фигура.
* Если класс final, тогда от него нельзя унаследовться
* */
public /*final*/ abstract class Shape {
  public String color;
  // Наша сцена
  static ArrayList<Shape> scene = new ArrayList<>();

    public static final String DEFAULT_COLOR = "black";

    public Shape(){
        this(DEFAULT_COLOR);
    }

    public Shape(String color){
      System.out.println("shape ctor");
      this.color  = color;
      scene.add(this);
    }

    //
    public static void drawScene(){
        for(Shape s : scene){
          s.draw();
        }
    }

    public static void scaleScene(double factor){
      for(Shape s : scene){
        // bad
        if(s instanceof Scaleable){
          Scaleable sc = (Scaleable)s;
          sc.scale(factor);
        }

      }
    }

  /*
  *  final - значит метод нельзя переопределить
  * */
  public void /*final*/ draw(){
    System.out.printf("Shape. Color: %S\n", color);
  }

}