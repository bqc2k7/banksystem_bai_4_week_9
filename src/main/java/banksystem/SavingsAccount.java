package banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tài khoản tiết kiệm.
 */
public class SavingsAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);
  private static final double MAX_WITHDRAW = 1000.0;
  private static final double MIN_BALANCE = 5000.0;

  /**
   * Khởi tạo tài khoản tiết kiệm.
   */
  public SavingsAccount(long accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public void deposit(double amount) {
    double initialBal = getBalance();
    try {
      doDepositing(amount);
      double finalBal = getBalance();
      Transaction t = new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS,
          amount, initialBal, finalBal);
      addTransaction(t);
      logger.info("Nạp tiền tiết kiệm thành công: ${} vào tài khoản {}. Số dư: ${}",
          amount, getAccountNumber(), finalBal);
    } catch (BankException e) {
      logger.warn("Nạp tiền tiết kiệm thất bại cho tài khoản {}. Lý do: {}",
          getAccountNumber(), e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount) {
    double initialBal = getBalance();
    try {
      if (amount > MAX_WITHDRAW) {
        throw new InvalidFundingAmountException(amount);
      }
      if (initialBal - amount < MIN_BALANCE) {
        throw new InsufficientFundsException(amount);
      }
      doWithdrawing(amount);
      double finalBal = getBalance();
      Transaction t = new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS,
          amount, initialBal, finalBal);
      addTransaction(t);
      logger.info("Rút tiền tiết kiệm thành công: ${} từ tài khoản {}. Số dư: ${}",
          amount, getAccountNumber(), finalBal);
    } catch (BankException e) {
      logger.warn("Rút tiền tiết kiệm thất bại cho tài khoản {}. Lý do: {}",
          getAccountNumber(), e.getMessage());
    }
  }
}