/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Aktivitas;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timot
 */
public class Konsultasi extends Aktivitas {

    private static final Logger logger = Logger.getLogger(
        Konsultasi.class.getName()
    );
    private static final String ERROR_MSG = "Error terjadi: {0}";
    private String nama;
    private String tempat;

    public Konsultasi(
        String jadwal,
        int durasi,
        String status,
        String nama,
        String tempat
    ) {
        super(jadwal, durasi, status);
        this.nama = nama;
        this.tempat = tempat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public void melakukanPenjadwalan() {
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            String tanggal = br.readLine();
            int lama = br.read();
            setJadwal(tanggal);
            setDurasi(lama);
            logger.log(
                Level.INFO,
                "Jadwal konsultasi: {0}, durasi: {1}%n",
                new Object[] { getJadwal(), getDurasi() }
            );
        } catch (IOException e) {
            logger.log(Level.SEVERE, ERROR_MSG, e.getMessage());
        }
    }

    public void mengaturTempat() {
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            String lokasi = br.readLine();
            setTempat(lokasi);
            logger.log(Level.INFO, "Tempat konsultasi: {0}%n", getTempat());
        } catch (IOException e) {
            logger.log(Level.SEVERE, ERROR_MSG, e.getMessage());
        }
    }

    public void menentukanTutor() {
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            String tutor = br.readLine();
            setNama(tutor);
            logger.log(
                Level.INFO,
                "Tutor yang akan dijadwalkan: {0}%n",
                getNama()
            );
        } catch (IOException e) {
            logger.log(Level.SEVERE, ERROR_MSG, e.getMessage());
        }
    }

    public void menentukanTopik() {
        try {
            BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
            );
            String topik = br.readLine();
            logger.log(Level.INFO, "membahas tentang : {0}%n", topik);
        } catch (IOException e) {
            logger.log(Level.SEVERE, ERROR_MSG, e.getMessage());
        }
    }
}
