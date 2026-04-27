package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

public class PathTest {

  // Đã comment (hoặc xóa) hàm test lỗi để CI/CD có thể pass trên Linux/Mac
  /*
  @Test
  public void testExportPath() {
    Bank bank = new Bank();
    String result = bank.getExportPath("data");
    assertEquals("data\\exports\\customers.txt", result);
  }
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