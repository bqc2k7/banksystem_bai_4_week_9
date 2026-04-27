package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
  @Test
  public void testExportPath() {
    Bank bank = new Bank();
    String result = bank.getExportPath("data");

    // Bài test này sẽ CHỈ CHẠY ĐÚNG TRÊN WINDOWS
    // Trên Ubuntu/macOS, đường dẫn mong đợi của hệ thống là "data/exports/customers.txt"
    // Nhưng hàm đang trả về "data\exports\customers.txt" -> Test Fail
    assertEquals("data\\exports\\customers.txt", result);
  }
}