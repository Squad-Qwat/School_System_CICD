/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Aktivitas;

import java.util.logging.Logger;

/**
 *
 * @author timot
 */
public class Aktivitas {

    private static final Logger logger = Logger.getLogger(
        Aktivitas.class.getName()
    );
    public static final String STATUS_MULAI = "Mulai";

    protected String jadwal;
    protected int durasi;
    protected String status;

    public Aktivitas(String jadwal, int durasi, String status) {
        this.jadwal = jadwal;
        this.durasi = durasi;
        this.status = status;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getJadwal() {
        return jadwal;
    }

    public int getDurasi() {
        return durasi;
    }

    public boolean mulaiAktivitas() {
        return status.equals(STATUS_MULAI);
    }

    public void setAktivitas(String action) {
        // Jaga-jaga method mulaiDiskusi() dipanggil lebih dari sekali
        if (STATUS_MULAI.equals(action) && status.equals("diam")) {
            status = STATUS_MULAI;
        } else {
            logger.info("Aktivitas telah dimulai, silahkan coba lagi!");
        }

        // Jaga-jaga method tutupDiskusi() dipanggil lebih dari sekali
        if ("Tutup".equals(action) && status.equals(STATUS_MULAI)) {
            status = "diam";
        } else {
            logger.info("Aktivitas sudah selesai, silahkan coba lagi!");
        }
    }

    public boolean selesaiAktivitas() {
        return status.equals("Selesai");
    }

    public String cekStatus() {
        return status;
    }
}
