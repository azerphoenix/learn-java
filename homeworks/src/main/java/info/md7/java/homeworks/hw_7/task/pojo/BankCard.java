package info.md7.java.homeworks.hw_7.task.pojo;

import java.time.LocalDate;

public class BankCard {

  private String owner;
  private String cardNumber;
  private int cvv;
  private LocalDate expirationDate;

  public BankCard(String owner, String cardNumber, int cvv, LocalDate expirationDate) {
    this.owner = owner;
    this.cardNumber = cardNumber;
    this.cvv = cvv;
    this.expirationDate = expirationDate;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public int getCvv() {
    return cvv;
  }

  public void setCvv(int cvv) {
    this.cvv = cvv;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  @Override
  public String toString() {
    return "BankCard{" +
        "Владелец: '" + owner + '\'' +
        ", Номер карты: '" + cardNumber + '\'' +
        ", CVV: " + cvv +
        ", Срок: " + expirationDate +
        '}';
  }

}
