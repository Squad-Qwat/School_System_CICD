package regis.login;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegistrasiTest {
    @Test
    void testRegistrasi() {
        Registrasi r = new Registrasi("Budi", "pass", "budi@mail.com");
        assertEquals("budi@mail.com", r.getEmail());

        r.setEmail("new@mail.com");
        assertEquals("new@mail.com", r.getEmail());

        assertTrue(r.register("Andi", "pass2", "andi@mail.com"));
        assertEquals("Andi", r.getUsername());
        assertEquals("pass2", r.getPassword());
        assertEquals("andi@mail.com", r.getEmail());

        assertFalse(r.register("", "pass2", "andi@mail.com"));
    }
}
