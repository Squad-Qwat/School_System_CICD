package com.mycompany.pembelajaran;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LatihanSoalTest {

    @Test
    void testLatihanSoal() {
        LatihanSoal ls = new LatihanSoal();
        ls.setKodeSoal("S01");
        ls.setPertanyaan("1+1?");
        ls.setPilihanJawaban("A. 1\nB. 2");
        ls.setKunciJawaban("B");
        ls.setBobot(10);
        ls.setDeadline(60);
        ls.setWaktuPengerjaan(5);

        assertEquals("S01", ls.getKodeSoal());
        assertEquals("1+1?", ls.getPertanyaan());
        assertEquals("A. 1\nB. 2", ls.getPilihanJawaban());
        assertEquals("B", ls.getKunciJawaban());
        assertEquals(10, ls.getBobot());
        assertEquals(60, ls.getDeadline());
        assertEquals(5, ls.getWaktuPengerjaan());

        ls.periksaJawaban("B");
        ls.periksaJawaban("A");
    }
}
