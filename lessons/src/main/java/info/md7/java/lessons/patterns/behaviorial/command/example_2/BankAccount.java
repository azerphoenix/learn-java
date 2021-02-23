package info.md7.java.lessons.patterns.behaviorial.command.example_2;

public class BankAccount {

  private int balance;
  private int overdraftLimit = -1000;

  public void deposit(int amount) {
    balance += amount;
    System.out.printf("Added %s amount to your balance %s", amount, System.lineSeparator());
  }

  public void withdraw(int amount) {
    if (balance - amount >= overdraftLimit) {
      balance -= amount;
      System.out.printf("Withdrew %s amount from your balance %s", amount, System.lineSeparator());
    }
  }

  @Override
  public String toString() {
    return "BankAccount{" +
        "balance=" + balance +
        '}';
  }
}
