package ru.stqa.pft.addressbook.lessons_43.model;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  //конструктор для инициализации параметров, которые необходимо передать в объект класса
  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
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
            '}';
  }
  /*Сгенирировали для сравнения списков equals()*/
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
