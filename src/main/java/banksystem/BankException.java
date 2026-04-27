package banksystem;

/**
 * Ngoại lệ ngân hàng chung.
 */
public class BankException extends Exception {
  /**
   * Khởi tạo ngoại lệ.
   */
  public BankException(String message) {
    super(message);
  }
}