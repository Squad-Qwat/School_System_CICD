package com.mycompany.Aktivitas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KonsultasiTest {

    private InputStream sysInBackup;

    @BeforeEach
    void setUp() {
        sysInBackup = System.in;
    }

    @AfterEach
    void tearDown() {
        System.setIn(sysInBackup);
    }

    @Test
    void testKonsultasi() {
        Konsultasi k = new Konsultasi("10-10-2024", 60, "diam", "TutorA", "R1");
        assertEquals("TutorA", k.getNama());
        assertEquals("R1", k.getTempat());

        String inputJadwal = "11-10-2024\n5\n";
        System.setIn(new ByteArrayInputStream(inputJadwal.getBytes()));
        k.melakukanPenjadwalan();
        assertEquals("11-10-2024", k.getJadwal());

        String inputTempat = "R2\n";
        System.setIn(new ByteArrayInputStream(inputTempat.getBytes()));
        k.mengaturTempat();
        assertEquals("R2", k.getTempat());

        String inputTutor = "TutorB\n";
        System.setIn(new ByteArrayInputStream(inputTutor.getBytes()));
        k.menentukanTutor();
        assertEquals("TutorB", k.getNama());

        String inputTopik = "Math\n";
        System.setIn(new ByteArrayInputStream(inputTopik.getBytes()));
        k.menentukanTopik();
    }
}
