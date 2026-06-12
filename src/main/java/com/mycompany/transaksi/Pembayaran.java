/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transaksi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadya
 */
public class Pembayaran extends Transaksi {

    private static final Logger logger = Logger.getLogger(
        Pembayaran.class.getName()
    );

    private String pembayar;
    private String penerima;
    private String buktiBayar;

    public Pembayaran(
        int uang,
        String status,
        String pembayar,
        String penerima,
        String buktiBayar
    ) {
        super(uang, status);
        this.pembayar = pembayar;
        this.penerima = penerima;
        this.buktiBayar = buktiBayar;
    }

    public void memesanDosen() {
        logger.info("Tutor berhasil dipesan.");
    }

    public void melakukanPembayaran() {
        try {
            logger.info("Pembayaran sedang diproses...");
            logger.log(Level.INFO, "Pembayaran dilakukan oleh {0}", pembayar);
            pembayaranDiterima();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void pembayaranDiterima() {
        try {
            this.status = "sukses";
            logger.log(Level.INFO, "Pembayaran diterima oleh {0}", penerima);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void mendapatBuktiBayar() {
        logger.log(Level.INFO, "Bukti pembayaran: {0}", buktiBayar);
    }

    public void pembayaranDitolak() {
        try {
            this.status = "gagal";
            logger.info("Pembayaran ditolak.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
