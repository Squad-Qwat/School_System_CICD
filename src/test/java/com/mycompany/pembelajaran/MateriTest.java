package com.mycompany.pembelajaran;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MateriTest {
    @Test
    void testMateri() {
        Materi m = new Materi();
        m.setJudulMateri("Math");
        m.setIsiMateri("1+1=2");
        m.setSumberReferensi("Book");

        assertEquals("Math", m.getJudulMateri());
        assertEquals("1+1=2", m.getIsiMateri());
        assertEquals("Book", m.getSumberReferensi());

        m.tampilkanMateri();
    }
}
