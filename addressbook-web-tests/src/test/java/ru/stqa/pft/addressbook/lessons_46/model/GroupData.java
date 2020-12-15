package ru.stqa.pft.addressbook.lessons_46.model;

public class GroupData {
  private int id;
  private final String name;
  private final String header;
  private final String footer;



  //конструктор для инициализации параметров, которые необходимо передать в объект класса
  public GroupData(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }


  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  //создали искусственно
  public GroupData( String name, String header, String footer) {
    this.id = 0;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  //возвращаем  имя атрибута
  public String getName() {
    return name;
  }

  //возвращаем  имя атрибута
  public String getHeader() {
    return header;
  }

  //возвращаем  имя атрибута
  public String getFooter() {
    return footer;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }


}
