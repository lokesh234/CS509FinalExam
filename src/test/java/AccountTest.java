import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testGettersAndSetters() {
        Account account = new Account(1, "John Doe", 1000.0, "active", "johndoe", 1234);

        assertEquals(1, account.getAccountNumber());
        assertEquals("John Doe", account.getHolderName());
        assertEquals(1000.0, account.getBalance());
        assertEquals("active", account.getStatus());
        assertEquals("johndoe", account.getLogin());
        assertEquals(1234, account.getPin());

        account.setBalance(2000.0);
        account.setHolderName("Jane Doe");
        account.setStatus("inactive");

        assertEquals(2000.0, account.getBalance());
        assertEquals("Jane Doe", account.getHolderName());
        assertEquals("inactive", account.getStatus());
    }
}