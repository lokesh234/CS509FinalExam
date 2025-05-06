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
}