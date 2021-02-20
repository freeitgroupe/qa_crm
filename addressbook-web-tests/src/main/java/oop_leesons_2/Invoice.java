package oop_leesons_2;

import java.util.ArrayList;

public class Invoice {

  private double total;
  private String customer;

  private ArrayList<Line> lines = new ArrayList<Line>();

  public String getCustomer(){
    return customer;
  }

  public void setCustomer(String customer){
    this.customer = customer;
  }

  public  double getTotal(){
    return total;
  }

  public Invoice(String customer){
    setCustomer(customer);
  }

  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append(String.format("%-30s : %8.2f", getCustomer(), getTotal()));
     for(Line l : lines){
       sb.append(l.toString()).append("\n");
     }
    return sb.toString();
  }

  // outer in string/
  public class Line{
    private String good; // товар
    private double price; // цена на товар
    private int quantity; //количество
    private double summa; // сумма по строке

      private void updateSumma(boolean isNew){
        //при измнении данных
        if(!isNew) total -= summa;
        summa = price * quantity;
        total += summa;
      }

      private void updateSumma(){
        updateSumma(false);
      }


    public void setGood(String good){
      this.good = good;
    }
    public String getGood(){
      return  good;
    }
    public void setPrice(double price){
      this.price = price;
      updateSumma();
    }
    public double getPrice(){
      return price;
    }
    public void setQuantity(int quantity){
      this.quantity = quantity;
      updateSumma();
    }
    public int getQuantity(){
      return quantity;
    }
    public double getSumma(){
      return summa;
    }

    public Line(String good, double price, int quantity) {
      setGood(good);
      setPrice(price);
      setQuantity(quantity);
      updateSumma(true);
      lines.add(this);
    }
  }



}
