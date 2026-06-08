package regis.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void testUser() {
        User u = new User("Budi", "pass");
        assertEquals("Budi", u.getUsername());
        assertEquals("pass", u.getPassword());
        assertTrue(u.getId().startsWith("USR"));

        u.setUsername("Andi");
        u.setPassword("newpass");
        assertEquals("Andi", u.getUsername());
        assertEquals("newpass", u.getPassword());
    }
}
