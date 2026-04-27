package banksystem;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Lớp kiểm thử đa nền tảng cho xử lý đường dẫn tệp.
 */
public class PathTest {

  /**
   * Kiểm thử tạo đường dẫn tương thích với mọi hệ điều hành.
   */
  @Test
  public void testExportPathRefactored() {
    Bank bank = new Bank();
    String result = bank.getExportPath("data");

    // Sử dụng File.separator để bài test tự hiểu dấu phân tách của OS đang chạy
    String expected = "data" + File.separator + "exports" + File.separator + "customers.txt";

    assertEquals(expected, result, "Đường dẫn phải tương thích với mọi hệ điều hành");
  }
}