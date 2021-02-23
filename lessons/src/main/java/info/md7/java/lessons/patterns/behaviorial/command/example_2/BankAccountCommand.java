package info.md7.java.lessons.patterns.behaviorial.command.example_2;

public class BankAccountCommand {

  private BankAccount bankAccount;

  public enum Operation {
    DEPOSIT, WITHDRAW
  }

  private Operation operation;
  private int amount;

  public BankAccountCommand(
      BankAccount bankAccount,
      Operation operation, int amount) {
    this.bankAccount = bankAccount;
    this.operation = operation;
    this.amount = amount;
  }

  public void call() {
    switch (operation) {
      case DEPOSIT:
        bankAccount.deposit(amount);
        break;
      case WITHDRAW:
        bankAccount.withdraw(amount);
        break;
    }
  }

}
