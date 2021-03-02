package ru.stqa.pft.addressbook.lessons_70.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.lessons_70.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-count", description = "Group count")
  public int count;

  @Parameter(names = "-file", description = "Target file")
  public String file;

  @Parameter(names = "-data", description = "format")
  public String format;


  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator = new GroupDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try{
      jCommander.parse(args);
    }catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<GroupData> groups = generateGroups(count);
    if(format.equals("csv")){
      saveAsCsv(groups, new File(file));
    }else if(format.equals("xml")){
      saveAsXml(groups, new File(file));
    }else if(format.equals("json")){
      saveAsJson(groups, new File(file));
    }else{
      System.out.println("unknown " + format);
    }
  }

  private void saveAsJson(List<GroupData> groups, File file) throws IOException {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting() //Configures Gson to output Json that fits in a page for pretty printing.
            .excludeFieldsWithoutExposeAnnotation()//Configures Gson to exclude all fields from consideration for serialization or deserialization that do not have the Expose annotation.
            .create();// create object
    String json = gson.toJson(groups);
    try(Writer writer = new FileWriter(file)) {
      writer.write(json);
      //writer.close(); - файл закрывается сам в конструкции try
    }


  }

  private void saveAsXml(List<GroupData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    //xstream.alias("group",GroupData.class);
    xstream.processAnnotations(GroupData.class);
    String xml = xstream.toXML(groups);
    try(Writer writer = new FileWriter(file)){
      writer.write(xml);
    }

  }

  private void saveAsCsv(List<GroupData> groups, File file) throws IOException {
    try(Writer writer = new FileWriter(file)){
      for(GroupData group : groups){
        writer.write(String.format("%s;%s;%s;\n", group.getName(), group.getHeader(), group.getFooter() ));
      }
    }

  }

  private List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for(int i=0; i < count; i++){
      groups.add(new GroupData()
                      .withName(String.format("test %s", i))
                      .withHeader(String.format("header %s", i))
                      .withFooter(String.format("footer %s", i))
      );
    }
    return groups;
  }

}
