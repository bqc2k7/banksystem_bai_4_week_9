package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Đại diện cho một khách hàng.
 */
public class Customer {
  private long idNumber;
  private String fullName;
  private List<Account> accountList;

  /**
   * Khởi tạo khách hàng mặc định.
   */
  public Customer() {
    this(0L, "");
  }

  /**
   * Khởi tạo khách hàng với ID và tên.
   */
  public Customer(long idNumber, String fullName) {
    this.idNumber = idNumber;
    this.fullName = fullName;
    this.accountList = new ArrayList<>();
  }

  /**
   * Lấy số ID.
   */
  public long getIdNumber() {
    return idNumber;
  }

  /**
   * Cài đặt ID.
   */
  public void setIdNumber(long idNumber) {
    this.idNumber = idNumber;
  }

  /**
   * Lấy họ tên.
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * Cài đặt họ tên.
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * Lấy danh sách tài khoản.
   */
  public List<Account> getAccountList() {
    return accountList;
  }

  /**
   * Cài đặt danh sách tài khoản.
   */
  public void setAccountList(List<Account> accountList) {
    if (accountList == null) {
      this.accountList = new ArrayList<>();
    } else {
      this.accountList = accountList;
    }
  }

  /**
   * Thêm tài khoản.
   */
  public void addAccount(Account account) {
    if (account != null && !accountList.contains(account)) {
      accountList.add(account);
    }
  }

  /**
   * Xóa tài khoản.
   */
  public void removeAccount(Account account) {
    if (account != null) {
      accountList.remove(account);
    }
  }

  /**
   * Lấy thông tin tóm tắt khách hàng.
   */
  public String getCustomerInfo() {
    return "Số CMND: " + idNumber + ". Họ tên: " + fullName + ".";
  }
}