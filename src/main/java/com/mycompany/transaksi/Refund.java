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
public class Refund extends Transaksi {

    private static final Logger logger = Logger.getLogger(
        Refund.class.getName()
    );
    private String surat;
    private String murid;

    public Refund(int uang, String status, String surat, String murid) {
        super(uang, status);
        this.surat = surat;
        this.murid = murid;
    }

    public void membuatSuratPengajuanRefund() {
        try {
            logger.log(
                Level.INFO,
                "Surat pengajuan refund dibuat oleh: {0}",
                murid
            );
            logger.log(Level.INFO, "Isi surat: {0}", surat);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public void dapatUangKembali() {
        try {
            if (prosesTransaksi()) {
                logger.info(lihatStatus());
                logger.log(
                    Level.INFO,
                    "Uang sejumlah {0} telah dikembalikan kepada {1}",
                    new Object[] { uang, murid }
                );
            } else {
                logger.info("Proses refund gagal.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
        }
    }
}
