package banksystem;

import java.util.Locale;

/**
 * Đại diện cho một giao dịch trong hệ thống.
 */
public class Transaction {
  public static final int TYPE_DEPOSIT_CHECKING = 1;
  public static final int TYPE_WITHDRAW_CHECKING = 2;
  public static final int TYPE_DEPOSIT_SAVINGS = 3;
  public static final int TYPE_WITHDRAW_SAVINGS = 4;

  private int type;
  private double amount;
  private double initialBalance;
  private double finalBalance;

  /**
   * Khởi tạo giao dịch.
   */
  public Transaction(int type, double amount, double initialBalance, double finalBalance) {
    this.type = type;
    this.amount = amount;
    this.initialBalance = initialBalance;
    this.finalBalance = finalBalance;
  }

  /**
   * Lấy kiểu giao dịch.
   */
  public int getType() {
    return type;
  }

  /**
   * Cài đặt kiểu giao dịch.
   */
  public void setType(int type) {
    this.type = type;
  }

  /**
   * Lấy số tiền giao dịch.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Cài đặt số tiền.
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Lấy số dư đầu.
   */
  public double getInitialBalance() {
    return initialBalance;
  }

  /**
   * Cài đặt số dư đầu.
   */
  public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
  }

  /**
   * Lấy số dư cuối.
   */
  public double getFinalBalance() {
    return finalBalance;
  }

  /**
   * Cài đặt số dư cuối.
   */
  public void setFinalBalance(double finalBalance) {
    this.finalBalance = finalBalance;
  }

  /**
   * Trả về chuỗi mô tả kiểu giao dịch.
   */
  public static String getTypeString(int transactionType) {
    switch (transactionType) {
      case TYPE_DEPOSIT_CHECKING:
        return "Nạp tiền vãng lai";
      case TYPE_WITHDRAW_CHECKING:
        return "Rút tiền vãng lai";
      case TYPE_DEPOSIT_SAVINGS:
        return "Nạp tiền tiết kiệm";
      case TYPE_WITHDRAW_SAVINGS:
        return "Rút tiền tiết kiệm";
      default:
        return "Không rõ";
    }
  }

  /**
   * Lấy chuỗi tóm tắt giao dịch.
   */
  public String getTransactionSummary() {
    return "- Kiểu giao dịch: " + getTypeString(type)
        + ". Số dư ban đầu: $" + String.format(Locale.US, "%.2f", initialBalance)
        + ". Số tiền: $" + String.format(Locale.US, "%.2f", amount)
        + ". Số dư cuối: $" + String.format(Locale.US, "%.2f", finalBalance) + ".";
  }
}