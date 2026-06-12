package com.mycompany.transaksi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PembayaranTest {

    @Test
    void testPembayaranSukses() {
        Pembayaran p = new Pembayaran(
            100000,
            "pending",
            "Budi",
            "TutorA",
            "Bukti1"
        );

        // Status should be "pending" initially
        assertEquals("pending", p.lihatStatus());

        p.memesanDosen();
        p.melakukanPembayaran();

        // melakukanPembayaran calls pembayaranDiterima which sets status to "sukses"
        assertEquals("sukses", p.lihatStatus());
        assertTrue(p.prosesTransaksi());
    }

    @Test
    void testPembayaranGagal() {
        Pembayaran p = new Pembayaran(
            50000,
            "pending",
            "Andi",
            "TutorB",
            "Bukti2"
        );
        p.pembayaranDitolak();
        assertEquals("gagal", p.lihatStatus());
        assertFalse(p.prosesTransaksi());
    }

    @Test
    void testMendapatBuktiBayar() {
        Pembayaran p = new Pembayaran(
            100000,
            "pending",
            "Budi",
            "TutorA",
            "Bukti1"
        );
        // Just verify it doesn't crash
        assertDoesNotThrow(p::mendapatBuktiBayar);
    }
}
