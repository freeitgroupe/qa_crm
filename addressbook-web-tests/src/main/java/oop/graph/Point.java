package oop.graph;

public class Point extends Shape{
  // Точки координат
  public int x;
  public int y;

  public Point(int x, int y){
    this(x,y, DEFAULT_COLOR);
  }

  public Point(int x, int y, String color){
    this.x = x;
    this.y = y;
    this.color = color; // данное поле есть в родительском классе
    //this.b = b; // не срабатывает так как данного поля нет в родительском классе
  }


  //Смещение по горизонтали и вертикали
  public void moveBy(int dx, int dy){
    x += dx;
    y += dy;
  }

  //Переопределили родительский метод
  @Override
  public void draw(){
    // Вызов метода родителя
    super.draw();
    System.out.printf("Point (%d, %d). Color: %S\n", x, y, color);
  }


}
