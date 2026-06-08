package com.mycompany.classjadwal;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JadwalTutorTest {

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
    void testJadwalTutorInfo() {
        JadwalTutor jt = new JadwalTutor(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "TutorA",
            4.5f
        );
        assertEquals(
            "ID Tutor: 1, Nama: TutorA, Rating: 4.5",
            jt.getTutorInfo()
        );
        assertEquals(1, jt.getIdTutor());
        jt.setRating(4.8f);
    }

    @Test
    void testCekKetersediaan() {
        JadwalTutor jt = new JadwalTutor(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "TutorA",
            4.5f
        );

        // Provide LOTS of lines
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            input.append("InputLine").append(i).append("\n");
        }
        // nextInt() at index 3
        String[] lines = input.toString().split("\n");
        lines[3] = "30";
        // for menjalankanTutoring's Integer.parseInt
        lines[10] = "1";

        input = new StringBuilder();
        for (String line : lines) {
            input.append(line).append("\n");
        }

        System.setIn(new ByteArrayInputStream(input.toString().getBytes()));

        assertDoesNotThrow(() -> jt.cekKetersediaan());
    }

    @Test
    void testInitializeScheduleFails() {
        JadwalTutor jt = new JadwalTutor(
            10,
            "Oktober",
            2024,
            "Senin",
            "10A",
            "Math",
            1,
            "TutorA",
            4.5f
        );
        assertThrows(IndexOutOfBoundsException.class, () ->
            jt.initializeSchedule()
        );
    }
}
