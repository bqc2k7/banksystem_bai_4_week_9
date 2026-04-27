package banksystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckingAccountTest {

  @Test
  public void testDepositSuccess() {
    CheckingAccount account = new CheckingAccount(123456789L, 1000.0);
    account.deposit(500.0);

    // Kiểm tra xem số dư có được cộng đúng không (1000 + 500 = 1500)
    assertEquals(1500.0, account.getBalance(), "Số dư sau khi nạp phải là 1500.0");
  }

  @Test
  public void testWithdrawSuccess() {
    CheckingAccount account = new CheckingAccount(123456789L, 1000.0);
    account.withdraw(200.0);

    // Kiểm tra xem số dư có bị trừ đúng không (1000 - 200 = 800)
    assertEquals(800.0, account.getBalance(), "Số dư sau khi rút phải là 800.0");
  }
}