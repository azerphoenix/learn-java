package info.md7.java.lessons.patterns.creational.prototype;

public class Address {

  private String postalCode;

  private String country;

  private String city;

  public Address() {}

  public Address(String postalCode, String country, String city) {
    this.postalCode = postalCode;
    this.country = country;
    this.city = city;
  }

  public Address(Address anotherAddress) {
    this(anotherAddress.postalCode, anotherAddress.country, anotherAddress.city);
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
