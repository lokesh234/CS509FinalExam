import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    void testAdminGettersAndSetters() {
        Admin admin = new Admin("adminLogin", 1234);

        assertEquals("adminLogin", admin.getLogin());
        assertEquals(1234, admin.getPin());

        admin.setLogin("newAdmin");
        admin.setPin(5678);

        assertEquals("newAdmin", admin.getLogin());
        assertEquals(5678, admin.getPin());
    }
}