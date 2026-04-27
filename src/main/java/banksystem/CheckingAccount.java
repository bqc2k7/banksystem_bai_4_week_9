package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản vãng lai.
 */
public class CheckingAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(CheckingAccount.class);

  /**
   * Khởi tạo tài khoản vãng lai.
   */
  public CheckingAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBalance = getBalance();
    try {
      doDepositing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_DEPOSIT_CHECKING, amount, initialBalance, finalBalance);
      addTransaction(t);
      logger.info("Nạp tiền thành công: ${} vào tài khoản {}. Số dư mới: ${}",
          amount, getAccountNumber(), finalBalance);
    } catch (BankException e) {
      logger.warn("Giao dịch nạp tiền thất bại cho tài khoản {}. Lý do: {}",
          getAccountNumber(), e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBalance = getBalance();
    try {
      doWithdrawing(amount);
      double finalBalance = getBalance();
      Transaction t = new Transaction(
          Transaction.TYPE_WITHDRAW_CHECKING, amount, initialBalance, finalBalance);
      addTransaction(t);
      logger.info("Rút tiền thành công: ${} từ tài khoản {}. Số dư mới: ${}",
          amount, getAccountNumber(), finalBalance);
    } catch (BankException e) {
      logger.warn("Giao dịch rút tiền thất bại cho tài khoản {}. Lý do: {}",
          getAccountNumber(), e.getMessage());
    }
  }
}