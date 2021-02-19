package info.md7.java.homeworks.hw_7.task.pojo;

public class Item implements Comparable<Item> {

  private int sku;
  private String name;
  private double weight;

  public Item(int sku, String name, double weight) {
    this.sku = sku;
    this.name = name;
    this.weight = weight;
  }

  @Override
  public int compareTo(Item o) {
    return sku - o.getSku();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getSku() {
    return sku;
  }

  public void setSku(int sku) {
    this.sku = sku;
  }

  @Override
  public String toString() {
    return "Товар{" +
        "Название: '" + name + '\'' +
        ", Вес: " + weight +
        '}';
  }

}
