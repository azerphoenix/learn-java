package info.md7.java.homeworks.hw_8.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {

  private static final long serialVersionUID = 1L;

  private long productId;
  private String productName;
  private ProductType productType;
  private LocalDate productionDate;
  private double cost;

  public Product() {}

  public Product(long productId, String productName, ProductType productType,
      LocalDate productionDate, double cost) {
    this.productId = productId;
    this.productName = productName;
    this.productType = productType;
    this.productionDate = productionDate;
    this.cost = cost;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public ProductType getProductType() {
    return productType;
  }

  public void setProductType(ProductType productType) {
    this.productType = productType;
  }

  public LocalDate getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(LocalDate productionDate) {
    this.productionDate = productionDate;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "Product{" +
        "productId=" + productId +
        ", productName='" + productName + '\'' +
        ", productType=" + productType.name +
        ", productionDate=" + productionDate +
        ", cost=" + cost +
        '}';
  }

}
