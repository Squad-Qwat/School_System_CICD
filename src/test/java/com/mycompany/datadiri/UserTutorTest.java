package com.mycompany.datadiri;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
// import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTutorTest {

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
    void testUserTutor() {
        UserTutor ut = new UserTutor(
            "TutorA",
            "10-10-1990",
            "Jakarta",
            "L",
            30,
            "UI",
            "5 tahun",
            "Java"
        );
        ut.mengisiBioData(
            "TutorB",
            "11-11-1991",
            "Bandung",
            "L",
            31,
            "ITB",
            "6 tahun",
            "Python"
        );
        assertEquals("TutorB", ut.getNama());

        // Note: Original code uses BufferedReader for these.
        // If Scanner is used elsewhere, this might fail, but in this isolated test it should be okay.
        String inputJadwal = "Math\n";
        System.setIn(new ByteArrayInputStream(inputJadwal.getBytes()));
        ut.menerimaPesanan("Pesanan 1");

        ut.menolakPesanan("Pesanan 2");
        ut.membuatLatihanSoal();
        ut.menilaiLatihanSoal();
        ut.menguploadMateri();

        String inputTutoring = "1\n";
        System.setIn(new ByteArrayInputStream(inputTutoring.getBytes()));
        ut.menjalankanTutoring();
    }
}
