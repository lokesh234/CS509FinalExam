import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainATMIntegrationTest {

    @Test
    void testRunWithoutCrash() {
        String simulatedInput = "testuser\n1234\n5\n"; // Provide login, PIN, Exit command
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testAdminFlowWithoutCrash() {
        String simulatedInput = "admin\n0000\n6\n"; // admin login, exit
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertDoesNotThrow(() -> MainATM.main(new String[]{}));
    }

    @Test
    void testCustomerExitWithoutCrash() {
        String simulatedInput = "johndoe\n4321\n5\n"; // customer login, exit
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
