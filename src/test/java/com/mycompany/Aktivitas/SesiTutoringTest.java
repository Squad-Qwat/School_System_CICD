package com.mycompany.Aktivitas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SesiTutoringTest {

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
    void testSesiTutoring() {
        SesiTutoring.TutoringDetails details = new SesiTutoring.TutoringDetails(
            "M1",
            "T1",
            "Tugas1",
            "Course1",
            "Catatan1"
        );
        SesiTutoring s = new SesiTutoring("10-10-2024", 60, "diam", details);

        assertEquals("M1", s.getIdMurid());
        assertEquals("T1", s.getIdTutor());
        assertEquals("Tugas1", s.getTugas());
        assertEquals("Course1", s.getNamaCourse());
        assertEquals("Catatan1", s.getCatatanPembelajaran());

        s.setIdMurid("M2");
        s.setIdTutor("T2");
        s.setTugas("Tugas2");
        s.setNamaCourse("Course2");
        s.setCatatanPembelajaran("Catatan2");

        s.postTugas();
        s.postCatatanPembelajaran();
        s.selesaikanTugas();

        String inputCatatan = "Catatan3\n";
        System.setIn(new ByteArrayInputStream(inputCatatan.getBytes()));
        s.tambahCatatanPembelajaran();
        assertEquals("Catatan3", s.getCatatanPembelajaran());
    }
}
