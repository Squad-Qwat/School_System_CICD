package com.mycompany.classjadwal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JadwalTest {

    @Test
    void testJadwal() {
        Jadwal j = new Jadwal(
            new DateInfo(10, "Oktober", 2024, "Senin"),
            "10A",
            "Math"
        );
        assertEquals(10, j.getTanggal());
        assertEquals("Oktober", j.getBulan());
        assertEquals(2024, j.getTahun());
        assertEquals("Senin", j.getHari());
        assertEquals("10A", j.getKelas());
        assertEquals("Math", j.getMataPelajaran());

        j.setTanggal(11);
        j.setBulan("November");
        j.setTahun(2025);
        j.setHari("Selasa");
        j.setKelas("11B");
        j.setMataPelajaran("Fisika");

        assertEquals(11, j.getTanggal());
        assertEquals("November", j.getBulan());
        assertEquals(2025, j.getTahun());
        assertEquals("Selasa", j.getHari());
        assertEquals("11B", j.getKelas());
        assertEquals("Fisika", j.getMataPelajaran());
    }
}
