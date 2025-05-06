import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseTest {

    @Test
    void testConnectionSuccess() {
        Database db = new Database();
        assertNotNull(db.getConnection());
    }
}