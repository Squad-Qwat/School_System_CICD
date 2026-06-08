package com.mycompany.pembelajaran;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PembelajaranTest {
    @Test
    void testPembelajaran() {
        Pembelajaran p = new Pembelajaran();
        p.setKodeMataPelajaran("M01");
        p.setNamaMataPelajaran("Math");
        p.setJenjangPendidikan("SMA");

        assertEquals("M01", p.getKodeMataPelajaran());
        assertEquals("Math", p.getNamaMataPelajaran());
        assertEquals("SMA", p.getJenjangPendidikan());

        p.tampilkanInfo();
    }
}
