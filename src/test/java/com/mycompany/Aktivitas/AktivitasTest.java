package com.mycompany.Aktivitas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AktivitasTest {

    @Test
    void testAktivitas() {
        Aktivitas a = new Aktivitas("12-12-2024", 60, "diam");
        assertEquals("12-12-2024", a.getJadwal());
        assertEquals(60, a.getDurasi());
        assertFalse(a.mulaiAktivitas());

        a.setAktivitas("Mulai");
        assertEquals("Mulai", a.cekStatus());
        assertTrue(a.mulaiAktivitas());

        a.setAktivitas("Mulai");

        a.setAktivitas("Tutup");
        assertEquals("diam", a.cekStatus());
        assertFalse(a.selesaiAktivitas());

        a.setAktivitas("Tutup");

        a.setDurasi(90);
        assertEquals(90, a.getDurasi());

        a.setJadwal("13-12-2024");
        assertEquals("13-12-2024", a.getJadwal());
    }
}
