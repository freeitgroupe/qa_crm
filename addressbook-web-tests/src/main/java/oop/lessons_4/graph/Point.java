package oop.lessons_4.graph;



public class Point extends Shape{
  // Точки координат
  public int x;
  public int y;

  // Поле с таким же именем как и у родителей
  //public String color;

  /*
  * Дочерий кструктор в неявном виде вызовет родительский дефолтны   конструктор
  *
  * */
  public Point(int x, int y){
    this(x,y, DEFAULT_COLOR);
  }

  public Point(int x, int y, String color){
    super(color);// вызов родительского конструктора, вызывется всегда первым в дочернем констукторе
    this.x = x;
    this.y = y;
    //this.color = color; // данное поле есть в родительском классе
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
    // super.draw();
    System.out.printf("Point (%d, %d). Color: %S\n", x, y, color);
  }

  @Override
  public String toString(){
    return String.format("Point (%d, %d). Color: %S\n", x, y, color);
  }

  @Override
  // Тип возвращаемого значения, можно поменять на дного из наследников
  //
  public Point clone(){
    return new Point(this.x, this.y, this.color);
  }

}
