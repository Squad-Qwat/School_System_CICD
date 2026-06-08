package com.mycompany.classjadwal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JadwalPelajarTest {

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
    void testJadwalPelajarInfo() {
        JadwalPelajar jp = new JadwalPelajar(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "Budi"
        );
        assertEquals("ID Pelajar: 1, Nama: Budi", jp.getPelajarInfo());
    }

    @Test
    void testCekKetersediaan() {
        JadwalPelajar jp = new JadwalPelajar(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "Budi"
        );

        // Provide LOTS of lines to be safe against Scanner buffering/multiple instances
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            input.append("InputLine").append(i).append("\n");
        }
        // Specific numeric input for nextInt() at index 3 (4th line)
        String[] lines = input.toString().split("\n");
        lines[3] = "15";
        input = new StringBuilder();
        for (String line : lines) {
            input.append(line).append("\n");
        }

        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));

        assertDoesNotThrow(() -> jp.cekKetersediaan());
    }

    @Test
    void testInitializeScheduleFails() {
        JadwalPelajar jp = new JadwalPelajar(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "Budi"
        );
        assertThrows(IndexOutOfBoundsException.class, () ->
            jp.initializeSchedule()
        );
    }
}
