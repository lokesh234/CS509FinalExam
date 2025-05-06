import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainATMIntegrationTest {

    @Test
    void testRunWithoutCrash() {
        String simulatedInput = "testuser\n1234\n5\n"; 
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminFlowWithoutCrash() {
        String simulatedInput = "admin\n0000\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminCreateAccountFlow() {
        String simulatedInput = "admin\n0000\n1\nJohn Doe\n1000.0\nactive\njohndoe\n4321\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminDeleteAccountFlow() {
        String simulatedInput = "admin\n0000\n2\n1\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminUpdateAccountFlow() {
        String simulatedInput = "admin\n0000\n3\n1\nUpdated Name\nactive\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminSearchAccountFlow() {
        String simulatedInput = "admin\n0000\n4\n1\n6\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminInvalidChoice() {
        String simulatedInput = "admin\n0000\n10";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testCustomerExitWithoutCrash() {
        String simulatedInput = "admin\n0000\n1\nJohn Doe\n1000.0\nactive\njohndoe\n4321\n6\n";
        String simulatedInput2 = "johndoe\n4321\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        System.setIn(new ByteArrayInputStream(simulatedInput2.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testCustomerDisplayBalance() {
        String simulatedInput = "admin\n0000\n1\nJohn Doe\n1000.0\nactive\njohndoe\n4321\n6\n";
        String simulatedInput2 = "johndoe\n4321\n4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        System.setIn(new ByteArrayInputStream(simulatedInput2.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testCustomerWithdrawAmount() {
        String simulatedInput = "admin\n0000\n1\nJohn Doe\n1000.0\nactive\njohndoe\n4321\n6\n" +
                                "johndoe\n4321\n1\n100\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testCustomerDepositCash() {
        String simulatedInput = "admin\n0000\n1\nJohn Doe\n1000.0\nactive\njohndoe\n4321\n6\n" +
                                "johndoe\n4321\n3\n200\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testInvalidLoginWithoutCrash() {
        String simulatedInput = "wronguser\n9999\n"; // invalid login
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }
}
