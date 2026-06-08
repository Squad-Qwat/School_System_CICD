package com.mycompany.datadiri;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatadiriTest {
    @Test
    void testDatadiri() {
        // Datadiri is abstract, but we can test it through a concrete subclass or just check its fields
        // Since I can't easily create an anonymous subclass here, I'll use UserPelajar
        UserPelajar d = new UserPelajar("Andi", "01-01-2005", "Jakarta", "L", 15, "SMA 1", "Math", "TutorA");

        assertEquals("Andi", d.getNama());
        d.setNama("Budi");
        assertEquals("Budi", d.getNama());

        assertEquals("01-01-2005", d.getDataLahir());
        d.setDataLahir("02-02-2006");
        assertEquals("02-02-2006", d.getDataLahir());

        assertEquals("Jakarta", d.getAlamat());
        d.setAlamat("Bandung");
        assertEquals("Bandung", d.getAlamat());

        assertEquals("L", d.getJenisKelamin());
        d.setJenisKelamin("P");
        assertEquals("P", d.getJenisKelamin());

        assertEquals(15, d.getUmur());
        d.setUmur(16);
        assertEquals(16, d.getUmur());
    }
}
