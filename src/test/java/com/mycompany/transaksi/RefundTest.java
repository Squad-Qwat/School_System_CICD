package com.mycompany.transaksi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RefundTest {

    @Test
    void testRefundSukses() {
        // Refund status "sukses" for it to pass prosesTransaksi()
        Refund r = new Refund(100000, "sukses", "Batal kelas", "Budi");

        assertEquals("sukses", r.lihatStatus());
        assertTrue(r.prosesTransaksi());

        r.membuatSuratPengajuanRefund();
        // dapatUangKembali() calls prosesTransaksi()
        assertDoesNotThrow(() -> r.dapatUangKembali());
    }

    @Test
    void testRefundGagal() {
        Refund r = new Refund(50000, "gagal", "Salah bayar", "Andi");
        assertFalse(r.prosesTransaksi());
        assertDoesNotThrow(() -> r.dapatUangKembali());
    }
}
