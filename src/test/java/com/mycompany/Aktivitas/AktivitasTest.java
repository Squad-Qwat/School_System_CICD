package com.mycompany.Aktivitas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AktivitasTest {
    @Test
    void testAktivitas() {
        Aktivitas a = new Aktivitas("12-12-2024", 60, "diam");
        assertEquals("12-12-2024", a.getJadwal());
        assertEquals(60, a.getDurasi());
        assertFalse(a.MulaiAktivitas());

        a.setAktivitas("Mulai");
        assertEquals("Mulai", a.cekStatus());
        assertTrue(a.MulaiAktivitas());

        a.setAktivitas("Mulai");

        a.setAktivitas("Tutup");
        assertEquals("diam", a.cekStatus());
        assertFalse(a.SelesaiAktivitas());

        a.setAktivitas("Tutup");

        a.setDurasi(90);
        assertEquals(90, a.getDurasi());

        a.setJadwal("13-12-2024");
        assertEquals("13-12-2024", a.getJadwal());
    }
}
