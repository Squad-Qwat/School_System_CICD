/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Aktivitas;

import com.mycompany.datadiri.UserPelajar;
import com.mycompany.utils.InputUtils;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author timot
 */
public class Diskusi extends Aktivitas {

    private static final Logger logger = Logger.getLogger(
        Diskusi.class.getName()
    );

    private String ruang;
    private int waktuDiskusi;

    public Diskusi(
        String jadwal,
        int durasi,
        String status,
        String ruang,
        int waktuDiskusi
    ) {
        super(jadwal, durasi, status);
        this.ruang = ruang;
        this.waktuDiskusi = waktuDiskusi;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public void setWaktuDiskusi(int waktuDiskusi) {
        this.waktuDiskusi = waktuDiskusi;
    }

    public void MulaiDiskusi() {
        setAktivitas("Mulai");
        // Hanya dijalankan ketika aktivitas dimulai dan ada pelajarnya
        if (MulaiAktivitas()) {
            Scanner scan = InputUtils.getScanner();
            try {
                setJadwal(scan.nextLine());
                setRuang(scan.nextLine());
                if (scan.hasNextInt()) {
                    setWaktuDiskusi(scan.nextInt());
                    scan.nextLine();
                }
                logger.log(
                    Level.INFO,
                    "Diskusi dilaksanakan tanggal {0}, ruang {1}, dan waktu {2} jam%n",
                    new Object[] { jadwal, ruang, waktuDiskusi }
                );
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
            }
        } else {
            logger.info("Diskusi tidak dimulai");
        }
    }

    public void TutupDiskusi() {
        setAktivitas("Selesai");
        // Hanya dijalankan ketika aktivitas dimulai dan ada pelajarnya
        if (SelesaiAktivitas()) {
            Scanner scan = InputUtils.getScanner();
            try {
                setJadwal(scan.nextLine());
                if (scan.hasNextInt()) {
                    setDurasi(scan.nextInt());
                    scan.nextLine();
                }
                logger.log(
                    Level.INFO,
                    "Diskusi berakhir pada tanggal {0}, di ruang {1}, dan waktu {2} jam, dengan durasi selama {3} jam%n",
                    new Object[] { jadwal, ruang, waktuDiskusi, durasi }
                );
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
            }
        } else {
            logger.info("Diskusi belum selesai");
        }
    }

    public void MenjawabPertanyaan() {
        Scanner scan = InputUtils.getScanner();
        try {
            UserPelajar up = new UserPelajar(
                scan.nextLine(),
                scan.nextLine(),
                scan.nextLine(),
                scan.nextLine(),
                scan.hasNextInt() ? scan.nextInt() : 0,
                scan.nextLine(),
                scan.nextLine(),
                scan.nextLine()
            );
            if (scan.hasNextLine()) scan.nextLine(); // consume leftover
            logger.log(
                Level.INFO,
                "Selama {0} jam, {1} bisa menjawab pertanyaan",
                new Object[] { waktuDiskusi, up.getNama() }
            );
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error terjadi: {0}", e.getMessage());
        }
    }
}
