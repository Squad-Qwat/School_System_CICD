package com.mycompany.transaksi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TransaksiTest {
    @Test
    void testTransaksi() {
        Transaksi t = new Transaksi(50000, "sukses");
        assertTrue(t.prosesTransaksi());
        assertEquals("sukses", t.lihatStatus());

        Transaksi t2 = new Transaksi(50000, "gagal");
        assertFalse(t2.prosesTransaksi());
        assertEquals("gagal", t2.lihatStatus());
    }
}
