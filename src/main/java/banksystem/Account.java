package banksystem;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lớp này đại diện cho tài khoản chung trong hệ thống ngân hàng.
 */
public abstract class Account {
  private static final Logger logger = LoggerFactory.getLogger(Account.class);
  public static final String CHECKING_TYPE = "CHECKING";
  public static final String SAVINGS_TYPE = "SAVINGS";

  private long accountNumber;
  private double balance;
  protected List<Transaction> transactionList;

  /**
   * Khởi tạo tài khoản với số tài khoản và số dư.
   */
  public Account(long accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.transactionList = new ArrayList<>();
  }

  /**
   * Lấy số tài khoản.
   */
  public long getAccountNumber() {
    return accountNumber;
  }

  /**
   * Cài đặt số tài khoản.
   */
  public void setAccountNumber(long accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * Lấy số dư.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Cài đặt số dư.
   */
  protected void setBalance(double balance) {
    this.balance = balance;
  }

  /**
   * Lấy danh sách giao dịch.
   */
  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  /**
   * Cài đặt danh sách giao dịch.
   */
  public void setTransactionList(List<Transaction> transactionList) {
    if (transactionList == null) {
      this.transactionList = new ArrayList<>();
    } else {
      this.transactionList = transactionList;
    }
  }

  /**
   * Nạp tiền vào tài khoản.
   */
  public abstract void deposit(double amount);

  /**
   * Rút tiền khỏi tài khoản.
   */
  public abstract void withdraw(double amount);

  /**
   * Thực hiện nạp tiền logic.
   */
  protected void doDepositing(double amount) throws InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    balance += amount;
  }

  /**
   * Thực hiện rút tiền logic.
   */
  protected void doWithdrawing(double amount) throws InsufficientFundsException,
      InvalidFundingAmountException {
    if (amount <= 0) {
      throw new InvalidFundingAmountException(amount);
    }
    if (amount > balance) {
      throw new InsufficientFundsException(amount);
    }
    balance -= amount;
  }

  /**
   * Thêm một giao dịch vào lịch sử.
   */
  public void addTransaction(Transaction transaction) {
    if (transaction != null) {
      transactionList.add(transaction);
      // Dùng DEBUG vì đây là hoạt động chạy ngầm, không cần báo cáo thường xuyên
      logger.debug("Đã lưu bản ghi giao dịch mới cho tài khoản {}", accountNumber);
    }
  }

  /**
   * Lấy lịch sử giao dịch.
   */
  public String getTransactionHistory() {
    logger.debug("Đang truy xuất lịch sử giao dịch của tài khoản {}", accountNumber);

    StringBuilder s = new StringBuilder("Lịch sử giao dịch của tài khoản "
        + accountNumber + ":\n");
    for (int i = 0; i < transactionList.size(); i++) {
      s.append(transactionList.get(i).getTransactionSummary());
      if (i < transactionList.size() - 1) {
        s.append("\n");
      }
    }
    return s.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Account)) {
      return false;
    }
    Account other = (Account) obj;
    return this.accountNumber == other.accountNumber;
  }

  @Override
  public int hashCode() {
    return (int) (accountNumber ^ (accountNumber >>> 32));
  }
}