package ru.stqa.pft.addressbook.lessons_22;

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
}
