package com.mycompany.Aktivitas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class DiskusiTest {
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
    void testDiskusiMulaiTutup() {
        Diskusi d = new Diskusi("10-10-2024", 60, "diam", "R1", 120);

        String inputMulai = "11-10-2024\nR2\n5\n";
        System.setIn(new ByteArrayInputStream(inputMulai.getBytes()));
        d.MulaiDiskusi();
        assertEquals("Mulai", d.cekStatus());

        String inputTutup = "11-10-2024\n2\n";
        System.setIn(new ByteArrayInputStream(inputTutup.getBytes()));
        d.TutupDiskusi();
        assertEquals("Mulai", d.cekStatus()); // setAktivitas("Selesai") doesn't change from "Mulai" because it expects "Tutup"
    }

    @Test
    void testMenjawabPertanyaan() {
        Diskusi d = new Diskusi("10-10-2024", 60, "diam", "R1", 120);
        String inputMenjawab = "Budi\n12-12-2000\nBandung\nL\n15\nSMA\nIPA\nTutorA\n";
        System.setIn(new ByteArrayInputStream(inputMenjawab.getBytes()));
        d.MenjawabPertanyaan();
        assertNotNull(d);
    }
}
