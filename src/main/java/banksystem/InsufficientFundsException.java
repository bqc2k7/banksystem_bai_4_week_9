package banksystem;

import java.util.Locale;

/**
 * Lỗi không đủ tiền.
 */
public class InsufficientFundsException extends BankException {
  /**
   * Khởi tạo lỗi với số tiền cụ thể.
   */
  public InsufficientFundsException(double amount) {
    super("Số dư tài khoản không đủ $" + String.format(Locale.US, "%.2f", amount)
        + " để thực hiện giao dịch");
  }
}