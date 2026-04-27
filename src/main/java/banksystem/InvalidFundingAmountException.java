package banksystem;

import java.util.Locale;

/**
 * Lỗi số tiền không hợp lệ.
 */
public class InvalidFundingAmountException extends BankException {
  /**
   * Khởi tạo lỗi với số tiền cụ thể.
   */
  public InvalidFundingAmountException(double amount) {
    super("Số tiền không hợp lệ: $" + String.format(Locale.US, "%.2f", amount));
  }
}