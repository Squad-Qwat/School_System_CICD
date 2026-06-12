package com.mycompany.datadiri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserPelajarTest {

    @Test
    void testUserPelajar() {
        UserPelajar up = new UserPelajar(
            "Andi",
            "01-01-2005",
            "Jakarta",
            "L",
            15,
            "SMA 1",
            "Math",
            "TutorA"
        );

        assertEquals("SMA 1", up.getSekolah());
        up.setSekolah("SMA 2");
        assertEquals("SMA 2", up.getSekolah());

        up.setCourse("Physics");
        up.setTutor("TutorB");

        up.memilihTutor("TutorC");
        up.menghubungiViaChat();

        // melakukanPembayaran uses Pembayaran class which we know works
        assertDoesNotThrow(() ->
            up.melakukanPembayaran(1000, "Andi", "TutorC")
        );
    }

    @Test
    void testMengisiBioData() {
        UserPelajar up = new UserPelajar("Guest", "", "", "", 0, "", "", "");
        up.mengisiBioData(
            new BioData(
                "Budi",
                "02-02-2006",
                "Bandung",
                "L",
                14,
                "SMP 1",
                "English",
                "TutorD"
            )
        );

        assertEquals("Budi", up.getNama());
        assertEquals("02-02-2006", up.getDataLahir());
        assertEquals("Bandung", up.getAlamat());
        assertEquals("L", up.getJenisKelamin());
        assertEquals(14, up.getUmur());
        assertEquals("SMP 1", up.getSekolah());
    }
}
