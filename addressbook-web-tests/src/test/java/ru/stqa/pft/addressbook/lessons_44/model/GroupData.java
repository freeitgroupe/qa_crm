package ru.stqa.pft.addressbook.lessons_44.model;

public class GroupData {
  private final String name;
  private final String id;
  private final String header;
  private final String footer;



  //конструктор для инициализации параметров, которые необходимо передать в объект класса
  public GroupData(String id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  //создали искусственно
  public GroupData( String name, String header, String footer) {
    this.id = null;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public String getId() {
    return id;
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

    if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
    return id != null ? id.equals(groupData.id) : groupData.id == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    return result;
  }
}
