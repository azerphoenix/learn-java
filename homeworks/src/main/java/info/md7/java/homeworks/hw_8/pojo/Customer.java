package info.md7.java.homeworks.hw_8.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private String username;
  private String password;
  private double amountOfMoney;
  private List<Product> purchasedProducts;
  private String savedDataPath;
  private String serializedDataPath;

  public Customer() {}

  public Customer(String username, String password, double amountOfMoney) {
    this.username = username;
    this.password = password;
    this.amountOfMoney = amountOfMoney;
    this.purchasedProducts = new ArrayList<>();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public double getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(double amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }

  public List<Product> getPurchasedProducts() {
    return purchasedProducts;
  }

  public void setPurchasedProducts(List<Product> purchasedProducts) {
    this.purchasedProducts = purchasedProducts;
  }

  public String getSavedDataPath() {
    return savedDataPath;
  }

  public void setSavedDataPath(String savedDataPath) {
    this.savedDataPath = savedDataPath;
  }

  public String getSerializedDataPath() {
    return serializedDataPath;
  }

  public void setSerializedDataPath(String serializedDataPath) {
    this.serializedDataPath = serializedDataPath;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", amountOfMoney=" + amountOfMoney +
        ", purchasedProducts=" + purchasedProducts +
        '}';
  }

}
