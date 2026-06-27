package regis.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginTest {
    @Test
    void testLogin() {
        Login l = new Login("Budi", "password123");

        assertTrue(l.login("Budi", "password123"));
        assertFalse(l.login("Budi", "wrong"));
        assertFalse(l.login("Andi", "password123"));
    }
}
